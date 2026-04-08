public class Main {
    public static void main(String[] args) {
        // Створення тварин [cite: 1, 2]
        Pet pet1 = new Pet("P-101", "Рекс", 2, true);
        Dog dog = new Dog("D-202", "Барон", 4, true, "Вівчарка");

        // Створення власника [cite: 3]
        Adopter adopter = new Adopter("A-01", "Тимур");

        // Демонстрація агрегації
        adopter.addPet(pet1);
        adopter.addPet(dog);

        // Вивід інформації [cite: 4]
        System.out.println("Власник: " + adopter.toString());
        System.out.println("Собака: " + dog.toString());

        pet1.checkHealth(); // [cite: 17]

        // Порівняння [cite: 21]
        Pet pet2 = new Pet("P-101", "Рекс");
        System.out.println("Результат equals: " + pet1.equals(pet2));
        System.out.println("HashCode #1: " + pet1.hashCode()); // [cite: 22]
    }
}