import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;

public class FalseColorMappingOpenCV {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        String inputImagePath = "C:/Users/DC/Documents/NetBeansProjects/try/src/main.tif";
        String outputImagePath = "output.png";

        Mat originalImage = Imgcodecs.imread(inputImagePath);

        Mat falseColorImage = new Mat(originalImage.rows(), originalImage.cols(), CvType.CV_8UC3);
        long startTime = System.nanoTime();

        for (int y = 0; y < originalImage.rows(); y++) {
            for (int x = 0; x < originalImage.cols(); x++) {
                double[] pixel = originalImage.get(y, x);
                 double intensity = pixel[2];
                 double[] falseColorPixel ;
//
//                // Extract the intensity value (e.g., red channel)
//               
                if (pixel[0]==0 && pixel[1]==0 && pixel[2]==0){
                      falseColorPixel = mapIntensityToRGB(intensity);
                falseColorImage.put(y, x, falseColorPixel);

                }

                 
//                double[] falseColorPixel = mapIntensityToRGB(intensity);
//
            }
        }
long endTime = System.nanoTime();

        long elapsedTime = endTime - startTime;

        double elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000.0;
        System.out.println("Elapsed Time: " + elapsedTimeInSeconds + " seconds");
        Imgcodecs.imwrite(outputImagePath, falseColorImage);
    }

    // Example false color mapping function
    private static double[] mapIntensityToRGB(double intensity) {
        double r = intensity;           // Red channel based on intensity
        double g = 0.0;                 // Green channel
        double b = 255.0 - intensity;   // Blue channel complementary to red
        
        return new double[]{b, g, r};
    }
}
