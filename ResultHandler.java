import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class ResultHandler {
    private static final String FILE_NAME = "results.txt";

    public void saveResult(String userName, int score, int total, double percent) {
        String status = (percent >= 50.0) ? "PASS" : "FAIL";
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             PrintWriter pw = new PrintWriter(fw)) {
            
            pw.printf("User: %s | Score: %d/%d | Percentage: %.2f%% | Status: %s%n", 
                      userName, score, total, percent, status);
            System.out.println("Result saved to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error saving results: " + e.getMessage());
        }
    }
}
