import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        WeatherService weatherService = new WeatherService();

        while (true) {

            System.out.println("\n===== WEATHER FORECAST APPLICATION =====");
            System.out.println("1. Get Weather");
            System.out.println("2. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter City Name: ");
                    String city = sc.nextLine();

                    WeatherData weather = weatherService.getWeather(city);

                    if (weather != null) {
                        weather.displayWeather();
                    }
                    else {
                        System.out.println("Weather data not available.");
                    }

                    break;

                case 2:

                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}