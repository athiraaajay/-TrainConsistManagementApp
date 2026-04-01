import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
            return name + " (Capacity: " + capacity + ")";
        }
    }
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC8 - Filter Passenger Bogies (Streams) ");
        System.out.println("==========================================\n");
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));
        System.out.println("All Passenger Bogies:");
        bogies.forEach(System.out::println);
        System.out.println();
        List<Bogie> highCapacityBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        System.out.println("High-Capacity Bogies (Capacity > 60):");
        if (highCapacityBogies.isEmpty()) {
            System.out.println("No bogies match the criteria.");
        } else {
            highCapacityBogies.forEach(System.out::println);
        }

        System.out.println("\nUC8 stream filtering completed successfully...");
    }
}