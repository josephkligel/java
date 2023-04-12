import java.util.ArrayList;


public class CafeUtil {
    
    int getStreakGoal(int numOfWeeks){
        int sum = 0;

        for(int i = 1; i <= numOfWeeks; ++i){
            sum += i;
        }

        return sum;
    }

    double getOrderTotal(double[] prices){
        double total = 0.0;

        int i = 0;
        int length = prices.length;
        while(i < length){
            total += prices[i];
            ++i;
        }

        return total;
    }

    void displayMenu(ArrayList<String> menuItems){
        int length = menuItems.size();

        for(int i = 0; i < length; ++i){
            System.out.println(i + " " + menuItems.get(i));
        }
    }

    void displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices){
        if(menuItems.size() == prices.size()){
            for(int i = 0; i < menuItems.size(); ++i){
                System.out.printf("%d %s -- $%.2f\n", i , menuItems.get(i), prices.get(i));
            }
        }
    }

    void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter you name: ");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName + "!");

        int length = customers.size();
        System.out.printf("There are %d people in front of you%n", length);

        customers.add(userName);

        System.out.println(customers);
    }

    void printPriceChart(String product, double price, int maxQuantity){
        System.out.printf("\n ---------------- %s ----------------\n", product);
        for(int i = 1; i <= maxQuantity; ++i){
            double total = i * price - ( 0.5 * (i -1) );
            System.out.printf("%d - $%.2f\n", i, total);
        }
    }

    void addCustomers(ArrayList<String> customers){
        String userName = null;

        while(true){
            System.out.println("Please enter you name: ");
            userName = System.console().readLine();

            if(userName.equals("q")) break;

            System.out.println("Hello, " + userName + "!");

            int length = customers.size();
            System.out.printf("There are %d people in front of you%n", length);

            customers.add(userName);

            System.out.println(customers);
        }
    }
}
