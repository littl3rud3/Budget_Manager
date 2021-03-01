package budget;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

import static budget.ListOfCommands.*;
import static budget.Sort.doSort;
import static budget.Engine.*;


public class Perfomance {
    static double income = 0;
    static double totalSum = 0;
    static double totalFoodSum = 0;
    static double totalClothesSum = 0;
    static double totalEntertainmentSum = 0;
    static double totalOtherSum = 0;
    static Map<String, String> categories = new LinkedHashMap<>();
    protected static void command(int i) {
        Scanner sc = new Scanner(System.in);
        switch (i) {
            case 1:
                System.out.println();
                System.out.println("Enter income:");
                income += sc.nextDouble();
                System.out.println("Income was added!");
                System.out.println();
                break;
            case 2:
                while (true) {
                    System.out.println("Choose the type of purchases");
                    listOfCategories();
                    String id = sc.nextLine();
                    if (id.equals("5")) break;
                    int idk1 = Integer.parseInt(id);
                    System.out.println("Enter purchase name:");
                    String purchase = sc.nextLine() + " $";
                    System.out.println("Enter its price:");
                    String pruce = sc.nextLine();
                    double price = Double.parseDouble(pruce);
                    NumberFormat formatter = new DecimalFormat("#0.00");
                    categories(purchase.concat(String.valueOf(formatter.format(price))), idk1);
                    System.out.println("Purchase was added!");
                    System.out.println();
                    totalSum += price;
                    income -= price;
                }
                break;
            case 3:
                if (categories.size() == 0) System.out.println("The purchase list is empty!");
                else {
                    System.out.println();
                    System.out.println("Choose the type of purchases");
                    fullListOfCategories();
                    getCategories(sc.nextInt());
                }
                break;
            case 4:
                System.out.println();
                System.out.printf("Balance: $%.2f\n", income);
                System.out.println();
                break;
            case 5:
                File file = new File("purchases.txt");
                try (PrintWriter printWriter = new PrintWriter(file)) {
                    printWriter.write(income+ " ");
                    printWriter.write(totalSum + " ");
                    for (Map.Entry<String, String> pair : categories.entrySet()) {
                        printWriter.write(pair.getKey() + " " + pair.getValue() + "\n");
                    }
                    System.out.println("Purchases were saved!");
                    System.out.println();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case 6:
                File file1 = new File("purchases.txt");
                try (Scanner scanner = new Scanner(file1)) {
                    income = Double.parseDouble(scanner.next());
                    totalSum = Double.parseDouble(scanner.next());
                    while (scanner.hasNext()) {
                        categories.put(scanner.next(),scanner.nextLine());
                    }
                    System.out.println();
                    System.out.println("Purchases were loaded!");
                    System.out.println();
                    if (categories.get("Food").contains(","))
                        totalFoodSum += Arrays.stream(categories.get("Food").split(", ")).map(x -> Double.parseDouble(x.split("\\$")[x.split("\\$").length - 1])).reduce((x,y) -> x + y).get();
                    else {
                        totalFoodSum += Double.parseDouble(categories.get("Food").split("\\$")[1]);
                    }
                    if (categories.get("Clothes").contains(","))
                        totalClothesSum += Arrays.stream(categories.get("Clothes").split(", ")).map(x -> Double.parseDouble(x.split("\\$")[x.split("\\$").length - 1])).reduce((x,y) -> x + y).get();
                    else {
                        totalClothesSum += Double.parseDouble(categories.get("Clothes").split("\\$")[1]);
                    }
                    if (categories.get("Entertainment").contains(","))
                        totalEntertainmentSum += Arrays.stream(categories.get("Entertainment").split(", ")).map(x -> Double.parseDouble(x.split("\\$")[x.split("\\$").length - 1])).reduce((x,y) -> x + y).get();
                    else {
                        totalEntertainmentSum += Double.parseDouble(categories.get("Entertainment").split("\\$")[1]);
                    }
                    if (categories.get("Other").contains(","))
                        totalOtherSum += Arrays.stream(categories.get("Other").split(", ")).map(x -> Double.parseDouble(x.split("\\$")[x.split("\\$").length - 1])).reduce((x,y) -> x + y).get();
                    else {
                        totalOtherSum += Double.parseDouble(categories.get("Other").split("\\$")[1]);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case 7:
                sort();
                doSort();
                break;
            default:
                break;

        }
    }


}
