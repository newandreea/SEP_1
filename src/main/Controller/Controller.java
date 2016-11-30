package main.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.Model.DataHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public MenuBar menu;
    public MenuItem homeHome;
    public MenuItem homeTour;
    public MenuItem homeReserve;
    public MenuItem homeSearch;
    public MenuItem homeBus;
    public MenuItem homeBusAdd;
    public MenuItem homeDriver;
    public MenuItem homeDriverAdd;


    //main screen
    public Button createTour;
    public Button mkReservation;
    public Button findTrip;

    //bus list
    public Button addBus;

    //chauffeur list
    public Button addChauffeur;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        DataHandler.print();

    }

    public void changeView(MouseEvent mouseEvent) throws IOException {

        Stage stage;
        Parent root;


        //main
        if ((mouseEvent.getSource() == createTour)) {
            stage = (Stage) createTour.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/createTour.fxml"));
        } else if ((mouseEvent.getSource() == mkReservation)) {
            stage = (Stage) mkReservation.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/makeReservation.fxml"));
        } else if ((mouseEvent.getSource() == findTrip)) {
            stage = (Stage) findTrip.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/search.fxml"));
        }

        //bus view
        else if ((mouseEvent.getSource() == addBus)) {
            stage = (Stage) addBus.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/addBus.fxml"));
        }

        //chauffeur view
        else if ((mouseEvent.getSource() == addChauffeur)) {
            stage = (Stage) addChauffeur.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/AddChauffeur.fxml"));
        } else {
            stage = (Stage) createTour.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/mainScreen.fxml"));
        }


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void changeViewMenu(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) menu.getScene().getWindow();
        Parent root;

        if ((actionEvent.getSource() == homeHome)) {
            root = FXMLLoader.load(getClass().getResource("../View/mainScreen.fxml"));
        } else if ((actionEvent.getSource() == homeTour)) {
            root = FXMLLoader.load(getClass().getResource("../View/createTour.fxml"));
        } else if ((actionEvent.getSource() == homeBus)) {
            root = FXMLLoader.load(getClass().getResource("../View/busList.fxml"));
        } else if ((actionEvent.getSource() == homeBusAdd)) {
            root = FXMLLoader.load(getClass().getResource("../View/addBus.fxml"));
        } else if ((actionEvent.getSource() == homeReserve)) {
            root = FXMLLoader.load(getClass().getResource("../View/makeReservation.fxml"));
        } else if ((actionEvent.getSource() == homeSearch)) {
            root = FXMLLoader.load(getClass().getResource("../View/search.fxml"));
        } else if ((actionEvent.getSource() == homeDriver)) {
            root = FXMLLoader.load(getClass().getResource("../View/chauffeurList.fxml"));
        } else if ((actionEvent.getSource() == homeDriverAdd)) {
            root = FXMLLoader.load(getClass().getResource("../View/addChauffeur.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("./View/mainScreen.fxml"));
        }


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    protected boolean validateEmptyField(TextField textField) {
        if (!textField.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    protected boolean validateNumberField(TextField textField) {
        if (textField.getText().matches("[0-9]+")) {
            return true;
        } else {
            return false;
        }

    }

    protected boolean validateTimeField(TextField textField) {
        if (textField.getText().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
            return true;
        } else {
            return false;
        }

    }

    protected boolean validateEmptyDate(DatePicker datePicker) {
        if (datePicker.getValue() != null) {
            return true;
        } else {
            return false;
        }

    }

    protected boolean validateEmptyCombo(ComboBox comboBox) {
        if (comboBox.getValue() != null) {
            return true;
        } else {
            return false;
        }

    }


    protected void alertdisplay(String title, String message) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    //@TODO move it to another class

    /*public void loadFile(String filename){

    }
    public int getNumberOfSeatsAvailable(Bus bus){
        return 0;
    }
    public void showList(){

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    public void modifyReservation(Trip reservation){

    }
    public void saveReservationToFile(String file, Trip reservation){

    }
    public void deleteReservation(Trip reservation){

    }
    public void hireEmployee(){

    }
    public void makeReservatioon(){

    }
    public void findCustomer(Customer customer){

    }
    public void pickSeat(){

    }
    public void giveDiscount(double percentge){

    }
    public void RentBusAndChauffeur(){

    }*/
}

