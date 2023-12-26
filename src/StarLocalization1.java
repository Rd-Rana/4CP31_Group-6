
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;
import org.opencv.imgproc.Moments;

public class StarLocalization1 {
    public List<Point> starCoordinates = new ArrayList<>();

    public List<Point> extra(String path) {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat src = Imgcodecs.imread(path);

        Mat gray = new Mat();
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);

        Mat blurred = new Mat();
        Imgproc.GaussianBlur(gray, blurred, new Size(5, 5), 0);

        Mat binary = new Mat();
        Imgproc.threshold(blurred, binary, 200, 255, Imgproc.THRESH_BINARY);

        List<MatOfPoint> contours = new ArrayList<>();
        Imgproc.findContours(binary, contours, new Mat(), Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

        for (MatOfPoint contour : contours) {
            Moments moments = Imgproc.moments(contour);
            int cx = (int) (moments.m10 / moments.m00);
            int cy = (int) (moments.m01 / moments.m00);

            starCoordinates.add(new Point(cx, cy));

            Imgproc.circle(src, new Point(cx, cy), 5, new Scalar(0, 0, 255), -1);
        }

        for (Point coordinate : starCoordinates) {
            System.out.println("Star Coordinate: (" + coordinate.x + ", " + coordinate.y + ")");
        }

        Imgcodecs.imwrite("output.jpg", src);
        return starCoordinates;
    }

    public static void main(String[] args) {

    }
}