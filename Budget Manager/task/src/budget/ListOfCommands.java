package budget;

import static budget.Perfomance.totalSum;

public class ListOfCommands {
    public static void listOfCommands() {
        System.out.println("Choose your action: \n" +
                "1) Add income\n" +
                "2) Add purchase\n" +
                "3) Show list of purchases\n" +
                "4) Balance\n" +
                "5) Save\n" +
                "6) Load\n" +
                "7) Analyze (Sort)\n" +
                "0) Exit\n");
    }
    public static void sort() {
        System.out.println("How do you want to sort?");
        System.out.println("1) Sort all purchases");
        System.out.println("2) Sort by type");
        System.out.println("3) Sort certain type");
        System.out.println("4) Back");
        System.out.println();
    }
    public static void listOfCategories() {
        System.out.println(
                "1) Food\n" +
                        "2) Clothes\n" +
                        "3) Entertainment\n" +
                        "4) Other\n" +
                        "5) Back\n"
        );
    }

    public static void fullListOfCategories() {
        System.out.println(
                "1) Food\n" +
                        "2) Clothes\n" +
                        "3) Entertainment\n" +
                        "4) Other\n" +
                        "5) All\n" +
                        "6) Back\n"
        );
    }
    protected static void getTotalSum() {
        System.out.printf("Total sum: $%.02f", totalSum);
        System.out.println();
    }

}
