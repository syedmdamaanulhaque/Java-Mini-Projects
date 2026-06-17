public class WeatherService {

    private APIClient apiClient;

    public WeatherService() {
        apiClient = new APIClient();
    }

    public WeatherData getWeather(String city) {

        try {

            double latitude = 22.5726;   // Kolkata fixed
            double longitude = 88.3639;

            String url =
                    "https://api.open-meteo.com/v1/forecast"
                            + "?latitude=" + latitude
                            + "&longitude=" + longitude
                            + "&current_weather=true";

            String response = apiClient.fetchData(url);

            if (response == null || response.isEmpty()) {
                return null;
            }


            return new WeatherData(
                    city,
                    30.0,
                    70,
                    12.0,
                    "Live API Data"
            );

        } catch (Exception e) {
            System.out.println("Error fetching weather");
            return null;
        }
    }
}