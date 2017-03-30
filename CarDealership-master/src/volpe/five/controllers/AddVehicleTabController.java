package volpe.five.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import volpe.five.util.Init;
import volpe.five.util.Vehicle;

public class AddVehicleTabController implements Init {

    private MainViewController mainViewController;

    @FXML private TextField makeTF;
    @FXML private TextField modelTF;
    @FXML private TextField yearTF;
    @FXML private TextField colorTF;
    @FXML private ComboBox<String> typeCB;
    @FXML private TextField priceTF;
    @FXML private ComboBox<String> usedCB;

    @FXML public void save(ActionEvent event) {

        try {

            Vehicle vehicle = new Vehicle(makeTF, modelTF, yearTF, colorTF, typeCB, priceTF, usedCB);
            Vehicle.insertEntry(vehicle);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            mainViewController.getSearchVehicleTabController().updateResultSet();
            mainViewController.getSearchVehicleTabController().displayResultSet();

        }

    }

    @Override
    public void init(MainViewController mainViewController) {

        this.mainViewController = mainViewController;

        usedCB.getItems().add("No");
        usedCB.getItems().add("Yes");

        typeCB.getItems().add("Family");
        typeCB.getItems().add("Sports");
        typeCB.getItems().add("Recreational");

    }
}
