package munozmanzano.josemanuel.billsburgers;

public class DeluxeHamburger extends Hamburger {

    // instance variables
    private Chips chips;
    private Drink drink;

    // constructor
    public DeluxeHamburger(String breadType) {
        super("Deluxe Hamburger", 5.5, breadType, 0);
        chips = new Chips(0, true);
        drink = new Drink(0, true);
    }

    // instance methods

    @Override
    public void showPrice() {
        System.out.println("Name: " + super.getName());
        System.out.println("Bread: " + super.getBread().getName());
        System.out.println("Meat: " + super.getMeat().getName());
        System.out.println("Chips: " + this.getChips().getName());
        System.out.println("Chips: " + this.getDrink().getName());
        System.out.println("Price base: " + super.getBasePrice());
    }

    public Chips getChips() {
        return chips;
    }

    public Drink getDrink() {
        return drink;
    }
}
