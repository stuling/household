package main.org.stuling.expeditors.census;

/**
 * A class to hold only address information
 */
public class Address {

    private String street;
    private String cleanStreet; //a sanitized street string
    private String city;
    private String state;

    /**
     * Attempt to maximize matching by cleaning up
     * messy address input
     * @param value A string (address) to sanitize
     * @return A sanitized string
     */
    private String cleanupStreet(String value) {
        return value.replaceAll("[-:;,.]", "").trim();
    }

    public Address (String street, String city, String state) {
        this.street = street;
        this.cleanStreet = cleanupStreet(street);
        this.city = city;
        this.state = state.trim(); //TODO: could do additional validation here but trim() for now
    }

    /**
     * Get a sanitized street
     * @return A sanitized street string
     */
    public String getCleanStreet() { return cleanStreet; }

    /**
     * Get the raw, potentially messy street address
     * @return A potentially messy street string
     */
    public String getStreet() { return street; }

    @Override
    public String toString () {
        return String.format("%s %s, %s", street, city, state);
    }

    public String toCleanString() {
        return String.format("%s %s, %s", cleanStreet, city, state);
    }

    @Override
    public boolean equals (Object obj) {
        Address a = (Address) obj;
        return this.toCleanString()
                .equalsIgnoreCase((a)
                .toCleanString());
    }
}
