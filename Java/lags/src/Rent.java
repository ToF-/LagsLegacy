import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.System.exit;

public class Rent {
    public static void main(String[] args)  {
        int command = 1;
        for(int i = 0; i < args.length; i++)
            if (args[i].equals("-r")) {
                command = 1;
            } else if (args[i].equals("-a")) {
                if (args.length < 5) {
                    System.err.println("usage: java Rent -a ID START DURTN PRICE");
                    exit(1);
                }
                else {
                    command = 2;
                }
            } else if (args[i].equals("-d")) if (args.length < 3) {
                System.err.println("usage: Java Rent -d ID");
                exit(1);
            }
        else {
                command = 3;
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
                    String idt = line[0];
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
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }

        exit(0);
    }
}