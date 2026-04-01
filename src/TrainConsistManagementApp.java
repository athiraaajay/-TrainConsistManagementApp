import java.util.ArrayList;
import java.util.List;
public class TrainConsistManagementApp {
    static class Bogie {
        String name;
        int capacity;
        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
        @Override
        public String toString() {
            return name + " (" + capacity + " seats)";
        }
    }
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   UC10 - Count Total Seats (Reduction)   ");
        System.out.println("==========================================\n");
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));
        System.out.println("Current Train Consist:");
        bogies.forEach(System.out::println);
        System.out.println();
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
        System.out.println("Total Seating Capacity of the Train: " + totalSeats + " seats");
        System.out.println("\nUC10 capacity aggregation completed successfully...");
    }
}