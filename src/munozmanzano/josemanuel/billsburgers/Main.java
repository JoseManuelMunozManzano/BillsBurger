package munozmanzano.josemanuel.billsburgers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // The purpose of the application is to help a fictitious company called Bills Burgers to manage
        // their process of selling hamburgers.
        // Our application will help Bill to select types of burgers, some of the additional items (additions) to
        // be added to the burgers and pricing.
        // We want to create a base hamburger, but also two other types of hamburgers that are popular ones in Bills store.
        // The basic hamburger should have the following items.
        // Bread roll type, meat and up to 4 additional additions (things like lettuce, tomato, carrot, etc) that
        // the customer can select to be added to the burger.
        // Each one of these items gets charged an additional price so you need some way to track how many items got added
        // and to calculate the final price (base burger with all the additions).
        // This burger has a base price and the additions are all separately priced (up to 4 additions, see above).
        // Create a Hamburger class to deal with all the above.
        // The constructor should only include the roll type, meat and price, can also include name of burger or you
        // can use a setter.
        // Also create two extra varieties of Hamburgers (subclasses) to cater for
        // a) Healthy burger (on a brown rye bread roll), plus two addition items that can be added.
        // The healthy burger can have 6 items (Additions) in total.
        // hint:  you probably want to process the two additional items in this new class (subclass of Hamburger),
        // not the base class (Hamburger), since the two additions are only appropriate for this new class
        // (in other words new burger type).
        // b) Deluxe hamburger - comes with chips and drinks as additions, but no extra additions are allowed.
        // hint:  You have to find a way to automatically add these new additions at the time the deluxe burger
        // object is created, and then prevent other additions being made.
        //  All 3 classes should have a method that can be called anytime to show the base price of the hamburger
        // plus all additionals, each showing the addition name, and addition price, and a grand/final total for the
        // burger (base price + all additions)
        // For the two additional classes this may require you to be looking at the base class for pricing and then
        // adding totals to final price.
        Scanner scanner = new Scanner(System.in);
        int numMenu = 1;
        int numHamburger = 0;
        int numBread;
        int option;
        Hamburger hamburger = null;
        while (true) {
            if (numMenu == 1) {
                menu1();
                option = scanner.nextInt();
                scanner.nextLine();
                if (option == 4) {
                    scanner.close();
                    break;
                } else {
                    numHamburger = option;
                    if (numHamburger == 2) {
                        numBread = 1;
                        hamburger = obtainHamburger(numHamburger, numBread);
                        numMenu = 3;
                    } else {
                        numMenu = 2;
                    }
                }
            }

            if (numMenu == 2) {
                menu2();
                option = scanner.nextInt();
                scanner.nextLine();
                if (option == 4) {
                    numMenu = 1;
                } else {
                    numBread = option;
                    hamburger = obtainHamburger(numHamburger, numBread);
                    numMenu = 3;
                }
            }

            if (numMenu == 3) {
                menu3();
                option = scanner.nextInt();
                scanner.nextLine();
                if (option == 11) {
                    numMenu = 1;
                    hamburger = null;
                } else {
                    manageOption(hamburger, option);
                    if (option == 10) {
                        numMenu = 1;
                        hamburger = null;
                    }
                }
            }

        }
    }

    public static void menu1() {
        System.out.println("\tBills Burgers");
        System.out.println("1. Base Hamburger");
        System.out.println("2. Healthy Hamburger");
        System.out.println("3. Deluxe Hamburger");
        System.out.println("4. Quit");
        System.out.println();
        System.out.print("Option: ");
    }

    public static void menu2() {
        System.out.println("\tBills Burgers - Bread Types");
        System.out.println("1. Brown Rye Bread Roll");
        System.out.println("2. Corn Bread Roll");
        System.out.println("3. Special Bread");
        System.out.println("4. Cancel Order");
        System.out.println();
        System.out.print("Option: ");
    }

    public static void menu3() {
        System.out.println("Bills Burgers - Extra Ingredients");
        System.out.println("1. Bacon");
        System.out.println("2. Carrot");
        System.out.println("3. Cheese");
        System.out.println("4. Chips");
        System.out.println("5. Drink");
        System.out.println("6. Lettuce");
        System.out.println("7. Meat");
        System.out.println("8. Tomato");
        System.out.println("9. Show Order");
        System.out.println("10. Order");
        System.out.println("11. Cancel Order");
        System.out.println();
        System.out.print("Option: ");
    }

    public static Hamburger obtainHamburger(int numHamburger, int numBread) {
        String[] breadTypes = {"Brown Rye Bread Roll", "Corn Bread Roll", "Special Bread"};
        String breadType = breadTypes[numBread - 1];

        switch (numHamburger) {
            case 1:
                return new Hamburger(breadType);
            case 2:
                return new HealthyBurger(breadType);
            case 3:
                return new DeluxeHamburger(breadType);
        }
        return null;
    }

    public static void manageOption(Hamburger hamburger, int option) {
        String[] ingredients = {"Bacon", "Carrot", "Cheese", "Chips", "Drink", "Lettuce", "Meat", "Tomato"};
        String ingredient = null;
        if (option < 9) {
            ingredient = ingredients[option - 1];
        }

        if (option <= 8) {
            hamburger.addIngredient(ingredient);
        } else if (option == 9) {
            hamburger.showPrice();
        } else if (option == 10) {
            hamburger.Order();
        }


    }

}
