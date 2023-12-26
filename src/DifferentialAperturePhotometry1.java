import java.util.ArrayList;
import java.util.List;

public class DifferentialAperturePhotometry1 {

    public static void main(String[] args) {
        // Sample data: flux values and aperture areas
        List<Double> targetFluxValues = new ArrayList<>();
        targetFluxValues.add(1000.0); // Flux from the target object
        List<Double> comparisonFluxValues = new ArrayList<>();
        comparisonFluxValues.add(500.0); // Flux from the comparison star
        List<Double> targetApertureAreas = new ArrayList<>();
        targetApertureAreas.add(1.0); // Aperture area for the target object
        List<Double> comparisonApertureAreas = new ArrayList<>();
        comparisonApertureAreas.add(1.0); // Aperture area for the comparison star

        // Calculate differential flux
        double differentialFlux = calculateDifferentialFlux(targetFluxValues, targetApertureAreas, comparisonFluxValues, comparisonApertureAreas);

        // Display the result
        System.out.println("Differential Flux: " + differentialFlux);
    }

    public static double calculateDifferentialFlux(List<Double> targetFluxValues, List<Double> targetApertureAreas, List<Double> comparisonFluxValues, List<Double> comparisonApertureAreas) {
        if (targetFluxValues.size() != targetApertureAreas.size() || comparisonFluxValues.size() != comparisonApertureAreas.size()) {
            throw new IllegalArgumentException("The number of flux values and aperture areas must be the same for both target and comparison objects.");
        }

        if (targetFluxValues.size() != comparisonFluxValues.size()) {
            throw new IllegalArgumentException("The number of target and comparison objects must be the same.");
        }

        double totalTargetFlux = 0.0;
        double totalComparisonFlux = 0.0;

        for (int i = 0; i < targetFluxValues.size(); i++) {
            double targetFlux = targetFluxValues.get(i);
            double targetApertureArea = targetApertureAreas.get(i);
            double comparisonFlux = comparisonFluxValues.get(i);
            double comparisonApertureArea = comparisonApertureAreas.get(i);

            // Calculate the flux for the target and comparison objects
            double targetFluxInAperture = targetFlux / targetApertureArea;
            double comparisonFluxInAperture = comparisonFlux / comparisonApertureArea;

            // Accumulate the flux for both objects
            totalTargetFlux += targetFluxInAperture;
            totalComparisonFlux += comparisonFluxInAperture;
        }

        // Calculate the differential flux
        double differentialFlux = totalTargetFlux - totalComparisonFlux;

        return differentialFlux;
    }
}