import java.util.ArrayList;
import java.util.Scanner;

public class MusicPlaylistManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> playlist = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n=== MUSIC PLAYLIST MANAGER ===");
            System.out.println("1. Add song");
            System.out.println("2. View playlist");
            System.out.println("3. Remove song");
            System.out.println("4. Search song");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter a number from 1 to 5: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter song name: ");
                    String song = sc.nextLine().trim();
                    if (!song.isEmpty()) {
                        playlist.add(song);
                        System.out.println("Song added!");
                    } else {
                        System.out.println("Song name cannot be empty.");
                    }
                    break;
                case 2:
                    if (playlist.isEmpty()) {
                        System.out.println("Your playlist is empty.");
                    } else {
                        System.out.println("\nYour Playlist:");
                        for (int i = 0; i < playlist.size(); i++) {
                            System.out.println((i + 1) + ". " + playlist.get(i));
                        }
                    }
                    break;
                case 3:
                    if (playlist.isEmpty()) {
                        System.out.println("No songs to remove.");
                        break;
                    }
                    System.out.print("Enter song number to remove: ");
                    if (sc.hasNextInt()) {
                        int index = sc.nextInt();
                        sc.nextLine();
                        if (index >= 1 && index <= playlist.size()) {
                            System.out.println("Removed: " + playlist.remove(index - 1));
                        } else {
                            System.out.println("Invalid song number.");
                        }
                    } else {
                        System.out.println("Please enter a valid number.");
                        sc.nextLine();
                    }
                    break;
                case 4:
                    System.out.print("Enter song name to search: ");
                    String target = sc.nextLine().trim();
                    boolean found = false;
                    for (String item : playlist) {
                        if (item.equalsIgnoreCase(target)) {
                            System.out.println("Song found: " + item);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Song not found.");
                    break;
                case 5:
                    System.out.println("Thank you for using Music Playlist Manager!");
                    break;
                default:
                    System.out.println("Invalid choice. Select 1 to 5.");
            }
        } while (choice != 5);

        sc.close();
    }
}
