package test;

import main.org.stuling.expeditors.census.OccupantListInput;
import org.junit.jupiter.api.Test;
import main.org.stuling.expeditors.census.Address;
import main.org.stuling.expeditors.census.Occupant;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class OccupantTest {

    //method for testing
    private Address getTestAddress() {
        return new Address("234 2nd Ave.", "Tacoma", "FL");
    }

    @Test
    void testChildIsEvaluatedAsNotAnAdult() {
        Occupant child = new Occupant("Tiny", "Tim", getTestAddress(), 12);
        assertFalse(child.isAdult());
    }

    @Test
    void testOccupantListIsSortedByLastThenFirst() {

        List<Occupant> occupants = OccupantListInput.getOccupantListFromTestData();
        Collections.sort(occupants);

        assertEquals("Brown", occupants.get(0).getLastName());
        assertEquals("Helen", occupants.get(1).getFirstName());
        assertEquals("Smith", occupants.get(4).getLastName());
        assertEquals("Dave", occupants.get(5).getFirstName());
    }

    @Test
    void testGetAdultsReturnsListOver18Size6() {

        List<Occupant> occupants = OccupantListInput.getOccupantListFromTestData();
        List<Occupant> adultOccupants = new ArrayList<>();
        for(Occupant oc : occupants) {
            if (oc.isAdult()) {
                adultOccupants.add(oc);
            }
        }

        Collections.sort(adultOccupants);
        assertEquals(6, adultOccupants.size());
    }

    @Test
    void testGetAdultsReturnsListOver18() {

        List<Occupant> occupants = OccupantListInput.getOccupantListFromTestData();
        List<Occupant> adultOccupants = new ArrayList<>();
        for(Occupant oc : occupants) {
            if (oc.isAdult()) {
                adultOccupants.add(oc);
//                System.out.println("adOcs : " + adultOccupants.toString());
            }
        }

        Collections.sort(adultOccupants);

        assertEquals("Johnson", adultOccupants.get(0).getLastName());
        assertEquals("Frank", adultOccupants.get(1).getFirstName());
        assertEquals("Alice", adultOccupants.get(2).getFirstName());
        assertEquals("Dave", adultOccupants.get(3).getFirstName());
        assertEquals("Eve", adultOccupants.get(4).getFirstName());
        assertEquals("Bob", adultOccupants.get(5).getFirstName());
    }
}