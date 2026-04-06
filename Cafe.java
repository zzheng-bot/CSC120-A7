public class Cafe extends Building implements CafeRequirements {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    //Constructor
    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;

        System.out.println("You have built a cafe: ☕");
    }

    //Sells coffee and updates inventory
    public void sellCoffee(int size, int sugar, int cream) {

        if (nCoffeeOunces < size || nSugarPackets < sugar || nCreams < cream || nCups < 1) {
            restock(100, 50, 50, 50);
        }

        nCoffeeOunces -= size;
        nSugarPackets -= sugar;
        nCreams -= cream;
        nCups -= 1;
    }

    private void restock(int coffee, int sugar, int cream, int cups) {
        nCoffeeOunces += coffee;
        nSugarPackets += sugar;
        nCreams += cream;
        nCups += cups;
    }

    public static void main(String[] args) {
        Cafe cafe = new Cafe("Campus Cafe", "1 College Lane", 1, 50, 20, 20, 10);

        cafe.sellCoffee(12, 2, 1);
        cafe.sellCoffee(16, 3, 2);
    }
}