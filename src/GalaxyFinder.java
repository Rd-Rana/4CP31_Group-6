//import org.opencv.core.*;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;
//import org.opencv.highgui.HighGui;
//import java.util.ArrayList;
//import java.util.List;
//
//public class GalaxyFinder {
//
//    public static final double MIN_GALAXY_AREA = 100;
//    public static final int GALAXY_COLOR = Imgproc.COLOR_BGR2GRAY;
//
//    public static void main(String[] args) {
//        // Replace this with your image path
//        String imagePath = "D:\\Project\\src\\output.png";
//
//        // Load the image
//        Mat image = Imgcodecs.imread(imagePath);
//
//        // Convert the image to grayscale
//        Mat grayImage = new Mat();
//        Imgproc.cvtColor(image, grayImage, GALAXY_COLOR);
//
//        // Apply Gaussian blur to smooth the image
//        Imgproc.GaussianBlur(grayImage, grayImage, new Size(5, 5), 0);
//
//        // Identify potential galaxies using thresholding
//        Mat binaryImage = new Mat();
//        Imgproc.threshold(grayImage, binaryImage, 127, 255, Imgproc.THRESH_BINARY_INV);
//
//        // Find contours in the binary image
//        List<MatOfPoint> contours = new ArrayList<>();
//        Mat hierarchy = new Mat();
//        Imgproc.findContours(binaryImage, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
//
//        // Filter contours based on size and circularity
//        for (int i = 0; i < contours.size(); i++) {
//            double area = Imgproc.contourArea(contours.get(i));
//
//            if (area < MIN_GALAXY_AREA) {
//                continue;
//            }
//
//            // Check circularity using compactness
//            double compactness = 4 * Math.PI * area / Math.pow(Imgproc.arcLength(contours.get(i), true), 2);
//
//            if (compactness > 0.8) {
//                // Draw the identified galaxy on the original image
//                Imgproc.drawContours(image, contours, i, new Scalar(255, 0, 0), 2);
//            }
//        }
//
//        // Show the image with identified galaxies
//       HighGui.imshow("Identified Galaxies", image);
//        HighGui.waitKey(0);
//
//    }
//}
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.CvType;
import java.util.ArrayList;
import java.util.List;
import org.opencv.highgui.HighGui;

public class GalaxyFinder {

    public static final double MIN_GALAXY_AREA = 100;
    public static final int GALAXY_COLOR = Imgproc.COLOR_BGR2GRAY;

    public static void main(String[] args) {
        // Load the OpenCV native library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Replace this with your image path
        String imagePath ="C:\\Users\\DC\\Downloads\\WhatsApp Image 2023-12-08 at 8.30.27 PM.jpeg";

        // Load the image
        Mat image = Imgcodecs.imread(imagePath);

        // Convert the image to grayscale
        Mat grayImage = new Mat();
        Imgproc.cvtColor(image, grayImage, GALAXY_COLOR);

        // Apply Gaussian blur to smooth the image
        Imgproc.GaussianBlur(grayImage, grayImage, new Size(5, 5), 0);

        // Identify potential galaxies using thresholding
        Mat binaryImage = new Mat();
        Imgproc.threshold(grayImage, binaryImage, 127, 255, Imgproc.THRESH_BINARY_INV);

        // Find contours in the binary image
        List<MatOfPoint> contours = new ArrayList<>();
        Mat hierarchy = new Mat();
        Imgproc.findContours(binaryImage, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

        // Filter contours based on size and circularity
        for (int i = 0; i < contours.size(); i++) {
            double area = Imgproc.contourArea(contours.get(i));

            if (area < MIN_GALAXY_AREA) {
                continue;
            }

            // Convert MatOfPoint to MatOfPoint2f
            MatOfPoint2f contours2f = new MatOfPoint2f();
            contours.get(i).convertTo(contours2f, CvType.CV_32F);

            // Check circularity using compactness
            double compactness = 4 * Math.PI * area / Math.pow(Imgproc.arcLength(contours2f, true), 2);

            if (compactness > 0.8) {
                // Draw the identified galaxy on the original image
                Imgproc.drawContours(image, contours, i, new Scalar(255, 0, 0), 2);
            }
        }

        // Show the image with identified galaxies
        HighGui.imshow("Identified Galaxies", image);
        HighGui.waitKey(0);
        HighGui.destroyAllWindows();
    }
}
