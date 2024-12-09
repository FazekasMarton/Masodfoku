package org.example.masodfoku;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField input1;

    @FXML
    private TextField input2;

    @FXML
    private TextField input3;

    @FXML
    private Label result;

    @FXML
    private void calculate() {
        String error = "Egészszámot kéne megadni!";
        try {
            double a = Integer.parseInt(input1.getText());
            double b = Integer.parseInt(input2.getText());
            double c = Integer.parseInt(input3.getText());

            double underRoot = Math.pow(b, 2) - 4 * a * c;
            if (underRoot < 0) {
                error = "Nem oldható meg a valós számok halmazán";
                throw new ArithmeticException(error);
            }
            double result1 = (-1 * b + Math.sqrt(underRoot)) / (2 * a);
            double result2 = (-1 * b - Math.sqrt(underRoot)) / (2 * a);

            if (result1 == result2) {
                result.setText("x1 = x2 = " + String.valueOf(result1));
            }else{
                result.setText("x1 = " + String.valueOf(result1) + "\nx2 = " + String.valueOf(result2));
            }
        } catch (NumberFormatException | ArithmeticException e) {
            Alert message = new Alert(Alert.AlertType.ERROR);
            message.setTitle("Error");
            message.setContentText(error);
            message.showAndWait();
        }
    }
}