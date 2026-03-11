import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuizEngine engine = new QuizEngine();
        ResultHandler reporter = new ResultHandler();

        System.out.println("=== Welcome to the Java Quiz Pro ===");
        System.out.print("Enter your name to start: ");
        String name = sc.nextLine();

        int score = engine.startQuiz(sc);
        int total = engine.getTotalQuestions();
        double percent = ((double) score / total) * 100;

        System.out.println("\n--- FINAL RESULT ---");
        System.out.printf("Score: %d/%d (%.2f%%)%n", score, total, percent);
        System.out.println("Status: " + (percent >= 50.0 ? "PASS" : "FAIL"));

        reporter.saveResult(name, score, total, percent);
        System.out.println("Thank you for playing!");
        sc.close();
    }
}
