import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class DeepSpaceToGrayScale {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat deepSpaceImage = Imgcodecs.imread("G:\\try\\calibrated_dark_subtracted_image.jpg", Imgcodecs.IMREAD_COLOR);

        if (deepSpaceImage.empty()) {
            System.err.println("Error: Could not load the image.");
            System.exit(1);
        }

        Mat grayscaleImage = new Mat();
        Imgproc.cvtColor(deepSpaceImage, grayscaleImage, Imgproc.COLOR_BGR2GRAY);

        Imgcodecs.imwrite("grayscale_image.jpg", grayscaleImage);

        System.out.println("Conversion to grayscale completed.");
    }
}
