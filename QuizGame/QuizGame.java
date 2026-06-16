import java.util.Scanner;

public class QuizGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("      JAVA QUIZ GAME");
        System.out.println("================================");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        String[] questions = {
                "1. What is the capital of India?",
                "2. Which language is used for Android development?",
                "3. Which company developed Java?",
                "4. Which keyword is used for inheritance?",
                "5. Which loop executes at least once?",
                "6. Which symbol is used to end a statement in Java?",
                "7. Which method is the entry point of a Java program?",
                "8. Which package contains Scanner class?",
                "9. Which data type stores decimal values?",
                "10. Which operator is used for comparison?"
        };

        String[][] options = {
                {"A. Mumbai", "B. Delhi", "C. Kolkata", "D. Chennai"},
                {"A. Python", "B. Java", "C. HTML", "D. C"},
                {"A. Google", "B. Microsoft", "C. Sun Microsystems", "D. Apple"},
                {"A. super", "B. extends", "C. class", "D. implement"},
                {"A. while", "B. for", "C. do-while", "D. foreach"},
                {"A. :", "B. ;", "C. ,", "D. #"},
                {"A. start()", "B. execute()", "C. main()", "D. run()"},
                {"A. java.util", "B. java.io", "C. java.lang", "D. java.math"},
                {"A. int", "B. char", "C. double", "D. boolean"},
                {"A. =", "B. +", "C. ==", "D. &&"}
        };

        char[] answers = {'B', 'B', 'C', 'B', 'C', 'B', 'C', 'A', 'C', 'C'};

        int score = 0;

        for (int i = 0; i < questions.length; i++) {

            System.out.println("\n" + questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Enter your answer: ");
            char userAnswer = Character.toUpperCase(sc.next().charAt(0));

            if (userAnswer == answers[i]) {
                score++;
            }
        }

        double percentage = (score / 10.0) * 100;

        System.out.println("\n================================");
        System.out.println("Quiz Completed!");
        System.out.println("Player Name : " + name);
        System.out.println("Score : " + score + "/10");
        System.out.println("Percentage : " + percentage + "%");

        if (percentage >= 80)
            System.out.println("Performance : Excellent!");
        else if (percentage >= 60)
            System.out.println("Performance : Good!");
        else if (percentage >= 40)
            System.out.println("Performance : Average!");
        else
            System.out.println("Performance : Needs Improvement!");

        if (percentage >= 40)
            System.out.println("Result : PASS");
        else
            System.out.println("Result : FAIL");

        System.out.println("================================");

        sc.close();
    }
}