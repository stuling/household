package test;

import main.org.stuling.expeditors.census.OccupantListInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.org.stuling.expeditors.census.Address;
import main.org.stuling.expeditors.census.Households;
import main.org.stuling.expeditors.census.Occupant;

import java.util.*;

class HouseholdsTest {

//    public static final List<Occupant> occupants = new ArrayList<>(Arrays.asList(
//            new Occupant("Dave", "Smith", new Address("123 main st.", "seattle", "wa"), 43),
//            new Occupant("Alice", "Smith", new Address("123 Main St.", "Seattle", "WA"), 45),
//            new Occupant("Bob", "Williams", new Address("234 2nd Ave.", "Tacoma", "WA"), 26),
//            new Occupant("Carol", "Johnson", new Address("234 2nd Ave", "Seattle", "WA"), 67),
//            new Occupant("Eve", "Smith", new Address("234 2nd Ave.", "Tacoma", "WA"), 25),
//            new Occupant("Frank", "Jones", new Address("234 2nd Ave.", "Tacoma", "FL"), 23),
//            new Occupant("George", "Brown",new Address( "345 3rd Blvd., Apt. 200", "Seattle", "WA"), 18),
//            new Occupant("Helen", "Brown", new Address("345 3rd Blvd. Apt. 200", "Seattle", "WA"), 18),
//            new Occupant("Ian", "Smith", new Address("123 main st ", "Seattle", "Wa"), 18),
//            new Occupant("Jane", "Smith", new Address("123 Main St.", "Seattle", "WA"), 13)
//    ));

    List<Occupant> occupants = OccupantListInput.getOccupantListFromTestData();
    private Address getTestAddress() {
        return new Address("234 2nd Ave.", "Tacoma", "FL");
    }
    private Occupant getTestOccupant () {
        return new Occupant("Frank", "Jones", getTestAddress(), 23);
    }

    @Test
    void testSortHouseholdsHas5Smiths() {

        //place the sorted households in this TreeMap to retain order
        Map<String, Integer> households = new TreeMap<String, Integer>();
        //sort the occupants list
        Households.sortHouseholds(occupants,households);
        //retrieve the (1) index and count the number of Smiths
        Integer numberOfSmiths = households.get(occupants.get(1).getLastName());

        Assertions.assertEquals(5, numberOfSmiths);
    }

    @Test
    void testSortHouseholdsHas2Browns() {

        //place the sorted households in this map
        Map<String, Integer> households = new TreeMap<String, Integer>();
        //sort the occupants list
        Households.sortHouseholds(occupants,households);
        //retrieve the (6) index and count the number of Browns
        Integer numberOfBrowns = households.get(occupants.get(6).getLastName());

        Assertions.assertEquals(2, numberOfBrowns);
    }

    @Test
    void testSortHouseholdsHas1Jones() {

        //place the sorted households in this map
        Map<String, Integer> households = new TreeMap<String, Integer>();
        //sort the occupants list
        Households.sortHouseholds(occupants,households);
        //retrieve the (5) index and count the number of Jones
        Integer numberOfJones = households.get(occupants.get(5).getLastName());

        Assertions.assertEquals(1, numberOfJones);
    }
}