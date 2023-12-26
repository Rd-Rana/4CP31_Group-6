import java.util.List;

public class RelativeAperturePhotometry1 {

    public static void main(String[] args) {
        // Sample data: flux values and aperture areas
        List<Double> fluxValues = new ArrayList<>();
        fluxValues.add(1000.0); // Flux from the object
        fluxValues.add(200.0);  // Flux from the reference/background
        List<Double> apertureAreas = new ArrayList<>();
        apertureAreas.add(1.0); // Aperture area for the object
        apertureAreas.add(2.0); // Aperture area for the reference/background

        // Calculate relative fluxes
        List<Double> relativeFluxes = calculateRelativeFluxes(fluxValues, apertureAreas);

        // Display the results
        for (int i = 0; i < fluxValues.size(); i++) {
            System.out.println("Relative Flux " + (i + 1) + ": " + relativeFluxes.get(i));
        }
    }

    public static List<Double> calculateRelativeFluxes(List<Double> fluxValues, List<Double> apertureAreas) {
        if (fluxValues.size() != apertureAreas.size()) {
            throw new IllegalArgumentException("The number of flux values and aperture areas must be the same.");
        }

        List<Double> relativeFluxes = new ArrayList<>();

        for (int i = 0; i < fluxValues.size(); i++) {
            double flux = fluxValues.get(i);
            double apertureArea = apertureAreas.get(i);

            // Calculate the relative flux by dividing the flux by the aperture area
            double relativeFlux = flux / apertureArea;
            relativeFluxes.add(relativeFlux);
        }

        return relativeFluxes;
    }
}