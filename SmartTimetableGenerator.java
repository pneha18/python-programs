import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SmartTimetableGenerator {
    private static final int DAYS = 5;
    private static final int PERIODS_PER_DAY = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== SMART TIMETABLE GENERATOR ===");
        System.out.print("How many subjects (2 to 10)? ");

        if (!sc.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            sc.close();
            return;
        }

        int subjectCount = sc.nextInt();
        sc.nextLine();
        if (subjectCount < 2 || subjectCount > 10) {
            System.out.println("Please choose between 2 and 10 subjects.");
            sc.close();
            return;
        }

        String[] subjects = new String[subjectCount];
        String[] faculty = new String[subjectCount];

        for (int i = 0; i < subjectCount; i++) {
            System.out.print("Enter subject " + (i + 1) + ": ");
            subjects[i] = sc.nextLine().trim();
            if (subjects[i].isEmpty()) subjects[i] = "Subject " + (i + 1);
            System.out.print("Enter faculty for " + subjects[i] + ": ");
            faculty[i] = sc.nextLine().trim();
            if (faculty[i].isEmpty()) faculty[i] = "Faculty TBA";
        }

        List<String> slots = new ArrayList<>();
        int totalSlots = DAYS * PERIODS_PER_DAY;
        for (int i = 0; i < totalSlots; i++) {
            slots.add(subjects[i % subjectCount]);
        }

        Collections.shuffle(slots);
        String[][] timetable = new String[DAYS][PERIODS_PER_DAY];

        for (int day = 0; day < DAYS; day++) {
            for (int period = 0; period < PERIODS_PER_DAY; period++) {
                int chosen = findNextSuitable(slots, period == 0 ? null : timetable[day][period - 1]);
                timetable[day][period] = slots.remove(chosen);
            }
        }

        System.out.println("\nWEEKLY TIMETABLE");
        System.out.printf("%-12s", "Day");
        for (int p = 1; p <= PERIODS_PER_DAY; p++) System.out.printf("| P%-10d", p);
        System.out.println();
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        for (int d = 0; d < DAYS; d++) {
            System.out.printf("%-12s", days[d]);
            for (int p = 0; p < PERIODS_PER_DAY; p++) {
                System.out.printf("| %-11s", timetable[d][p]);
            }
            System.out.println();
        }

        System.out.println("\nFACULTY LIST");
        for (int i = 0; i < subjectCount; i++) {
            System.out.println(subjects[i] + " - " + faculty[i]);
        }
        System.out.println("\nNote: This is a beginner demo. It does not check faculty clashes or college-specific rules.");
        sc.close();
    }

    private static int findNextSuitable(List<String> slots, String previousSubject) {
        if (previousSubject != null) {
            for (int i = 0; i < slots.size(); i++) {
                if (!slots.get(i).equals(previousSubject)) return i;
            }
        }
        return 0;
    }
}
