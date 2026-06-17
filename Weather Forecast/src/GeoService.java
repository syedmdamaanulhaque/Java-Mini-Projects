import org.json.JSONArray;
import org.json.JSONObject;

public class GeoService {

    private APIClient apiClient = new APIClient();

    public double[] getCoordinates(String city) {

        try {

            String url = "https://geocoding-api.open-meteo.com/v1/search?name="
                    + city + "&count=1";

            String response = apiClient.fetchData(url);

            JSONObject json = new JSONObject(response);
            JSONArray results = json.getJSONArray("results");

            JSONObject place = results.getJSONObject(0);

            double lat = place.getDouble("latitude");
            double lon = place.getDouble("longitude");

            return new double[]{lat, lon};

        } catch (Exception e) {
            System.out.println("City not found!");
            return null;
        }
    }
}