public class WeatherService {

    public WeatherData getWeather(String city) {

        city = city.toLowerCase();

        switch (city) {

            case "kolkata":
                return new WeatherData(
                        "Kolkata",
                        31.5,
                        78,
                        12.0,
                        "Cloudy");

            case "delhi":
                return new WeatherData(
                        "Delhi",
                        36.0,
                        52,
                        9.5,
                        "Sunny");

            case "mumbai":
                return new WeatherData(
                        "Mumbai",
                        29.0,
                        85,
                        15.0,
                        "Rainy");

            case "chennai":
                return new WeatherData(
                        "Chennai",
                        33.0,
                        74,
                        11.0,
                        "Partly Cloudy");

            case "bangalore":
                return new WeatherData(
                        "Bangalore",
                        26.0,
                        68,
                        8.0,
                        "Pleasant");

            default:
                return null;
        }
    }
}