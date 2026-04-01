import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class TrainConsistManagementApp{
    static class Bogie {
        String name;
        int capacity;
        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC13 - Performance Comparison (Benchmark) ");
        System.out.println("==========================================\n");
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
        }
        System.out.println("Processing " + bogies.size() + " bogies for benchmark...\n");
        long startTimeLoop = System.nanoTime();
        List<Bogie> filteredByLoop = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                filteredByLoop.add(b);
            }
        }
        long endTimeLoop = System.nanoTime();
        long durationLoop = endTimeLoop - startTimeLoop;
        System.out.println("--- Loop-Based Result ---");
        System.out.println("Filtered Count : " + filteredByLoop.size());
        System.out.println("Execution Time : " + durationLoop + " ns");
        System.out.println();
        long startTimeStream = System.nanoTime();
        List<Bogie> filteredByStream = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endTimeStream = System.nanoTime();
        long durationStream = endTimeStream - startTimeStream;
        System.out.println("--- Stream-Based Result ---");
        System.out.println("Filtered Count : " + filteredByStream.size());
        System.out.println("Execution Time : " + durationStream + " ns");
        System.out.println("\nUC13 performance benchmarking completed...");
    }
}