
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIClient {

    public String fetchData(String urlString) {

        StringBuilder response = new StringBuilder();

        try {

            URL url = new URL(urlString);

            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {

                response.append(line);
            }

            reader.close();

        } catch (Exception e) {

            System.out.println("Error fetching weather data.");
        }

        return response.toString();
    }
}
