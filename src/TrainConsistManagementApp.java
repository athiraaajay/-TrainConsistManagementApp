import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println(" UC11 - Validate Train ID & Cargo Codes ");
        System.out.println("==========================================\n");
        String trainIDRegex = "TRN-\\d{4}";
        String cargoCodeRegex = "PET-[A-Z]{2}";
        Pattern trainPattern = Pattern.compile(trainIDRegex);
        Pattern cargoPattern = Pattern.compile(cargoCodeRegex);
        String[] testTrainIDs = {"TRN-1234", "TRAIN12", "TRN-123", "TRN-12345"};
        String[] testCargoCodes = {"PET-AB", "PET-ab", "PET123", "AB-PET"};
        System.out.println("--- Train ID Validation ---");
        for (String id : testTrainIDs) {
            Matcher matcher = trainPattern.matcher(id);
            if (matcher.matches()) {
                System.out.println("Train ID: " + id + " -> VALID");
            } else {
                System.out.println("Train ID: " + id + " -> INVALID");
            }
        }
        System.out.println("\n--- Cargo Code Validation ---");
        for (String code : testCargoCodes) {
            Matcher matcher = cargoPattern.matcher(code);
            if (matcher.matches()) {
                System.out.println("Cargo Code: " + code + " -> VALID");
            } else {
                System.out.println("Cargo Code: " + code + " -> INVALID");
            }
        }
        System.out.println("\nUC11 validation processing completed...");
    }
}