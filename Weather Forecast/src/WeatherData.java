public class WeatherData {

    private String city;
    private double temperature;
    private int humidity;
    private double windSpeed;
    private String condition;

    public WeatherData(String city, double temperature,
                       int humidity, double windSpeed,
                       String condition) {

        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.condition = condition;
    }

    public void displayWeather() {

        System.out.println("\n========== WEATHER REPORT ==========");
        System.out.println("City        : " + city);
        System.out.println("Temperature : " + temperature + " °C");
        System.out.println("Humidity    : " + humidity + "%");
        System.out.println("Wind Speed  : " + windSpeed + " km/h");
        System.out.println("Condition   : " + condition);
        System.out.println("====================================");
    }
}