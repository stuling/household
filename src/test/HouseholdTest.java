package test;

import org.junit.jupiter.api.Test;
import main.org.stuling.expeditors.census.Address;
import main.org.stuling.expeditors.census.Household;

import static org.junit.jupiter.api.Assertions.*;

class HouseholdTest {

    @Test
    void testGetAddressFromHousehold() {
        Address testAddress = new Address("123 main st.","seattle","wa");
        Household testHouseHold = new Household(testAddress);

        assertEquals("123 main st seattle, wa", testHouseHold.getAddress());
    }

    @Test
    void testEqualsOnHouseholdIsTrue() {
        Address testAddress = new Address("123 main st.","seattle","wa");
        Household testHouseHold1 = new Household(testAddress);
        Household testHouseHold2 = new Household(testAddress);

        assertEquals(true, testHouseHold1.equals(testHouseHold2));
    }

    @Test
    void testEqualsOnDifferentHouseholdIsFalse() {
        Address testAddress = new Address("123 main st.","seattle","wa");
        Address testAddress2 = new Address("123 main st.","Tacoma","wa");
        Household testHouseHold1 = new Household(testAddress);
        Household testHouseHold2 = new Household(testAddress2);

        assertEquals(false, testHouseHold1.equals(testHouseHold2));
    }

    @Test
    void testCompareToOnIdenticalHouseholdIsTrue() {
        Address testAddress = new Address("123 3rd Ave.","seattle","Wa");
        Household testHouseHold1 = new Household(testAddress);
        Household testHouseHold2 = new Household(testAddress);

        assertEquals(0, testHouseHold1.compareTo(testHouseHold2));
    }

    @Test
    void testCompareToOnDifferentHouseholdIsTrue() {
        Address testAddress = new Address("1234 main st.","seattle","wa");
        Address testAddress2 = new Address("123 main st.","seattle","wa");
        Household testHouseHold1 = new Household(testAddress);
        Household testHouseHold2 = new Household(testAddress2);

        assertTrue(testHouseHold1.compareTo(testHouseHold2) > 0);
    }
}