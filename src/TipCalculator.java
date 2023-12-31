import java.util.Scanner;
import java.util.ArrayList;
public class TipCalculator {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        ArrayList itemList = new ArrayList();

        // Welcome screen, asks user for number of people and the tip percentage
        System.out.println("Welcome to the tip calculator!");
        System.out.print("How many people are in your group: ");
        int people = scan.nextInt();
        scan.nextLine();
        System.out.print("What's the tip percentage? (0-100): ");
        double tipPercent = scan.nextDouble() / 100;
        scan.nextLine();

        // initializing variables, getting the costs of the items from the user
        int count = 0;
        double totalCost = 0;
        double cost = 0;
        while (cost != -1) {
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): ");
            cost = scan.nextDouble();
            scan.nextLine();
            // if cost is -1, the cost and number of items won't update
            if (cost != -1) {
                System.out.print("Enter the item: ");
                itemList.add(scan.nextLine());
                totalCost += cost;
                count++;
            }
        }

        // variables reduce complexity of program
        double costWithTip = tipPercent * totalCost + totalCost;
        double tipAmount = tipPercent * totalCost;

        // ending screen with calculations rounded to two decimal points
        System.out.println("----------------------------------");
        System.out.println("Total bill before tip: $" + Math.round(100 * totalCost) / 100.0);
        System.out.println("Total percentage : " + tipPercent * 100 + "%");
        System.out.println("Total tip: $" + Math.round(100 * tipAmount) / 100.0);
        System.out.println("Total bill with tip : $" + Math.round(100 * costWithTip) / 100.0);
        System.out.println("Per person cost before tip : $" + Math.round(totalCost/ people * 100) / 100.0);
        System.out.println("Tip per person: $" + Math.round(100 * tipAmount / people) / 100.0);
        System.out.println("Total cost per person: $" + Math.round(((costWithTip) / people * 100)) / 100.0);
        System.out.println("----------------------------------");

        // extra credit and freestyle part, telling the user how many items they ordered and the names of the items
        System.out.println("You ordered " + count + " items.");
        System.out.println("Items ordered: ");
        for (Object item : itemList) {
            System.out.println(item);
        }
        System.out.println("----------------------------------");
    }
}

