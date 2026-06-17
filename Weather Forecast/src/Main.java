import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        WeatherService weatherService = new WeatherService();

        while (true) {

            System.out.println("===== WEATHER FORECAST APPLICATION =====");
            System.out.println("1. Get Weather");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter city: ");
                String city = sc.nextLine();

                WeatherData data = weatherService.getWeather(city);

                if (data != null) {
                    data.displayWeather();
                }

            } else if (choice == 2) {
                System.out.println("Bye!");
                break;
            }
        }
    }
}