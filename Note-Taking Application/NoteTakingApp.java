import java.io.*;
import java.util.Scanner;
import java.time.LocalDateTime;

public class NoteTakingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("      NOTE TAKING APPLICATION");
            System.out.println("================================");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Delete All Notes");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    try {

                        FileWriter writer = new FileWriter("notes.txt", true);

                        System.out.print("Enter your note: ");
                        String note = sc.nextLine();

                        writer.write("[" + LocalDateTime.now() + "] ");
                        writer.write(note + "\n");

                        writer.close();

                        System.out.println("✓ Note saved successfully!");

                    } catch (IOException e) {

                        System.out.println("Error saving note.");

                    }

                    break;

                case 2:

                    try {

                        BufferedReader reader =
                                new BufferedReader(new FileReader("notes.txt"));

                        String line;

                        System.out.println("\n========== YOUR NOTES ==========");

                        while ((line = reader.readLine()) != null) {

                            System.out.println(line);

                        }

                        reader.close();

                    } catch (IOException e) {

                        System.out.println("No notes found.");

                    }

                    break;

                case 3:

                    try {

                        PrintWriter writer = new PrintWriter("notes.txt");

                        writer.close();

                        System.out.println("✓ All notes deleted successfully!");

                    } catch (Exception e) {

                        System.out.println("Unable to delete notes.");

                    }

                    break;

                case 4:

                    System.out.println("Thank you for using Note Taking Application!");
                    break;

                default:

                    System.out.println("Invalid choice!");

            }

        } while (choice != 4);

        sc.close();

    }
}