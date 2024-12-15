package modules.FileProcessor;

import java.io.FileReader;
import com.opencsv.*;
public class FileProcessor {
    public static void readDataLineByLine(String file)
    {


            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);


            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }

    }



}
