package volpe.five.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import volpe.five.util.Customer;
import volpe.five.util.DataHandler;
import volpe.five.util.Init;

import java.sql.Connection;
import java.sql.Statement;

public class AddCustomerTabController implements Init {

    private MainViewController mainViewController;

    @FXML private TextField fNameTF;
    @FXML private TextField lNameTF;
    @FXML private TextField phoneTF;
    @FXML private TextField emailTF;
    @FXML private TextField addressTF;
    @FXML private TextField cityTF;
    @FXML private DatePicker dateOfBirthDP;

    @FXML public void save(ActionEvent event) {

        try {

            String sql;

            Customer customer = new Customer(fNameTF, lNameTF, phoneTF, emailTF, addressTF, cityTF, dateOfBirthDP);
            Connection connection = DataHandler.getConnection();
            Statement statement = connection.createStatement();

            sql = "INSERT INTO `CUSTOMERS` (`ID`, `FIRST_NAME`, `LAST_NAME`, `PHONE`, `EMAIL`, `ADDRESS`, `CITY`, `DATE_OF_BIRTH`) VALUES (NULL, " + customer.getInsertSQL() + ");";
            statement.executeUpdate(sql);

        } catch (Exception e) {

            System.out.println("Empty fields!");

        }

        try {

            mainViewController.getSearchCustomerTabController().updateResultSet();
            mainViewController.getSearchCustomerTabController().displayResultSet();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public void init(MainViewController mainViewController) {
        this.mainViewController = mainViewController;
    }
}
