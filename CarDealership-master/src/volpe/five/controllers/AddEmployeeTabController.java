package volpe.five.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import volpe.five.util.DataHandler;
import volpe.five.util.Employee;
import volpe.five.util.Init;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class AddEmployeeTabController implements Init {

    private MainViewController mainViewController;

    @FXML private TextField fNameTF;
    @FXML private TextField lNameTF;
    @FXML private TextField phoneTF;
    @FXML private TextField emailTF;
    @FXML private TextField addressTF;
    @FXML private TextField cityTF;
    @FXML private TextField salaryTF;
    @FXML private DatePicker dateOfBirthDP;
    @FXML private ComboBox<String> jobTitleCB;

    @FXML public void save(ActionEvent event) {

        Employee employee = new Employee(fNameTF, lNameTF, phoneTF, emailTF, addressTF, cityTF, dateOfBirthDP, jobTitleCB, salaryTF);

        try {

            Connection connection = DataHandler.getConnection();

            // Add EMPLOYEES entry
            Statement statement = connection.createStatement();

            String sql = "INSERT INTO `EMPLOYEES` " +
                    "(`ID`, `FIRST_NAME`, `LAST_NAME`, `PHONE`, `EMAIL`, `ADDRESS`, `CITY`, " +
                    "`DATE_OF_BIRTH`, `JOB`, `SALARY`, `WORK_STATUS`, `TOTAL_SALES`) VALUES " +
                    "(NULL, " + employee.getInsertSQL() + ");";

            statement.executeUpdate(sql);

            // Add USERS entry
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `USERS` (`ID`, `USERNAME`, `PASSWORD`) VALUES (NULL, ?, ?);");

            String username = employee.getEmail().substring(0, employee.getEmail().indexOf('@'));
            String password = String.valueOf(employee.getFirstName().charAt(0)) + String.valueOf(employee.getLastName().charAt(0));

            username = username.toLowerCase();
            password = password.toLowerCase();

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            mainViewController.getSearchEmployeeTabController().updateResultSet();
            mainViewController.getSearchEmployeeTabController().displayResultSet();

        }

    }

    @Override
    public void init(MainViewController mainViewController) {

        this.mainViewController = mainViewController;
        ArrayList<String> jobs = new ArrayList<>();
        jobs.add("Sales");
        jobs.add("Accountant");
        jobs.add("Manager");
        jobTitleCB.getItems().addAll(jobs);

    }

}
