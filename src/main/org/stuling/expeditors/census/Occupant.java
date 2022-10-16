package main.org.stuling.expeditors.census;

import java.util.*;

/**
* An Occupant, also represents a single line of input
*/
public class Occupant implements Comparable<Occupant> {
    private String firstName;
    private String lastName;
    private Address address;
    private int age;

    public Occupant(String firstName, String lastName, Address address, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
    }

    /**
     * toString format with occupant's first and last name, address, and age.
     * Used to display requirement (1) of "Expected Output"
     * @return A string of occupant with sanitized address
     */
    @Override
    public String toString() {
        return String.format("Occupant: %s %s - %s - Age: %d", firstName, lastName, address.toCleanString(), age);
    }

    /**
     * To sort by last name and then first name.
     * @param that - Occupant object to compare.
     * @return Occupants sorted by last name and then first name.
     *
     */
    @Override
    public int compareTo(Occupant that) {
        return Comparator.comparing(Occupant::getLastName)
                .thenComparing(Occupant::getFirstName)
                .compare(this, that);
    }

    /**
     * The spec requirement for 'adult' is over 18
     * @return true if over 18, false otherwise
     */
    public boolean isAdult() { return age > 18; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}

