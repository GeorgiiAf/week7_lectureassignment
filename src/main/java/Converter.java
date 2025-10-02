// i made additional class for temperature conversion


public class Converter {

    // Fahrenheit → Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Kelvin → Celsius
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    // Celsius → Kelvin
    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

}

