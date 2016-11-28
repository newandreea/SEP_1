package main.Model;


/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Passenger extends Person {

    private boolean subscribed;
    private int seatNumber;

    public Passenger(String name, String address, String email, String phone, MyDate dateOfBirth, boolean subscribed, int seatNumber) {
        super(name, address, email, phone, dateOfBirth);
        this.subscribed = subscribed;
        this.seatNumber = seatNumber;
    }
}
