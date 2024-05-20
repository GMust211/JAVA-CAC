import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LR {
    public void LR() {
        // Path to your CSV file
        String csvFile = "insurance_n.csv";
        
        try {
            // Read the CSV file
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            String line;
            List<Double> xValues = new ArrayList<>();
            List<Double> yValues = new ArrayList<>();
            
            // Skip the header line if present
            reader.readLine();
            
            // Read each line and extract data points
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                double x = Double.parseDouble(values[0]); // Assuming first column is X
                double y = Double.parseDouble(values[1]); // Assuming second column is Y
                xValues.add(x);
                yValues.add(y);
            }
            
            // Calculate mean of X and Y values
            double xMean = calculateMean(xValues);
            double yMean = calculateMean(yValues);
            
            // Calculate coefficients
            double numerator = 0;
            double denominator = 0;
            for (int i = 0; i < xValues.size(); i++) {
                numerator += (xValues.get(i) - xMean) * (yValues.get(i) - yMean);
                denominator += Math.pow(xValues.get(i) - xMean, 2);
            }
            double slope = numerator / denominator;
            double intercept = yMean - slope * xMean;
            
            // Calculate R-squared
            double rSquared = calculateRSquared(xValues, yValues, slope, intercept);
            
            // Print the coefficients and R-squared
            System.out.println("Intercept: " + intercept);
            System.out.println("Slope: " + slope);
            System.out.println("R-squared: " + rSquared);
            
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Helper method to calculate mean
    private static double calculateMean(List<Double> values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.size();
    }
    
    // Helper method to calculate R-squared
    private static double calculateRSquared(List<Double> xValues, List<Double> yValues, double slope, double intercept) {
        double ssr = 0; // sum of squared residuals
        double sst = 0; // total sum of squares
        double yMean = calculateMean(yValues);
        
        for (int i = 0; i < xValues.size(); i++) {
            double predictedY = slope * xValues.get(i) + intercept;
            ssr += Math.pow(predictedY - yMean, 2);
            sst += Math.pow(yValues.get(i) - yMean, 2);
        }
        
        return ssr / sst;
    }
}
