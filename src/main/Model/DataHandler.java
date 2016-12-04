package main.Model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class DataHandler {


    private static ArrayList<Trip> trips;
    private static BusList busList;
    private static ChauffeurList chauffeurList;
    private static CustomerList customerList;
    private static PassengerList passengerList;
    private static ReservationList reservationList;
    private static DestinationList destinationList;

    public static ArrayList<Trip> getTrips() {
        return trips;
    }

    public static BusList getBusList() {
        return busList;
    }

    public static ChauffeurList getChauffeurList() {
        return chauffeurList;
    }

    public static CustomerList getCustomerList() {
        return customerList;
    }

    public static PassengerList getPassengerList() {
        return passengerList;
    }

    public static ReservationList getReservationList() {
        return reservationList;
    }

    public static DestinationList getDestinationList() {
        return destinationList;
    }

    public static void testCreate() {
        trips = new ArrayList<>();
        busList = new BusList();
        chauffeurList = new ChauffeurList();
        customerList = new CustomerList();
        passengerList = new PassengerList();
        reservationList = new ReservationList();
        destinationList = new DestinationList();
    }

    public static void testData() {

        getBusList().add(new PartyBus("AD1234", 12));
        getBusList().add(new PartyBus("AD1234", 12));
        getBusList().add(new ClassicBus("AD1454", 52));
        getBusList().add(new ClassicBus("AD1454", 52));
        getBusList().add(new ClassicBus("AD1454", 52));
        getBusList().add(new MiniBus("DD1254", 9));
        getBusList().add(new MiniBus("DD1254", 9));
        getBusList().add(new MiniBus("DD1254", 9));
        getBusList().add(new LuxuryBus("DD1254", 9));
        getBusList().add(new LuxuryBus("DD1254", 9));
        getBusList().add(new LuxuryBus("DD1254", 9));


        getDestinationList().getArrayDestination().add(new Destination("Place 1"));
        getDestinationList().getArrayDestination().add(new Destination("Place 2"));
        getDestinationList().getArrayDestination().add(new Destination("Place 3"));
        getDestinationList().getArrayDestination().add(new Destination("Place 4"));
        getDestinationList().getArrayDestination().add(new Destination("Place 5"));


        getChauffeurList().add(new Chauffeur("name1", "addres", "sda", "sad", new Date(2012 - 1900, 1, 1), 5221, true));
        getChauffeurList().add(new Chauffeur("name2", "addres", "sda", "sad", new Date(2012 - 1900, 1, 1), 5221, true));
        getChauffeurList().add(new Chauffeur("name3", "addres", "sda", "sad", new Date(2012 - 1900, 1, 1), 5221, true));
        getChauffeurList().add(new Chauffeur("name4", "addres", "sda", "sad", new Date(2012 - 1900, 1, 1), 5221, true));
        getChauffeurList().add(new Chauffeur("name5", "addres", "sda", "sad", new Date(2012 - 1900, 1, 1), 5221, true));

        getCustomerList().add(new Customer("name1", "address", "email", "123456"));
        getCustomerList().add(new Customer("name2", "address", "email", "123456"));
        getCustomerList().add(new Customer("name3", "address", "email", "123456"));
        getCustomerList().add(new Customer("name4", "address", "email", "123456"));
        getCustomerList().add(new Customer("name5", "address", "email", "123456"));

        getPassengerList().add(new Passenger("name1", "address", "email", new Date(2012 - 1900, 1, 1)));
        getPassengerList().add(new Passenger("name1", "address", "email", new Date(2012 - 1900, 1, 1)));
        getPassengerList().add(new Passenger("name1", "address", "email", new Date(2012 - 1900, 1, 1)));
        getPassengerList().add(new Passenger("name1", "address", "email", new Date(2012 - 1900, 1, 1)));
        getPassengerList().add(new Passenger("name1", "address", "email", new Date(2012 - 1900, 1, 1)));

        getTrips().add(new Trip(getBusList().getAtIndex(0), getChauffeurList().getChauffeurByIndex(0), getDestinationList().getAtIndex(0), getDestinationList().getAtIndex(0), 500, LocalDate.of(2016, 11, 12), "08:20", LocalDate.of(2016, 12, 12), "08:20", "50"));
        getTrips().add(new Trip(getBusList().getAtIndex(1), getChauffeurList().getChauffeurByIndex(1), getDestinationList().getAtIndex(0), getDestinationList().getAtIndex(0), 500, LocalDate.of(2016, 11, 12), "08:20", LocalDate.of(2016, 12, 12), "08:20", "50"));
        getTrips().add(new Trip(getBusList().getAtIndex(2), getChauffeurList().getChauffeurByIndex(2), getDestinationList().getAtIndex(0), getDestinationList().getAtIndex(0), 500, LocalDate.of(2016, 11, 12), "08:20", LocalDate.of(2016, 12, 12), "08:20", "50"));
        getTrips().add(new Trip(getBusList().getAtIndex(3), getChauffeurList().getChauffeurByIndex(3), getDestinationList().getAtIndex(0), getDestinationList().getAtIndex(0), 500, LocalDate.of(2016, 11, 12), "08:20", LocalDate.of(2016, 12, 12), "08:20", "50"));
    }

    public static void save() {

        String filename = "mainData.bin";

        // TODO: 30-Nov-16 first time needed to construct all data 

        ObjectOutputStream out = null;
        try {
            File file = new File(filename);
            FileOutputStream fos = new FileOutputStream(file);
            out = new ObjectOutputStream(fos);
            out.writeObject(trips);
            out.writeObject(busList);
            out.writeObject(chauffeurList);
            out.writeObject(customerList);
            out.writeObject(passengerList);
            out.writeObject(reservationList);
            out.writeObject(destinationList);
        } catch (IOException e) {
            System.out.println("Exception: " + filename);
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void load() {
        String filename = "test.bin";
        ObjectInputStream in = null;
        try {
            File file = new File(filename);
            FileInputStream fis = new FileInputStream(file);
            in = new ObjectInputStream(fis);
            trips = (ArrayList<Trip>) in.readObject();
            busList = (BusList) in.readObject();
            chauffeurList = (ChauffeurList) in.readObject();
            customerList = (CustomerList) in.readObject();
            passengerList = (PassengerList) in.readObject();
            reservationList = (ReservationList) in.readObject();
            destinationList = (DestinationList) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

