package budget;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import static budget.ListOfCommands.*;
import java.util.*;

public class Main extends Perfomance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        listOfCommands();
        while (true) {
            int i = sc.nextInt();
            if (i == 0) {
                System.out.println();
                System.out.println("Bye!");
                break;
            }
            command(i);
            listOfCommands();
        }
    }

}