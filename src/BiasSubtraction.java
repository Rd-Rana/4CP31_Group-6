import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
//import org.opencv.highgui.HighGui;
public class BiasSubtraction {
    public void extra(String path) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat deepSpaceImage = Imgcodecs.imread(path);
        Mat biasFrame = Imgcodecs.imread("./image/bias_frame.jpg");

        Mat resizedBiasFrame = resizeBiasFrame(biasFrame, deepSpaceImage.size());

        Mat calibratedImage = subtractBias(deepSpaceImage, resizedBiasFrame);
        

        Imgcodecs.imwrite("./image/calibrated_bias_image.jpg", calibratedImage);
//        HighGui.namedWindow("calibratedImage", HighGui.WINDOW_NORMAL);
//        HighGui.imshow("calibratedImage", calibratedImage);
//        HighGui.waitKey(0);

        System.out.println("Bias subtraction completed.");
    }

    public static void main(String[] args) {

    }

    private static Mat resizeBiasFrame(Mat biasFrame, Size newSize) {
        Mat resizedBiasFrame = new Mat();
        Imgproc.resize(biasFrame, resizedBiasFrame, newSize);
        return resizedBiasFrame;
    }

    private static Mat subtractBias(Mat deepSpaceImage, Mat biasFrame) {
        Mat calibratedImage = new Mat();
        Core.subtract(deepSpaceImage, biasFrame, calibratedImage);
        return calibratedImage;
    }
}
