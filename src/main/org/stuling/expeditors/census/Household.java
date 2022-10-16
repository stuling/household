package main.org.stuling.expeditors.census;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * A household to represent one or more occupants
 */
public class Household implements Comparable<Household> {

    private Address address;
    private ArrayList<Occupant> occupants = new ArrayList<>();

    public Household(Address address) { this.address = address; }

    public String getAddress() {
        return address.toCleanString();
    }

    @Override
    public boolean equals(Object obj) {
        Household other = (Household) obj;
        return other.address.equals(this.address);
    }

    @Override
    public int compareTo(Household that) {
        return Comparator.comparing(Household::getAddress)
                .compare(this, that);
    }
}
