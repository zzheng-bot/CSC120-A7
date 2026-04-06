import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {
    private Hashtable<String, Boolean> collection;

    // Constructor
    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        collection = new Hashtable<String, Boolean>();
        System.out.println("You have built a library: 📖");
    }

    // Adds a title to the collection
    public void addTitle(String title) {
        collection.put(title, true);
    }

    // Removes a title
    public String removeTitle(String title) {
        if (collection.containsKey(title)) {
            collection.remove(title);
            return title;
        }
        return null;
    }

    public void checkOut(String title) {
        if (collection.containsKey(title)) {
            collection.replace(title, false);
        }
    }

    public void returnBook(String title) {
        if (collection.containsKey(title)) {
            collection.replace(title, true);
        }
    }

    public boolean containsTitle(String title) {
        return collection.containsKey(title);
    }

    public boolean isAvailable(String title) {
        if (collection.containsKey(title)) {
            return collection.get(title);
        }
        return false;
    }

    public void printCollection() {
        for (String title : collection.keySet()) {
            String status = collection.get(title) ? "Available" : "Checked out";
            System.out.println(title + " - " + status);
        }
    }

    public static void main(String[] args) {
        Library lib = new Library("Neilson Library", "7 Neilson Dr", 3);

        lib.addTitle("The Hobbit by Tolkien");
        lib.addTitle("The Lorax by Dr. Seuss");

        lib.printCollection();

        lib.checkOut("The Hobbit by Tolkien");
        lib.printCollection();

        lib.returnBook("The Hobbit by Tolkien");
        lib.printCollection();
    }
  }