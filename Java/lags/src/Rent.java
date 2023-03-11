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
            Map<String, String> values = new CSVReaderHeaderAware(new FileReader(fileName)).readMap();
            System.out.println(values);
        } catch (IOException e) {
            System.err.println("problem reading file " + fileName );
            exit(1);
        } catch (CsvValidationException e) {
            System.err.println("wrong csv format in file " + fileName);
            exit(1);
        }


        exit(0);
    }
}