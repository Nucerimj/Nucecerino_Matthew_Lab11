import java.util.ArrayList;

public class Listmaker {
    private static final ArrayList<String> myList = new ArrayList<>();

    public static void main(String[] args) {
        char choice;
        do {
            displayMenu();
            choice = Safeinput.getRegExChar("Enter your choice: ", "[AaDdPpQq]");
            switch (choice) {
                case 'A':
                case 'a':
                    addItem();
                    break;
                case 'D':
                case 'd':
                    deleteItem();
                    break;
                case 'P':
                case 'p':
                    printList();
                    break;
                case 'Q':
                case 'q':
                    if (confirmQuit()) {
                        System.out.println("Exiting program...");
                        return;
                    }
                    break;
            }
        } while (true);
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("A – Add an item to the list");
        System.out.println("D – Delete an item from the list");
        System.out.println("P – Print the list");
        System.out.println("Q – Quit");
        System.out.println();
        System.out.println("Current List:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println((i + 1) + ". " + myList.get(i));
        }
        System.out.println();
    }

    private static void addItem() {
        String item = Safeinput.getString("Enter the item to add: ");
        myList.add(item);
        System.out.println("Item added successfully.");
        System.out.println();
    }

    private static void deleteItem() {
        if (myList.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        int index = Safeinput.getRangedInt("Enter the number of the item to delete: ", 1, myList.size()) - 1;
        String removedItem = myList.remove(index);
        System.out.println("Item \"" + removedItem + "\" removed successfully.");
        System.out.println();
    }

    private static void printList() {
        if (myList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Current List:");
            for (String item : myList) {
                System.out.println(item);
            }
        }
        System.out.println();
    }

    private static boolean confirmQuit() {
        return Safeinput.getYNConfirm("Are you sure you want to quit? (y/n): ");
    }
}
