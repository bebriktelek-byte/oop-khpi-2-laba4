public class MedicalPassport {
    private final String passportId; //

    public MedicalPassport(String petId) { // [cite: 39]
        this.passportId = "MED-" + petId; // [cite: 39]
    } // [cite: 40]

    @Override
    public String toString() { // [cite: 40]
        return "MedPassport[" + passportId + "]"; // [cite: 40]
    } // [cite: 41]
}