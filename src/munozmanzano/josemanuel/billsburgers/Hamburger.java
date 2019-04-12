package munozmanzano.josemanuel.billsburgers;

public class Hamburger {

    // instance variables
    private String name;
    private double basePrice;
    private double totalPrice;
    private int totalExtraIngredients;
    private int countExtraIngredients;
    private Bread bread;
    private Meat meat;
    private Ingredient[] ingredients;

    // constructor
    public Hamburger(String breadType) {
        this("Base Hamburger", 3.5, breadType, 4);
    }


    public Hamburger(String name, double basePrice, String breadType, int extraIngredients) {
        this.name = name;
        this.basePrice = basePrice;
        this.totalPrice = basePrice;
        this.totalExtraIngredients = extraIngredients;
        this.countExtraIngredients = 0;

        switch (breadType) {
            case "Brown Rye Bread Roll":
                bread = new BrownRyeBreadRoll();
                break;
            case "Corn Bread Roll":
                bread = new CornBreadRoll();
                break;
            case "Special Bread":
                bread = new SpecialBread();
                break;
        }

        this.meat = new Meat(0, true);
        this.ingredients = new Ingredient[extraIngredients];
    }

    // instance methods
    public void Order() {
        showPrice();
        System.out.println("The order is being prepared!");
    }

    public void showPrice() {
        System.out.println("Name: " + name);
        System.out.println("Bread: " + bread.getName());
        System.out.println("Meat: " + meat.getName());
        System.out.println("Price base: " + basePrice);
        int index = 0;
        while (index < totalExtraIngredients && ingredients[index] != null) {
            writeExtraIngredient(ingredients[index]);
            index++;
        }
        System.out.println("Total price: " + totalPrice);
        System.out.println();
    }

    public void addIngredient(String ingredient) {
        if (countExtraIngredients == totalExtraIngredients) {
            System.out.println("You can't add more extra ingredients.");
        }
        else {
            // add quantity to an existing ingredient
            int index = 0;
            boolean ingredientFound = false;
            while (index < totalExtraIngredients && ingredients[index] != null) {
                if (ingredients[index].getName().equals(ingredient)) {
                    ingredientFound = true;
                    ingredients[index].addIngredient();
                    writeExtraIngredient(ingredients[index]);
                    totalPrice += ingredients[index].getPrice();
                    break;
                }
                index++;
            }
            if (!ingredientFound) {
                createIngredientClass(ingredient, countExtraIngredients++);
                totalPrice += ingredients[countExtraIngredients-1].getPrice();
                writeExtraIngredient(ingredients[countExtraIngredients-1]);
            }
        }
    }

    private void writeExtraIngredient(Ingredient ingredient) {
        System.out.println(ingredient.getName() + ":");
        System.out.println("\tQuantity: " + ingredient.getCount());
        System.out.println("\tPrice: " + ingredient.getPrice() * ingredient.getCount());
    }

    private void createIngredientClass(String ingredient, int index) {
        switch (ingredient) {
            case "Bacon":
                ingredients[index] = new Bacon(1);
                break;
            case "Carrot":
                ingredients[index] = new Carrot(1);
                break;
            case "Cheese":
                ingredients[index] = new Cheese(1);
                break;
            case "Chips":
                ingredients[index] = new Chips(1, false);
                break;
            case "Drink":
                ingredients[index] = new Drink(1, false);
                break;
            case "Lettuce":
                ingredients[index] = new Lettuce(1);
                break;
            case "Meat":
                ingredients[index] = new Meat(1, false);
                break;
            case "Tomato":
                ingredients[index] = new Tomato(1);
                break;
        }
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getTotalExtraIngredients() {
        return totalExtraIngredients;
    }

    public int getCountExtraIngredients() {
        return countExtraIngredients;
    }

    public Bread getBread() {
        return bread;
    }

    public Meat getMeat() {
        return meat;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }
}
