import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class DarkFlatFieldSubtraction {
public void extra(String path){
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

    Mat deepSpaceImage = Imgcodecs.imread(path);
    Mat darkFrame = Imgcodecs.imread("./image/dark_flat_frame.jpg");
    Mat flatFieldFrame = Imgcodecs.imread("./image/flat.jpg");

    Mat resizedDarkFrame = resizeImage(darkFrame, deepSpaceImage.size());
    Mat resizedFlatFieldFrame = resizeImage(flatFieldFrame, deepSpaceImage.size());

    Mat calibratedImage = subtractDarkFlatField(deepSpaceImage, resizedDarkFrame, resizedFlatFieldFrame);

    Imgcodecs.imwrite("dark_flat_field_image.jpg", calibratedImage);

    System.out.println("Dark flat field subtraction completed.");
}
    public static void main(String[] args) {
       
    }

    private static Mat resizeImage(Mat image, Size newSize) {
        Mat resizedImage = new Mat();
        Imgproc.resize(image, resizedImage, newSize);
        return resizedImage;
    }

    private static Mat subtractDarkFlatField(Mat deepSpaceImage, Mat darkFrame, Mat flatFieldFrame) {
        Mat calibratedImage = new Mat();
        Core.subtract(deepSpaceImage, darkFrame, calibratedImage);
        Core.divide(calibratedImage, flatFieldFrame, calibratedImage);
        return calibratedImage;
    }
}
