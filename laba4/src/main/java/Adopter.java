import java.util.ArrayList;
import java.util.List;

public class Adopter {
    private String adopterId; // [cite: 10]
    private String fullName; // [cite: 10]
    private List<Pet> pets; // Реалізація агрегації

    public Adopter(String adopterId, String fullName) {
        this.adopterId = adopterId; // [cite: 11]
        this.fullName = fullName; // [cite: 11]
        this.pets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    @Override
    public String toString() {
        return "Adopter{id='" + adopterId + "', name='" + fullName + "', adoptedPetsCount=" + pets.size() + "}"; // [cite: 12]
    }
}