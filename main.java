// import ReadCSV;
// import cact1.util.MapValues;
// import cact1.util.LinearRegression;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        ReadCSV RCSV = new ReadCSV();
        csv csv = new csv();
        LR lr = new LR();

        while (true) {
            // Display menu
            System.out.println("\nMenu:");
            System.out.println("1. Read the CSV File");
            System.out.println("2. Map");
            System.out.println("3. Linear Regression and Accuracy");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            // Read user choice
            int choice = scanner.nextInt();
            
            // Perform action based on user choice
            switch (choice) {
                case 1:
                    RCSV.ReadCSV(); // Call the read() method from the ReadCSV class
                    break;
                case 2:
                    csv.csv(); // Call the csv() method from the MapValues class
                    break;
                case 3:
                    lr.LR(); // Call the LR() method from the LinearRegression class
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
