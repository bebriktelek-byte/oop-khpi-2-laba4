public class Dog extends Pet { // [cite: 6]
    private String breed; // [cite: 6]

    public Dog(String id, String name, int age, boolean isHealthy, String breed) {
        super(id, name, age, isHealthy); // [cite: 7]
        this.breed = breed; // [cite: 8]
    }

    public String getBreed() {
        return breed; // [cite: 8]
    }

    @Override
    public String toString() {
        return super.toString() + " [Breed: " + breed + "]";
    }
}