import java.util.Scanner;

public class Safeinput {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static char getRegExChar(String prompt, String regex) {
        char input;
        do {
            System.out.print(prompt);
            String userInput = scanner.nextLine();
            if (userInput.length() > 0) {
                input = userInput.toLowerCase().charAt(0);
                if (!Character.toString(input).matches(regex)) {
                    System.out.println("Invalid input. Please try again.");
                } else {
                    break;
                }
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        } while (true);
        return input;
    }

    public static int getRangedInt(String prompt, int min, int max) {
        int value;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. " + prompt);
                scanner.next(); // Discard invalid input
            }
            value = scanner.nextInt();
        } while (value < min || value > max);
        scanner.nextLine(); // Consume newline
        return value;
    }

    public static boolean getYNConfirm(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y") || input.equals("yes");
    }
}
