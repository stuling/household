package main.org.stuling.expeditors.census;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A class to hold the input list
 * In this case, a List<Occupant>
 */
public class OccupantListInput {

    /**
     * Parses CSV file and creates List<Occupant> for input
     * @return List<Occupant>
     */
    static List<Occupant> getOccupantListFromCSV() {

        try {
            File file = new File("input.csv");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            List<Occupant> occupantList = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                // split on comma(',' and handle the comma inside a field case)
                String[] occupantCsv = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

                // create address object to store 3 address fields from csv
                // cleans up double-quotes
                Address address = new Address(occupantCsv[2].replace("\"", ""),occupantCsv[3].replace("\"", ""),occupantCsv[4].replace("\"", ""));

                // populate the occupant object with 3 fields plus address
                // Note: age is parseInt from String, cleans up double-quotes
                Occupant occupant = new Occupant(occupantCsv[0].replace("\"", ""),occupantCsv[1].replace("\"", ""),address,Integer.parseInt(occupantCsv[5].replace("\"", "")));

                // adding occupant objects to a list
                occupantList.add(occupant);
            }
            return occupantList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Used for creating test data that matches the List<Occupant> data structure
     * generated from CSV and required for input in Main(). Can be used in Main()
     * or in test classes.
     * @return List<Occupant>
     */
    static public List<Occupant> getOccupantListFromTestData() {
        List<Occupant> occupants = new ArrayList<>(Arrays.asList(
                new Occupant("Dave", "Smith", new Address("123 main st.", "seattle", "wa"), 43),
                new Occupant("Alice", "Smith", new Address("123 Main St.", "Seattle", "WA"), 45),
                new Occupant("Bob", "Williams", new Address("234 2nd Ave.", "Tacoma", "WA"), 26),
                new Occupant("Carol", "Johnson", new Address("234 2nd Ave", "Seattle", "WA"), 67),
                new Occupant("Eve", "Smith", new Address("234 2nd Ave.", "Tacoma", "WA"), 25),
                new Occupant("Frank", "Jones", new Address("234 2nd Ave.", "Tacoma", "FL"), 23),
                new Occupant("George", "Brown",new Address( "345 3rd Blvd., Apt. 200", "Seattle", "WA"), 18),
                new Occupant("Helen", "Brown", new Address("345 3rd Blvd. Apt. 200", "Seattle", "WA"), 18),
                new Occupant("Ian", "Smith", new Address("123 main st ", "Seattle", "Wa"), 18),
                new Occupant("Jane", "Smith", new Address("123 Main St.", "Seattle", "WA"), 13)
        ));
        return occupants;
    }
}
