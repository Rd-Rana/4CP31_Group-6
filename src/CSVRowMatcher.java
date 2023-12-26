import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVRowMatcher {
    public static void main(String args[]){

    }

    public void printRecord(String csvFilePath, String searchValue) {
        try (FileReader reader = new FileReader(csvFilePath);
             CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(reader)) {

            for (CSVRecord record : parser) {
                String columnValue = record.get("Absolute magnitude(Mv)");
                if (searchValue.equals(columnValue)) {
                    System.out.println(record);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}