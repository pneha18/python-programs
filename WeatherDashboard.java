import java.util.Scanner;

public class WeatherDashboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] cities = {"Chennai", "Bengaluru", "Mumbai", "Delhi", "Coimbatore"};
        double[] temperatures = {32.0, 27.0, 30.0, 29.0, 28.0};
        String[] conditions = {"Sunny", "Cloudy", "Humid", "Clear", "Partly cloudy"};

        System.out.println("=== WEATHER DASHBOARD (SAMPLE DATA) ===");
        System.out.println("Note: This beginner project uses sample data, not live weather.");
        System.out.println("\nAvailable cities:");
        for (int i = 0; i < cities.length; i++) {
            System.out.println((i + 1) + ". " + cities[i]);
        }
        System.out.print("Choose a city number: ");

        if (!sc.hasNextInt()) {
            System.out.println("Please run again and enter a number.");
            sc.close();
            return;
        }
        int choice = sc.nextInt();

        if (choice < 1 || choice > cities.length) {
            System.out.println("Invalid city number.");
        } else {
            int index = choice - 1;
            System.out.println("\n--- Weather Report ---");
            System.out.println("City: " + cities[index]);
            System.out.printf("Temperature: %.1f C%n", temperatures[index]);
            System.out.println("Condition: " + conditions[index]);
            System.out.println("\nTip: You can extend this project by connecting a weather API.");
        }
        sc.close();
    }
}
