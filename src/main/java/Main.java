import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField temperatureField = new TextField();
    private Label resultLabel = new Label();
    private double fahrenheit;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        temperatureField.setPromptText("Enter temperature value");
        Button cToFButton = new Button("Celsius → Fahrenheit");
        cToFButton.setOnAction(e -> convertCelsiusToFahrenheit());

        Button fToCButton = new Button("Fahrenheit → Celsius");
        fToCButton.setOnAction(e -> convertFahrenheitToCelsius());

        Button kToCButton = new Button("Kelvin → Celsius");
        kToCButton.setOnAction(e -> convertKelvinToCelsius());

        Button cToKButton = new Button("Celsius → Kelvin");
        cToKButton.setOnAction(e -> convertCelsiusToKelvin());

        Button saveButton = new Button("Save to Database");
        saveButton.setOnAction(e -> Database.saveTemperature(
                Double.parseDouble(temperatureField.getText()), fahrenheit, resultLabel));

        VBox root = new VBox(10, temperatureField, cToFButton, fToCButton, kToCButton, cToKButton, resultLabel, saveButton);
        Scene scene = new Scene(root, 350, 300);

        stage.setTitle("Temperature Converter");
        stage.setScene(scene);
        stage.show();
    }

    private void convertCelsiusToFahrenheit() {
        try {
            double celsius = Double.parseDouble(temperatureField.getText());
            fahrenheit = (celsius * 9 / 5) + 32;
            resultLabel.setText(String.format("Fahrenheit: %.2f", fahrenheit));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }

    private void convertFahrenheitToCelsius() {
        try {
            double fahrenheitValue = Double.parseDouble(temperatureField.getText());
            double celsius = Converter.fahrenheitToCelsius(fahrenheitValue);
            resultLabel.setText(String.format("Celsius: %.2f", celsius));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }

    private void convertKelvinToCelsius() {
        try {
            double kelvin = Double.parseDouble(temperatureField.getText());
            double celsius = Converter.kelvinToCelsius(kelvin);
            resultLabel.setText(String.format("Celsius: %.2f", celsius));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }

    private void convertCelsiusToKelvin() {
        try {
            double celsius = Double.parseDouble(temperatureField.getText());
            double kelvin = Converter.celsiusToKelvin(celsius);
            resultLabel.setText(String.format("Kelvin: %.2f", kelvin));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }
}
