import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles the logic of running the quiz, scoring, and input validation.
 */
public class QuizEngine {
    private final ArrayList<Question> questionBank;
    private int score;

    public QuizEngine() {
        this.questionBank = new ArrayList<>();
        this.score = 0;
        loadSampleQuestions();
    }

    private void loadSampleQuestions() {
        questionBank.add(new Question("Which keyword is used to inherit a class in Java?", 
            new String[]{"implements", "extends", "inherits", "using"}, 1));
        questionBank.add(new Question("What is the default value of a boolean in Java?", 
            new String[]{"true", "false", "null", "0"}, 1));
        questionBank.add(new Question("Which OOP concept focuses on hiding internal details?", 
            new String[]{"Inheritance", "Polymorphism", "Encapsulation", "Abstraction"}, 2));
    }

    public int startQuiz(Scanner sc) {
        score = 0;
        for (int i = 0; i < questionBank.size(); i++) {
            Question q = questionBank.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.getQuestionText());
            String[] opts = q.getOptions();
            for (int j = 0; j < opts.length; j++) {
                System.out.println((j + 1) + ". " + opts[j]);
            }

            int userChoice = getValidInteger(sc, 1, 4);
            if (userChoice - 1 == q.getCorrectAnswerIndex()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + opts[q.getCorrectAnswerIndex()]);
            }
        }
        return score;
    }

    private int getValidInteger(Scanner sc, int min, int max) {
        while (true) {
            System.out.print("Your answer (" + min + "-" + max + "): ");
            try {
                int input = Integer.parseInt(sc.nextLine());
                if (input >= min && input <= max) return input;
                System.out.println("Out of range. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public int getTotalQuestions() { return questionBank.size(); }
}
