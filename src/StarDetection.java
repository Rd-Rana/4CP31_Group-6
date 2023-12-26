import org.opencv.core.*;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class StarDetection{
    public void extra(String path){
        System.out.println("Started");

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat src = Imgcodecs.imread(path, Imgcodecs.IMREAD_GRAYSCALE);

        Mat logResult = new Mat();
        Imgproc.GaussianBlur(src, logResult, new Size(0, 0), 2.0);
        Imgproc.Laplacian(logResult, logResult, CvType.CV_16S, 3, 1, 0);
        Core.convertScaleAbs(logResult, logResult);

        Mat binary = new Mat();                                                                                                                                             
        Imgproc.threshold(logResult, binary, 20, 255, Imgproc.THRESH_BINARY);

        Mat labels = new Mat();
        Mat stats = new Mat();
        Mat centroids = new Mat();
        Imgproc.connectedComponentsWithStats(binary, labels, stats, centroids);

        for (int i = 1; i < stats.rows(); i++) {
            double[] centroid = centroids.get(i, 0);
            int x = (int) centroid[0];
            int y = (int) centroid[1];
            Imgproc.circle(src, new Point(x, y), 5, new Scalar(0, 0, 255), -1);
        }

        // Save the result
        Imgcodecs.imwrite("output.jpg", src);
    }
    public static void main(String[] args) {
        StarDetection s=new StarDetection();
        s.extra("C:\\Users\\DC\\Documents\\NetBeansProjects\\try\\gray_space_image.jpg");
    }
}