import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.lang.System.exit;

public class Rent {
    public static void main(String[] args) throws IOException {
        int command = 1;
        Order order = null;
        String idt = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-r")) {
                command = 1;
            } else if (args[i].equals("-a")) {
                if (args.length < 5) {
                    System.err.println("usage: java Rent -a ID START DURTN PRICE");
                    exit(1);
                } else {
                    command = 2;
                    idt = args[i + 1];
                    int start = Integer.parseInt(args[i + 2]);
                    int durn = Integer.parseInt(args[i + 3]);
                    int bid = Integer.parseInt(args[i + 4]);
                    order = new Order(idt, start, durn, bid);
                }
            } else if (args[i].equals("-d")) if (args.length < 2) {
                System.err.println("usage: Java Rent -d ID");
                exit(1);
            } else {
                command = 3;
                idt = args[i + 1];
            }
        }
        List<Order> orders;
        orders = new ArrayList<Order>();
        String fileName = System.getenv("LAGS_ORDER_FILE");
        if (fileName == null) {
            System.err.println("wich file ? set LAGS_ORDER_FILE var");
            exit(1);
        }
        try {
            CSVReader reader = new CSVReaderBuilder(new FileReader(fileName)).build();
            CSVIterator iterator = new CSVIterator(reader);
            boolean isFirstLine = true;
            for (CSVIterator it = iterator; it.hasNext(); ) {
                String[] line = it.next();
                if(! isFirstLine) {
                    idt = line[0];
                    int start = Integer.parseInt(line[1]);
                    int durn = Integer.parseInt((line[2]));
                    int bid = Integer.parseInt(line[3]);
                    Order o = new Order(idt, start, durn, bid);
                    orders.add(o);
                }
                isFirstLine = false;
            }
        } catch (IOException e) {
            System.err.println("problem reading file " + fileName );
            exit(1);
        } catch (CsvValidationException e) {
            System.err.println("wrong csv format in file " + fileName);
            exit(1);
        }
        switch (command) {
            case 1 :
                Lags lags = new Lags(orders);
                int r = lags.revenue();
                System.out.println(r);
                break;
            case 2 :
                orders.add(order);
                saveOrders(orders, fileName);
                break;
            case 3 :
                final String id = idt;
                Predicate<Order> pr = o-> (o.getId().equals(id));
                orders.removeIf(pr);
                saveOrders(orders, fileName);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }

        exit(0);
    }

    private static void saveOrders(List<Order> orders, String fileName) throws IOException {
        String[] line = new String[4];
        CSVWriter writer = null;
        try {
            writer = new CSVWriter(new FileWriter(fileName), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.RFC4180_LINE_END);
            line = "Id,Start,Duration,Price".split(",");
            writer.writeNext(line);
            for (Order o : orders) {
                line[0] = o.getId();
                line[1] = String.valueOf(o.getStart());
                line[2] = String.valueOf(o.getDuration());
                line[3] = String.valueOf(o.getPrice());
                writer.writeNext(line);
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("problem writing file: " + fileName);
            exit(1);
        }
    }
}