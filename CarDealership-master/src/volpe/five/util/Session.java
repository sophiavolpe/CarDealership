package volpe.five.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import volpe.five.controllers.MainViewController;

import java.io.IOException;

public class Session {

    public static Employee sessionUser;
    public static Employee selectedEmployee;

    public static Customer selectedCustomer;

    public static Vehicle selectedVehicle;

    public static Invoice selectedInvoice;

    public static MainViewController mainViewController;

    public static String alertMessage;
    public static void alert(String alertMessage) {

        try {
            Session.alertMessage = alertMessage;
            Stage newStage = new Stage();
            newStage.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader fxmlLoader = new FXMLLoader();
            newStage.setTitle("Alert");

            fxmlLoader.setLocation(Session.class.getResource("../volpe.five.view/AlertBox.fxml"));
            Parent newResource = fxmlLoader.load();
            Scene newScene = new Scene(newResource);
            newStage.setScene(newScene);
            newStage.setResizable(false);
            newStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void clearSession() {

        Session.sessionUser = null;
        Session.selectedEmployee = null;
        Session.selectedCustomer = null;
        Session.selectedVehicle = null;
        Session.selectedInvoice = null;
        Session.mainViewController = null;
        Session.alertMessage = null;

    }
}
