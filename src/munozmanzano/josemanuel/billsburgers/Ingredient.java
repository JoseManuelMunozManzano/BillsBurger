package munozmanzano.josemanuel.billsburgers;

public class Ingredient {

    // instance variables
    private String name;
    private int count;
    private double price;
    private boolean baseIngredient;

    // constructor
    public Ingredient(String name, int count, double price, boolean baseIngredient) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.baseIngredient = baseIngredient;
    }

    // instance methods
    public void addIngredient() {
        this.count++;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBaseIngredient() {
        return baseIngredient;
    }
}
