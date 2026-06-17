import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class APIClient {

    public String fetchData(String urlString) {

        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("API Error: " + e.getMessage());
        }

        return response.toString();
    }
}