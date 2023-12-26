import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class PixelMagnitudeCalculator {

    public static void main(String[] args) {
        // Sample data: flux values, reference flux, and reference magnitude
        List<Double> fluxValues = new ArrayList<>();
        fluxValues.add(1000.0); // Flux for pixel 1
        fluxValues.add(500.0);  // Flux for pixel 2
        double referenceFlux = 1000.0; // Reference flux for the reference star
        double referenceMagnitude = 10.0; // Reference magnitude for the reference star

        // Calculate pixel magnitudes
        List<Double> pixelMagnitudes = calculatePixelMagnitudes(fluxValues, referenceFlux, referenceMagnitude);

        // Display the results
        for (int i = 0; i < fluxValues.size(); i++) {
            System.out.println("Magnitude for Pixel " + (i + 1) + ": " + pixelMagnitudes.get(i));
        }
    }

    public static List<Double> calculatePixelMagnitudes(List<Double> fluxValues, double referenceFlux, double referenceMagnitude) {
        List<Double> pixelMagnitudes = new ArrayList<>();

        for (int i = 0; i < fluxValues.size(); i++) {
            double flux = fluxValues.get(i);

            // Calculate the magnitude using the formula
            double magnitude = -2.5 * Math.log10(flux / referenceFlux) + referenceMagnitude;
            pixelMagnitudes.add(magnitude);
        }

        return pixelMagnitudes;
    }
}