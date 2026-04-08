import java.util.Objects;

public class Pet {
    private final String id; // [cite: 14]
    private String name; // [cite: 14]
    private int age; // [cite: 14]
    private boolean isHealthy; // [cite: 15]
    private MedicalPassport medicalPassport; // Композиція

    public Pet(String id, String name, int age, boolean isHealthy) {
        this.id = id; // [cite: 15]
        this.name = name; // [cite: 16]
        this.age = age; // [cite: 16]
        this.isHealthy = isHealthy; // [cite: 16]
        this.medicalPassport = new MedicalPassport(id); // Реалізація композиції
    }

    public Pet(String id, String name) {
        this(id, name, 0, true); // [cite: 16]
    }

    public void checkHealth() {
        if (isHealthy) { // [cite: 17]
            System.out.println("Тварина " + name + " здорова."); // [cite: 17]
        } else { // [cite: 18]
            System.out.println("Тварині " + name + " потрібен огляд."); // [cite: 18]
        }
    }

    @Override
    public String toString() {
        return "Pet{id='" + id + "', name='" + name + "', age=" + age +
                ", healthy=" + isHealthy + ", " + medicalPassport + "}"; // [cite: 19]
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // [cite: 20]
        if (!(o instanceof Pet pet)) return false; // [cite: 21]
        return Objects.equals(id, pet.id); // [cite: 21]
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // [cite: 22]
    }
}