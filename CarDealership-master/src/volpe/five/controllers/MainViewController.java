package volpe.five.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import volpe.five.util.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML private AddCustomerTabController addCustomerTabController;
    @FXML private AddVehicleTabController addVehicleTabController;

    @FXML private SearchCustomerTabController searchCustomerTabController;
    @FXML private SearchVehicleTabController searchVehicleTabController;
    @FXML private AddTradeInVehicleController addTradeInVehicleController;

    @FXML private AddEmployeeTabController addEmployeeTabController;
    @FXML private SearchEmployeeTabController searchEmployeeTabController;

    @FXML private SessionTabController sessionTabController;

    @FXML private Tab userSessionInfoTab;
    @FXML private Tab employeeTab;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        if (!Session.sessionUser.isAdmin()) {
            employeeTab.setDisable(true);
        }

        userSessionInfoTab.setText(Session.sessionUser.getFirstName() + " " + Session.sessionUser.getLastName());

        addCustomerTabController.init(this);
        addEmployeeTabController.init(this);
        addVehicleTabController.init(this);
        searchCustomerTabController.init(this);
        searchVehicleTabController.init(this);
        searchEmployeeTabController.init(this);
        sessionTabController.init(this);

        Session.mainViewController = this;

    }

    public Tab getUserSessionInfoTab() {
        return userSessionInfoTab;
    }

    public AddCustomerTabController getAddCustomerTabController() {
        return addCustomerTabController;
    }

    public AddVehicleTabController getAddVehicleTabController() {
        return addVehicleTabController;
    }

    public SearchCustomerTabController getSearchCustomerTabController() {
        return searchCustomerTabController;
    }

    public SearchVehicleTabController getSearchVehicleTabController() {
        return searchVehicleTabController;
    }

    public AddEmployeeTabController getAddEmployeeTabController() {
        return addEmployeeTabController;
    }

    public SearchEmployeeTabController getSearchEmployeeTabController() {
        return searchEmployeeTabController;
    }

    public SessionTabController getSessionTabController() {
        return sessionTabController;
    }
}
