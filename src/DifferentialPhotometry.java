import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class DifferentialPhotometry {
    public double estimateMagnitude(double f,double f1){
                      System.out.println(f);                      System.out.println(f1);                                
                                

        double differentialstarMagnitude = -2.5 * Math.log10(f / f1);
return differentialstarMagnitude;
    }
   public void extra(String path){
       StarFluxCalculator s1=new StarFluxCalculator();
   double arr[]=s1.fluxes(path);
//   for(int i=0;i<arr.length;i++){
//       System.out.println(arr[i]);
//   }
   
   Arrays.sort(arr);
   StarFluxCalculator f = new StarFluxCalculator();
   double flux = f.returnflux(3121,119);//Temporory values
   int index = Arrays.binarySearch(arr, flux);
   double flux1=arr[index+1000];
   double flux2=arr[index-1];
//   double differentialstarMagnitude = -2.5 * Math.log10(flux / flux1);
double ans=estimateMagnitude(flux, flux1);

System.out.println("diffrential magnitude : " +ans);
   
//   System.out.println("Sorted Double Array: " + Arrays.toString(arr)); 
   }
    public static void main(String[] args) {
       DifferentialPhotometry d1=new DifferentialPhotometry();
       d1.extra("D:\\Project\\image\\gray_space_image.jpg");
    }
}