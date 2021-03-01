package budget;

import java.util.*;

import static budget.ListOfCommands.getTotalSum;
import static budget.ListOfCommands.sort;
import static budget.Perfomance.*;

public class Sort {
    static Map<Double, String> food = new TreeMap<>(Comparator.reverseOrder());
    static Map<Double, String> entertainment = new TreeMap<>(Comparator.reverseOrder());
    static Map<Double, String> clothes = new TreeMap<>(Comparator.reverseOrder());
    static Map<Double, String> other = new TreeMap<>(Comparator.reverseOrder());
    protected static void doSort() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 1:
                if (categories.size() == 0) {
                    System.out.println("The purchase list is empty!");
                    System.out.println();
                } else getCategories2(5);
                sort();
                doSort();
                break;
            case 2:
                System.out.printf("Food - $%.2f\n", totalFoodSum);
                System.out.printf("Entertainment - $%.2f\n", totalEntertainmentSum);
                System.out.printf("Clothes - $%.2f\n", totalClothesSum);
                System.out.printf("Other - $%.2f\n", totalOtherSum);
                getTotalSum();
                System.out.println();
                sort();
                doSort();
                break;
            case 3:
                System.out.println("Choose the type of purchase");
                System.out.println(
                        "1) Food\n" +
                                "2) Clothes\n" +
                                "3) Entertainment\n" +
                                "4) Other\n"
                );
                getCategories2(sc.nextInt());
                sort();
                doSort();
                break;
            default:
                break;
        }
    }
    protected static void getCategories2(int i) {

        Map<Double, List<String>> sorted = new TreeMap<>(Comparator.reverseOrder());
        Scanner sc = new Scanner(System.in);
        switch (i) {
            case 1:
                String s = Perfomance.categories.getOrDefault("Food", "The purchase list is empty!");
                if (!s.equals("The purchase list is empty!")) {
                    System.out.println("Food:");
                    Arrays.stream(categories.get("Food").split(", ")).forEach(x -> food.put(Double.parseDouble(x.split("\\$")[x.split("\\$").length - 1].trim()), x.trim()));
                    for (Map.Entry<Double, String> pair : food.entrySet()) {
                        System.out.println(pair.getValue());
                    }
                    System.out.printf("Total sum: $%.2f\n", totalFoodSum);
                    System.out.println();
                } else System.out.println(s);
                break;
            case 2:
                String s1 = categories.getOrDefault("Clothes", "The purchase list is empty!");
                if (!s1.equals("The purchase list is empty!")) {
                    System.out.println("Clothes:");
                    Arrays.stream(categories.get("Clothes").split(", ")).forEach(x -> clothes.put(Double.parseDouble(x.split("\\$")[x.split("\\$").length - 1].trim()), x.trim()));
                    for (Map.Entry<Double, String> pair : clothes.entrySet()) {
                        System.out.println(pair.getValue());
                    }
                    System.out.printf("Total sum: $%.2f\n", totalClothesSum);
                    System.out.println();
                } else System.out.println(s1);
                break;
            case 3:
                String s2 = categories.getOrDefault("Entertainment", "The purchase list is empty!");
                if (!s2.equals("The purchase list is empty!")) {
                    System.out.println("Entertainment:");
                    Arrays.stream(categories.get("Entertainment").split(", ")).forEach(x -> entertainment.put(Double.parseDouble(x.split("\\$")[x.split("\\$").length - 1].trim()), x.trim()));
                    for (Map.Entry<Double, String> pair : entertainment.entrySet()) {
                        System.out.println(pair.getValue());
                    }
                    System.out.printf("Total sum: $%.2f\n", totalEntertainmentSum);
                    System.out.println();
                } else System.out.println(s2);
                break;
            case 4:
                String s3 = categories.getOrDefault("Other", "The purchase list is empty!");
                if (!s3.equals("The purchase list is empty!")) {
                    System.out.println("Other:");
                    Arrays.stream(categories.get("Other").split(", ")).forEach(x -> other.put(Double.parseDouble(x.split("\\$")[x.split("\\$").length - 1].trim()), x.trim()));
                    for (Map.Entry<Double, String> pair : other.entrySet()) {
                        System.out.println(pair.getValue());
                    }
                    System.out.printf("Total sum: $%.2f\n", totalOtherSum);
                    System.out.println();
                } else  {
                    System.out.println(s3);
                    System.out.println();
                }
                break;
            case 5:
                System.out.println();
                System.out.println("All: ");
                for (String pair : categories.values()) {
                    String[] array = pair.split(", ");
                    for (String ss : array) {
                        double string = Double.parseDouble(ss.split("\\$")[ss.split("\\$").length - 1]);
                        if (sorted.containsKey(string)) {
                            sorted.get(string).add(ss.trim());
                        } else {
                            List<String> purs = new ArrayList<>();
                            purs.add(ss.trim());
                            sorted.put(string, purs);
                        }
                    }
                }
                for (List<String> pair : sorted.values()) {
                    pair.stream().forEach(x -> System.out.println(x));
                }
                getTotalSum();
                System.out.println();
                break;
            case 6:
                System.out.print("");
                break;
            default:
                break;
        }
    }
}
