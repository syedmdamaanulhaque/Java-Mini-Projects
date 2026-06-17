import org.json.JSONObject;

public class WeatherService {

    private APIClient apiClient;

    public WeatherService() {
        apiClient = new APIClient();
    }

    public WeatherData getWeather(String city) {

        try {

            GeoService geoService = new GeoService();
            double[] coords = geoService.getCoordinates(city);

            if (coords == null) {
                System.out.println("City not found!");
                return null;
            }

            double latitude = coords[0];
            double longitude = coords[1];

            String url = "https://api.open-meteo.com/v1/forecast"
                    + "?latitude=" + latitude
                    + "&longitude=" + longitude
                    + "&current_weather=true";

            String response = apiClient.fetchData(url);

            JSONObject json = new JSONObject(response);
            JSONObject current = json.getJSONObject("current_weather");

            double temperature = current.getDouble("temperature");
            double windSpeed = current.getDouble("windspeed");

            return new WeatherData(city, temperature, 0, windSpeed, "Live Weather");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}