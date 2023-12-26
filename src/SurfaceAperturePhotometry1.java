import java.util.ArrayList;
import java.util.List;

public class SurfaceAperturePhotometry1 {

    public static void main(String[] args) {
        // Sample data: flux values and aperture radii
        List<Double> fluxValues = new ArrayList<>();
        fluxValues.add(1000.0); // Flux within the innermost aperture
        fluxValues.add(800.0);  // Flux within the second aperture
        fluxValues.add(600.0);  // Flux within the third aperture
        List<Double> apertureRadii = new ArrayList<>();
        apertureRadii.add(5.0);  // Radius of the innermost aperture
        apertureRadii.add(10.0); // Radius of the second aperture
        apertureRadii.add(15.0); // Radius of the third aperture

        // Calculate surface brightness values
        List<Double> surfaceBrightness = calculateSurfaceBrightness(fluxValues, apertureRadii);

        // Display the results
        for (int i = 0; i < fluxValues.size(); i++) {
            System.out.println("Surface Brightness at Radius " + apertureRadii.get(i) + ": " + surfaceBrightness.get(i));
        }
    }

    public static List<Double> calculateSurfaceBrightness(List<Double> fluxValues, List<Double> apertureRadii) {
        if (fluxValues.size() != apertureRadii.size()) {
            throw new IllegalArgumentException("The number of flux values and aperture radii must be the same.");
        }

        List<Double> surfaceBrightness = new ArrayList<>();

        for (int i = 0; i < fluxValues.size(); i++) {
            double flux = fluxValues.get(i);
            double apertureRadius = apertureRadii.get(i);

            // Calculate the surface brightness by dividing the flux by the area of the aperture
            double surfaceBrightnessValue = flux / (Math.PI * Math.pow(apertureRadius, 2));
            surfaceBrightness.add(surfaceBrightnessValue);
        }

        return surfaceBrightness;
    }
}