package cours2.restaurantPrac;

import java.util.*;

public class mainProg {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Consumable> food_menu = new ArrayList<Consumable>();

        boolean is_menu_complete = false;
        int menu_choice = -1;

        while (!is_menu_complete) {
            menu_choice = validateInput(scan, "1. add to menu \n2. Quit and show current menu", 1, 2);
            if (menu_choice == 2) {
                is_menu_complete = true;
                continue;
            }
            Consumable new_food = createNewMenuItem(scan);
            food_menu.add(new_food);

            System.out.println("----------------------------");
            System.out.println("Successfully added - " + new_food.getItemName() + " - to menu");
            System.out.println("----------------------------");

        }
        scan.close();
        printMenu(food_menu);

    }

    /**
     * Function that will prompt the user to enter a valid input until they entered
     * a valid value The variables associated with the range of acceptable values(
     * min and max) should be left at 0 and 0 if there is no range
     * 
     * @param scan    Scanner that will be scanning for user input
     * @param message String containing instructions for the user on how to comply
     * @param min     Integer which is the minimum in the accepted range of input
     * @param max     Integer which is the maximum in the accepted input range
     * 
     * @return integer that is within valid range
     */
    public static int validateInput(Scanner scan, String message, int min, int max) {
        int valid_input = -1;
        boolean successfully_collected_input = false;
        while (!successfully_collected_input) {
            System.out.println(message);
            try {
                valid_input = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("please enter an integer");
                continue;
            }

            if ((min == max) ^ (valid_input >= min && valid_input <= max))
                successfully_collected_input = true;
            else
                System.out.println("make sure your integer is within range");
        }

        return valid_input;
    }

    /**
     * Function creates a new menu item by prompting the user to add a String name and an int Price
     * 
     * @param scan Scanner to get the user to add to the menu
     * @return an object of type Consumables complete with a name and a price
     */
    public static Consumable createNewMenuItem(Scanner scan) {
        System.out.println("--------------------------");
        System.out.println("Menu item name: ");
        String current_food = scan.nextLine();
        
        Consumable new_food = new Consumable(current_food);

        new_food.setPrice(validateInput(scan, "Price (in whole dollars): ", 0, 0));
        return new_food;
    }

    /**
     * Function that prints a menu
     * 
     * @param menu an arraylist of Consumables Objects containing a menu's worth of
     *             items
     */
    public static void printMenu(ArrayList<Consumable> menu) {
        System.out.println("\n \n ");
        if (menu.isEmpty())
            System.out.println("Menu has not been created!");
        else {
            System.out.println("----------- Menu ----------------");
            for (int i = 0; i < menu.size(); i++) {
                Consumable food_on_the_menu = menu.get(i);
                System.out.println(food_on_the_menu.getItemName() + " --- $" + food_on_the_menu.getPrice());
                System.out.println("-------------------------");

            }
        }
        System.out.println("End of Menu");
    }

}
