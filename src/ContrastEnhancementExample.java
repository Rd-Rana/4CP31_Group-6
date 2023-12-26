import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;


public class ContrastEnhancementExample {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        String inputImagePath ="G:\\\\7th sem\\\\project\\\\New folder\\\\main.tif";
        String outputImagePath = "G:\\\\7th sem\\\\project\\\\New folder\\\\normalized_image.jpg";

        Mat inputImage = Imgcodecs.imread(inputImagePath, Imgcodecs.IMREAD_GRAYSCALE);

        if (!inputImage.empty()) {
            Mat enhancedImage = new Mat();

            // Apply gamma correction for non-linear contrast enhancement
            double gamma = 1.5; // Adjust the gamma value as needed
            Core.pow(inputImage, gamma, enhancedImage);

            // Normalize pixel values to the range [0, 255]
            Core.normalize(enhancedImage, enhancedImage, 0, 255, Core.NORM_MINMAX, CvType.CV_8U);

            Imgcodecs.imwrite(outputImagePath, enhancedImage);
        } else {
            System.out.println("Error: Could not read the input image.");
        }
    }
}
