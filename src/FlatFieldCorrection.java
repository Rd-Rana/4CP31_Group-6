import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class FlatFieldCorrection {
public void extra(String path){
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

    Mat deepSpaceImage = Imgcodecs.imread(path);
    Mat flatFieldFrame = Imgcodecs.imread("./image/flat.jpg");

    Mat resizedFlatFieldFrame = resizeFlatFieldFrame(flatFieldFrame, deepSpaceImage.size());

    Mat calibratedImage = subtractFlatField(deepSpaceImage, resizedFlatFieldFrame);

    Imgcodecs.imwrite("calibrated_flat_image.jpg", calibratedImage);

    System.out.println("Flat field subtraction completed.");
}
    public static void main(String[] args) {
       
    }

    private static Mat resizeFlatFieldFrame(Mat flatFieldFrame, Size newSize) {
        Mat resizedFlatFieldFrame = new Mat();
        Imgproc.resize(flatFieldFrame, resizedFlatFieldFrame, newSize);
        return resizedFlatFieldFrame;
    }

    private static Mat subtractFlatField(Mat deepSpaceImage, Mat flatFieldFrame) {
        Mat calibratedImage = new Mat();
        Core.divide(deepSpaceImage, flatFieldFrame, calibratedImage);
        return calibratedImage;
    }
}
