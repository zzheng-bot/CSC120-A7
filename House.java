import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;

  // Constructor
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;

    System.out.println("You have built a house: 🏠");
  }

  // Returns whether the house has a dining room
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  // Returns number of residents
  public int nResidents() {
    return residents.size();
  }

  // Adds a student to the house
  public void moveIn(Student s) {
    residents.add(s);
  }

  // Removes a student from the house
  public Student moveOut(Student s) {
    residents.remove(s);
    return s;
  }

  // Checks if student is a resident
  public boolean isResident(Student s) {
    return residents.contains(s);
  }

  public static void main(String[] args) {
    House h = new House("My House", "123 Main St", 2, true);
  }
}