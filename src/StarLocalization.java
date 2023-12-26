import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.opencv.imgproc.Moments;

public class StarLocalization {
    public List<Point> extra(String path){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
System.out.println("started");
      
        Mat src = Imgcodecs.imread(path);

      
        Mat gray = new Mat();
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);

        Mat blurred = new Mat();
        Imgproc.GaussianBlur(gray, blurred, new Size(5, 5), 0);

        // Threshold the image to create a binary mask
        Mat binary = new Mat();
        Imgproc.threshold(blurred, binary, 200, 255, Imgproc.THRESH_BINARY);

        // Find contours in the binary image
        List<MatOfPoint> contours = new ArrayList<>();
        Imgproc.findContours(binary, contours, new Mat(), Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

List<Point> starPoints = new ArrayList<>();
        // Calculate centroids of detected stars
        for (MatOfPoint contour : contours) {
            // Calculate the centroid of the contour
            Moments moments = Imgproc.moments(contour);
            int cx = (int) (moments.m10 / moments.m00);
            int cy = (int) (moments.m01 / moments.m00);
             starPoints.add(cx, cy);

            // Draw a marker at the centroid
            Imgproc.circle(src, new Point(cx, cy), 5, new Scalar(0, 0, 255), -1);
        }

        // Save the result
        Imgcodecs.imwrite("output.jpg", src);
        return starPoints;
    }
    public static void main(String[] args) {
     StarLocalization sc=new  StarLocalization();
     sc.extra("D:\\Project\\image\\gray_space_image.jpg");
  
    }
}