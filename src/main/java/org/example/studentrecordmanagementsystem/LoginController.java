package org.example.studentrecordmanagementsystem;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import java.sql.*;

public class LoginController {

    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblError;

    @FXML
    private void login() {
        String user = txtUsername.getText().trim();
        String pass = txtPassword.getText().trim();

        if (user.isEmpty() || pass.isEmpty()) {
            lblError.setText("Please fill in all fields.");
            return;
        }

        try {
            Connection conn = DBConnection.connect();
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, user);
            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(
                        "/org/example/studentrecordmanagementsystem/front.fxml"));
                Stage stage = (Stage) txtUsername.getScene().getWindow();
                stage.setScene(new Scene(loader.load()));
            } else {
                lblError.setText("Invalid username or password.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
