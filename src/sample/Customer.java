package sample;

import java.util.ArrayList;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Customer extends Person {

    private boolean isCompany;
    private String responsiblePerson;
    private ArrayList<Passenger> passengers = new ArrayList<>();

    // add num of registered passengers to calculate how many passengers and trips he had
    private int points;


    public Customer(String name, String adress, String email, String phone, boolean isCompany, String responsiblePerson) {
        super(name, adress, email, phone);
        this.isCompany = isCompany;
        this.responsiblePerson = responsiblePerson;
    }

    public Customer(String name, String adress, String email, String phone, boolean isCompany) {
        super(name, adress, email, phone);
        this.isCompany = isCompany;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void addPointToCustomer() { points = points++; }
}