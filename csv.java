import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class csv {
    public void csv() {
        try {
            File file = new File("insurance.csv");
            Scanner reader = new Scanner(file);

            File myfile = new File("insurance_n.csv");
            FileWriter writer = new FileWriter(myfile, true);

            String gender = "";
            String smoker = "";
            String direction = "";

            if (reader.hasNextLine()) {
                reader.nextLine();
            }

            while (reader.hasNextLine()) {

                String data = reader.nextLine();
                String[] parts = data.split(",");

                if (parts[1].equals("female")) {
                    gender = "0";
                } else if (parts[1].equals("male")) {
                    gender = "1";
                }

                if (parts[4].equals("yes")) {
                    smoker = "1";
                } else if (parts[4].equals("no")) {
                    smoker = "0";
                }
                
                if (parts[5].equals("southwest")) {
                    direction = "1";
                } else if (parts[5].equals("southeast")) {
                    direction = "2";
                } else if (parts[5].equals("northwest")) {
                    direction = "3";
                } else if (parts[5].equals("northeast")) {
                    direction = "4";
                }
            

                writer.write(parts[0] + ',' + gender + ',' + parts[2] + ',' + parts[3] + ',' + smoker + ',' + direction
                        + ',' + parts[6] + "\n");
            }
            reader.close();
            writer.close();
        } catch (Exception e) {
            System.out.println("shgavah");
            e.printStackTrace();
        }

    }
}
