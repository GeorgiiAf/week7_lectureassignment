import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField celsiusField = new TextField();
    private Label resultLabel = new Label();
    private double fahrenheit;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        celsiusField.setPromptText("Enter value");

        Button convertButton = new Button("C → F");
        convertButton.setOnAction(e -> convertTemperature());

        Button fToCButton = new Button("F → C");
        fToCButton.setOnAction(e -> convertFahrenheitToCelsius());

        Button kToCButton = new Button("K → C");
        kToCButton.setOnAction(e -> convertKelvinToCelsius());

        Button cToKButton = new Button("C → K");
        cToKButton.setOnAction(e -> convertCelsiusToKelvin());

        Button saveButton = new Button("Save to DB");
        saveButton.setOnAction(e -> Database.saveTemperature(
                Double.parseDouble(celsiusField.getText()), fahrenheit, resultLabel));

        VBox root = new VBox(10, celsiusField, convertButton, fToCButton, kToCButton, cToKButton, resultLabel, saveButton);
        Scene scene = new Scene(root, 300, 300);

        stage.setTitle("Temperature Converter");
        stage.setScene(scene);
        stage.show();
    }

    private void convertTemperature() {
        try {
            double celsius = Double.parseDouble(celsiusField.getText());
            fahrenheit = (celsius * 9 / 5) + 32;
            resultLabel.setText(String.format("Fahrenheit: %.2f", fahrenheit));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }

    private void convertFahrenheitToCelsius() {
        try {
            double f = Double.parseDouble(celsiusField.getText());
            double c = Converter.fahrenheitToCelsius(f);
            resultLabel.setText(String.format("Celsius: %.2f", c));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }

    private void convertKelvinToCelsius() {
        try {
            double k = Double.parseDouble(celsiusField.getText());
            double c = Converter.kelvinToCelsius(k);
            resultLabel.setText(String.format("Celsius: %.2f", c));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }

    private void convertCelsiusToKelvin() {
        try {
            double c = Double.parseDouble(celsiusField.getText());
            double k = Converter.celsiusToKelvin(c);
            resultLabel.setText(String.format("Kelvin: %.2f", k));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }
}
