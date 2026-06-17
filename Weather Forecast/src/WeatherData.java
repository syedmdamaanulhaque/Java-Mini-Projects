public class WeatherData {

    String city;
    double temperature;
    double humidity;
    double windSpeed;
    String description;

    public WeatherData(String city, double temperature, double humidity, double windSpeed, String description) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.description = description;
    }

    public void displayWeather() {
        System.out.println("\n🌍 WEATHER REPORT");
        System.out.println("-------------------");
        System.out.println("City: " + city);
        System.out.println("Temperature: " + temperature + " °C");
        System.out.println("Wind Speed: " + windSpeed + " km/h");

        if (temperature < 15) {
            System.out.println("Condition: ❄️ Cold");
        } else if (temperature < 25) {
            System.out.println("Condition: 🌤️ Pleasant");
        } else {
            System.out.println("Condition: 🔥 Hot");
        }

        System.out.println("-------------------\n");
    }
}