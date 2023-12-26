import org.opencv.core.*;
//import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class DarkFrameSubtraction {
public void extra(){
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat deepSpaceImage = Imgcodecs.imread("D:\\Project\\image\\calibrated_bias_image.jpg");
        Mat darkFrame = Imgcodecs.imread("./image/dark_frame.jpg");

        Mat resizedDarkFrame = resizeDarkFrame(darkFrame, deepSpaceImage.size());

        Mat calibratedImage = subtractDarkFrame(deepSpaceImage, resizedDarkFrame);

        Imgcodecs.imwrite("calibrated_dark_subtracted_image.jpg", calibratedImage);
 Imgcodecs.imwrite("./image/calibrated_bias_image.jpg", calibratedImage);
//        HighGui.namedWindow("calibratedImage", HighGui.WINDOW_NORMAL);
//        HighGui.imshow("calibratedImage", calibratedImage);
//        System.out.println("Dark frame subtraction completed.");
}

    public static void main(String[] args) {
        
    }

    private static Mat resizeDarkFrame(Mat darkFrame, Size newSize) {
        Mat resizedDarkFrame = new Mat();
        Imgproc.resize(darkFrame, resizedDarkFrame, newSize);
        return resizedDarkFrame;
    }

    private static Mat subtractDarkFrame(Mat deepSpaceImage, Mat darkFrame) {
        Mat calibratedImage = new Mat();
        Core.subtract(deepSpaceImage, darkFrame, calibratedImage);
        return calibratedImage;
    }
}
