import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

public class AbsolutePhotometry {
    public static void main(String[] args) {

    }

    public static double[] calculateMagnitude(List<Point> starPoints) {
        // Load the deep space image
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat image = Imgcodecs.imread("path_to_your_image.jpg");

        // Convert the image to grayscale
        Mat gray = new Mat();
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);

        // Apply Gaussian blur to reduce noise
        Mat blurred = new Mat();
        Imgproc.GaussianBlur(gray, blurred, new Size(5, 5), 0);

        // Threshold the image to create a binary mask
        Mat binary = new Mat();
        Imgproc.threshold(blurred, binary, 200, 255, Imgproc.THRESH_BINARY);

        // Save the result
        Imgcodecs.imwrite("output.jpg", src);


        // Define the radius for the region around each star
        int radius = 10; // Adjust the radius as needed

        // Initialize variables to store total flux and magnitude
        List<double> flux = new ArrayList<>();
        List<double> magnitude = new ArrayList<>();

        // Iterate through the list of star points
        for (Point starPoint : starPoints) {
            // Create a circular mask for the region around the star
            Mat mask = Mat.zeros(image.size(), CvType.CV_8U);
            Imgproc.circle(mask, starPoint, radius, new Scalar(255, 255, 255), -1);

            // Apply the mask to extract the region around the star
            Mat roi = new Mat();
            image.copyTo(roi, mask);

            // Calculate the flux (sum of pixel values) for the region around the star
            Scalar sum = Core.sumElems(roi);

            // Update the total flux
//            totalFlux += sum.val[0];
            flux.add(sum.val[0]);
            magnitude.add(-2.5 * Math.log10(sum.val[0]));
        }
        return magnitude;
    }
}