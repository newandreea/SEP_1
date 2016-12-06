package main.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by andreea on 12/1/2016.
 */
public class Reservation implements Serializable {

    private Trip trip;
    private Customer customer;
    private PassengerList passengerList;
    private double defaultPricePerson;
    private double finalPrice;
    private double priceExtraServices;
    private double discount;

    public Reservation(Trip trip, Customer customer, PassengerList passengerList, double price) {
        this.trip = trip;
        this.customer = customer;
        this.passengerList = passengerList;
        this.trip.freeSpaces -= this.passengerList.getArrayPassenger().size();
        this.defaultPricePerson = price;
        this.priceExtraServices = 0;
        this.discount = 0;
        this.finalPrice = 0;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public String getReservationByCompany() {
        return this.customer.getCompanyName();
    }

    public String getReservationByCustomerAddress() {
        return this.customer.getAddress();
    }

    public String getReservationByPassengerAddress() {
        for (int i = 0; i < this.passengerList.getArrayPassenger().size(); i++) {
            return this.passengerList.getArrayPassenger().get(i).getAddress();
        }
        return null;
    }

    public LocalDate getReservationByPassengerBirthday() {
        for (int i = 0; i < this.passengerList.getArrayPassenger().size(); i++) {
            return this.passengerList.getArrayPassenger().get(i).getDateOfBirth();
        }
        return null;
    }

    public String getReservationByCustomerEmail() {
        return this.customer.getEmail();
    }

    public String getReservationByPassengerEmail() {
        for (int i = 0; i < this.passengerList.getArrayPassenger().size(); i++) {
            return this.passengerList.getArrayPassenger().get(i).getEmail();
        }
        return null;
    }

    public String getReservationByCustomerPhone() {
        return this.customer.getEmail();
    }

    public String getReservationByPassengerName() {
        for (int i = 0; i < this.passengerList.getArrayPassenger().size(); i++) {
            return this.passengerList.getArrayPassenger().get(i).getPassengerName();
        }
        return null;
    }

    public Destination getReservationDestination() {
        return this.trip.getDestination();
    }

    public Destination getReservationPickUpPoint() {
        return this.trip.getPickUpPoint();
    }

    public Date getReservationTimeStart() {
        return this.trip.getDateObjStart();
    }

    public Trip getReservationByTrip() {
        return this.trip;
    }

    public PassengerList getReservationPassengers() {
        return this.passengerList;
    }

    public double getDefaultPricePerson() {
        return defaultPricePerson;
    }

    public void setDefaultPricePerson(int price) {
        this.defaultPricePerson = price;
    }

    public double getPriceExtraServices() {
        return priceExtraServices;
    }

    public void setPriceExtraServices(int priceExtraServices) {
        this.priceExtraServices = priceExtraServices;
    }

    public void setDiscount(double discount) {
        this.discount = (getDefaultPricePerson() + getPriceExtraServices()) * discount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice() {
        this.finalPrice = ((getDefaultPricePerson() + getPriceExtraServices()) - getDiscount()) * this.passengerList.getArrayPassenger().size();
    }

    public String toString() {
        String passsengers = "";
        for (int i = 0; i < passengerList.getArrayPassenger().size(); i++) {
            passsengers += " , for Passenger nr. " + (i + 1) + ": " + this.passengerList.getArrayPassenger().get(i).toString();
        }
        return this.trip + " , Reserved by Customer: " + this.customer + passsengers+ " , Total price: " + this.finalPrice;
    }
}
