package main.org.stuling.expeditors.census;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Households {


    /**
     * Using a TreeMap to keep households sorted
     */
    private Map<String, Integer> households = new TreeMap<>();

    /**
     * @param occupants List<Occupant> stores occupants
     * @param households Map<String, Integer> households to 'put' into
     * Arrange by last name, and store the number of occupants in each household.
     */
    public static void sortHouseholds(List<Occupant> occupants, Map<String, Integer> households) {
        for (Occupant occupant : occupants) {
            if (!households.containsKey(occupant.getLastName()))
                households.put(occupant.getLastName(), 1);
            else
                households.put(occupant.getLastName(), households.get(occupant.getLastName()) + 1);
        }
    }
}
