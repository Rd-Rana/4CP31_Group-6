import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import java.awt.Point;

import java.util.ArrayList;
import java.util.List;

public class AbsolutePhotometry {
    public double estimateMagnitude(double flux) {
        double magnitude = -2.5 * Math.log10(flux);
        return magnitude;
    }

   

    public static void main(String[] args) {
//        AbsolutePhotometry a1=new AbsolutePhotometry();
//       a1.extra1("D:\\Project\\image\\gray_space_image.jpg");
    }

    void extra1(String text) {
        StarFluxCalculator f = new StarFluxCalculator();
        double flux = f.returnflux(755,2);//Temporory values
        double ans=estimateMagnitude(flux); 
        System.out.print(ans);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}