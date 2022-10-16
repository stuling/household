package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import main.org.stuling.expeditors.census.Address;

/**
 * A test class for testing equality of Address
 */
class AddressTest {

    @Test
    void testAddressCaseIsIgnoredForEquality() {
        Address addressLowerCase = new Address("123 main st.","seattle","wa");
        Address addressMixedCase = new Address("123 Main St.","Seattle","WA");

        assertEquals(true, addressLowerCase.equals(addressMixedCase));
    }

    @Test
    void testCleanStreetForEquality() {
        Address addressWithSpaces = new Address("234 2nd Ave.  ","Tacoma","WA");
        Address addressWithComma = new Address("234 2nd Ave,","Tacoma","WA");

        assertEquals(true, addressWithSpaces.equals(addressWithComma));
    }

    @Test
    void testCleanStreetColonForEquality() {
        Address addressWithSpaces = new Address("234 2nd Ave.  ","Tacoma","WA");
        Address addressWithColon = new Address("234 2nd :Ave,","Tacoma","WA");

        assertEquals(true, addressWithSpaces.equals(addressWithColon));
    }

    @Test
    void testCleanStateForEquality() {
        Address stateWithSpaces = new Address("234 5nd St.","Seattle","WA  ");
        Address cleanLowerCaseState = new Address("234 5nd St.","Seattle","wa");

        assertEquals(true, stateWithSpaces.equals(cleanLowerCaseState));
    }

    @Test
    void testStateForInequality() {
        Address addressWaAddress = new Address("234 2nd Ave.","Tacoma","WA");
        Address addressFlAddress = new Address("234 2nd Ave.","Tacoma","FL");

        assertEquals(false, addressWaAddress.equals(addressFlAddress));
    }

    @Test
    void testCityForInequality() {
        Address addressSeattleAddress = new Address("234 2nd Ave.","Seattle","WA");
        Address addressSpokaneAddress = new Address("234 2nd Ave.","Tacoma","WA");

        assertEquals(false, addressSeattleAddress.equals(addressSpokaneAddress));
    }
}