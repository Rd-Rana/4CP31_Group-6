import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class RelativePhotometry {
    String[] row;
//    public void readcsv(){
//        String csvFile = "D:\\Project\\src\\6 class csv (1).csv";
//
//        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
//            List<String[]> csvData = reader.readAll();
//
//            
//            String[] headers = csvData.get(0);
//
//            // Specify the column index you want to read
//            int columnIndexToRead = 4; // Change this to the desired column index
//
//            // Iterate through the rows and print the values of the specified column
//            for (int i = 1; i < csvData.size(); i++) {
//                 row = csvData.get(i);
//                if (columnIndexToRead < row.length) {
//                    System.out.println(headers[columnIndexToRead] + ": " + row[columnIndexToRead]);
//                }
//            }
//        } catch (IOException | CsvException e) {
//            e.printStackTrace();
//        }
//    }
        public double estimateMagnitude(double f,double f1){
        double RelativeMagnitude = -2.5 * Math.log10(f / f1);
return RelativeMagnitude;
    }
   public void extra(String path){
       double m=5;
double te=-1*0.4*m;
       double flux1=Math.pow(10,te) ;
       StarFluxCalculator f = new StarFluxCalculator();
       
   double flux = f.returnflux(755,2);//Temporory values
   
//   double differentialstarMagnitude = -2.5 * Math.log10(flux / flux1);
double ans=estimateMagnitude(flux, flux1);

System.out.println(ans);
   
//   System.out.println("Sorted Double Array: " + Arrays.toString(arr)); 
   }
    public static void main(String[] args) {
        
        RelativePhotometry r1=new RelativePhotometry();
//        r1.readcsv();
        r1.extra("D:\\Project\\image\\gray_space_image.jpg");
    }
}