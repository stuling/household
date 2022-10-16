package main.org.stuling.expeditors.census;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//        List<Occupant> occupants = OccupantListInput.getOccupantListFromTestData();
        List<Occupant> occupants = OccupantListInput.getOccupantListFromCSV();

        //place the sorted households in this TreeMap
        Map<String, Integer> households = new TreeMap<String, Integer>();
        //sort the occupants list
        Households.sortHouseholds(occupants,households);

        System.out.println("Each household of the input list and number of occupants, sorted by Last Name");
        //print out each household (by last name) with the number of occupants
        for (String household : households.keySet()) {
            System.out.println("Household name: " + household + ", " + households.get(household));
        }

        List<Occupant> adultOccupants = new ArrayList<>();
        for(Occupant oc : occupants) {
            if (oc.isAdult()) {
                adultOccupants.add(oc);
            }
        }

        Collections.sort(adultOccupants);

        for (Occupant ad : adultOccupants) {
            System.out.println(ad.toString());
        }

    }

}


