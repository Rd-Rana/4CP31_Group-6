import java.util.ArrayList;
import java.util.List;

public class AbsoluteAperturePhotometry1 {

    public static void main(String[] args) {
        // Sample data: flux values, aperture areas, and standard star flux
        List<Double> fluxValues = new ArrayList<>();
        fluxValues.add(1000.0); // Flux from the object
        List<Double> apertureAreas = new ArrayList<>();
        apertureAreas.add(1.0); // Aperture area for the object
        double standardStarFlux = 500.0; // Flux from the standard star

        // Calculate absolute fluxes
        List<Double> absoluteFluxes = calculateAbsoluteFluxes(fluxValues, apertureAreas, standardStarFlux);

        // Display the results
        for (int i = 0; i < fluxValues.size(); i++) {
            System.out.println("Absolute Flux " + (i + 1) + ": " + absoluteFluxes.get(i));
        }
    }

    public static List<Double> calculateAbsoluteFluxes(List<Double> fluxValues, List<Double> apertureAreas, double standardStarFlux) {
        if (fluxValues.size() != apertureAreas.size()) {
            throw new IllegalArgumentException("The number of flux values and aperture areas must be the same.");
        }

        List<Double> absoluteFluxes = new ArrayList<>();

        for (int i = 0; i < fluxValues.size(); i++) {
            double flux = fluxValues.get(i);
            double apertureArea = apertureAreas.get(i);

            // Calculate the absolute flux by multiplying the relative flux by the standard star flux
            double absoluteFlux = flux / apertureArea * standardStarFlux;
            absoluteFluxes.add(absoluteFlux);
        }

        return absoluteFluxes;
    }
}