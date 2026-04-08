import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest {

    private Pet healthyPet;
    private Dog dog;
    private Adopter adopter;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    // Фікстура: виконується перед кожним методом [cite: 190, 197]
    @BeforeMethod
    public void setUp() {
        healthyPet = new Pet("P-101", "Рекс", 2, true);
        dog = new Dog("D-202", "Барон", 4, true, "Вівчарка");
        adopter = new Adopter("A-01", "Тимур");
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    // 1. Позитивний тест (Група: smoke) [cite: 286, 315]
    @Test(groups = {"smoke"})
    public void testPetCreation() {
        Assert.assertNotNull(healthyPet);
        Assert.assertEquals(healthyPet.toString().contains("Рекс"), true);
    }

    // 2. Параметризований тест через DataProvider [cite: 250, 317, 396]
    @DataProvider(name = "petNamesProvider")
    public Object[][] petNames() {
        return new Object[][] {
                {"Шарік", "P-102"},
                {"Мурка", "P-103"},
                {"Бобик", "P-104"}
        };
    }

    @Test(dataProvider = "petNamesProvider", groups = {"domain"})
    public void testMultiplePetCreation(String name, String id) {
        Pet p = new Pet(id, name);
        Assert.assertEquals(p.toString().contains(name), true);
    }

    // 3. Тест Dog (Група: domain) [cite: 430]
    @Test(groups = {"domain"})
    public void testDogBreed() {
        Assert.assertEquals(dog.getBreed(), "Вівчарка");
    }

    // 4. Тест агрегації в Adopter [cite: 394]
    @Test(groups = {"domain"})
    public void testAdopterAggregation() {
        adopter.addPet(healthyPet);
        Assert.assertTrue(adopter.toString().contains("adoptedPetsCount=1"));
    }

    // 5. Негативний сценарій: перевірка здоров'я [cite: 395, 430]
    @Test(groups = {"negative"})
    public void testSickPetHealthCheck() {
        Pet sickPet = new Pet("P-666", "Бідняга", 1, false);
        sickPet.checkHealth();
        Assert.assertTrue(outputStreamCaptor.toString().contains("потрібен огляд"));
    }

    // 6. Тест порівняння (equals) [cite: 182]
    @Test(groups = {"smoke"})
    public void testPetEquality() {
        Pet samePet = new Pet("P-101", "Рекс");
        Assert.assertEquals(healthyPet, samePet);
    }

    // 7. Тест MedicalPassport
    @Test(groups = {"domain"})
    public void testMedicalPassportId() {
        Assert.assertTrue(healthyPet.toString().contains("MED-P-101"));
    }
}