package budget;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import static budget.ListOfCommands.fullListOfCategories;
import static budget.ListOfCommands.getTotalSum;
import static budget.Perfomance.*;

public class Engine {
    protected static void categories(String s, int j) {
        switch (j) {
            case 1:
                if(categories.containsKey("Food"))
                    categories.put("Food", categories.get("Food") + ", " + s );
                else
                    categories.put("Food", s);
                break;
            case 2:
                if(categories.containsKey("Clothes"))
                    categories.put("Clothes", categories.get("Clothes")+ ", " + s);
                else
                    categories.put("Clothes", s);
                break;
            case 3:
                if(categories.containsKey("Entertainment"))
                    categories.put("Entertainment", categories.get("Entertainment")+ ", " + s);
                else
                    categories.put("Entertainment", s);
                break;
            case 4:
                if(categories.containsKey("Other"))
                    categories.put("Other", categories.get("Other")+ ", " + s);
                else
                    categories.put("Other", s);
                break;
            case 5:
                System.out.println();
                break;
            default:
                break;

        }
    }


    protected static void getCategories(int i) {
        Scanner sc = new Scanner(System.in);
        switch (i) {
            case 1:
                String s = categories.getOrDefault("Food", "The purchase list is empty!");
                if (!s.equals("The purchase list is empty!")) {
                    System.out.println("Food:");
                    Arrays.stream(s.split(", ")).forEach(x -> System.out.println(x));
                    System.out.printf("Total sum: $%.2f\n", totalFoodSum);
                    System.out.println();
                } else System.out.println(s);
                fullListOfCategories();
                getCategories(sc.nextInt());
                break;
            case 2:
                String s1 = categories.getOrDefault("Clothes", "The purchase list is empty!");
                if (!s1.equals("The purchase list is empty!")) {
                    System.out.println("Clothes:");
                    System.out.println(s1);
                    System.out.printf("Total sum: $%.2f\n", totalClothesSum);
                    System.out.println();
                } else System.out.println(s1);
                fullListOfCategories();
                getCategories(sc.nextInt());
                break;
            case 3:
                String s2 = categories.getOrDefault("Entertainment", "The purchase list is empty!");
                if (!s2.equals("The purchase list is empty!")) {
                    System.out.println("Entertainment:");
                    System.out.println(s2);

                    System.out.printf("Total sum: $%.2f\n", totalEntertainmentSum);
                    System.out.println();
                } else System.out.println(s2);
                fullListOfCategories();
                getCategories(sc.nextInt());
                break;
            case 4:
                String s3 = categories.getOrDefault("Other", "The purchase list is empty!");
                if (!s3.equals("The purchase list is empty!")) {
                    System.out.println("Other:");
                    System.out.println(s3);
                    System.out.printf("Total sum: $%.2f\n", totalOtherSum);
                    System.out.println();
                } else  {
                    System.out.println(s3);
                    System.out.println();
                }
                fullListOfCategories();
                getCategories(sc.nextInt());
                break;
            case 5:
                System.out.println();
                System.out.println("All: ");
                for (Map.Entry<String, String> pair : categories.entrySet()) {
                    Arrays.stream(pair.getValue().split(",")).map(x -> x.trim()).forEach(x -> System.out.println(x));
                }
                getTotalSum();
                System.out.println();
                fullListOfCategories();
                getCategories(sc.nextInt());
                break;
            case 6:
                System.out.print("");
                break;
            default:
                break;
        }
    }
}
