package Domain;
import java.util.UUID;

public class PetTest {

    public static void main(String[] args) {
        // Test default constructor
        Pet pet1 = new Pet();
        pet1.setName("Buddy");
        pet1.setSpecies("Dog");
        pet1.setNeutered(true);
        pet1.setGender(Pet.Gender.MALE);
        pet1.setDescription("A friendly golden retriever.");
        pet1.setPersonality("Playful");
        pet1.setColor("Golden");
        pet1.setAge(3);
        pet1.setPrice(500.0);
        pet1.setStatus(Pet.Status.AVAILABLE);
        pet1.setSuitableForHouse(true);
        pet1.setVaccinated(true);
        pet1.setMedicalConditions("None");

        System.out.println("Pet 1 Details:");
        System.out.println("Name: " + pet1.getName());
        System.out.println("Species: " + pet1.getSpecies());
        System.out.println("Neutered: " + pet1.isNeutered());
        System.out.println("Gender: " + pet1.getGender());
        System.out.println("Description: " + pet1.getDescription());
        System.out.println("Personality: " + pet1.getPersonality());
        System.out.println("Color: " + pet1.getColor());
        System.out.println("Age: " + pet1.getAge());
        System.out.println("Price: " + pet1.getPrice());
        System.out.println("Status: " + pet1.getStatus());
        System.out.println("Suitable for House: " + pet1.isSuitableForHouse());
        System.out.println("Vaccinated: " + pet1.isVaccinated());
        System.out.println("Medical Conditions: " + pet1.getMedicalConditions());
        System.out.println();

        // Test parameterized constructor
        Pet pet2 = new Pet("Milo", "Cat", false, Pet.Gender.FEMALE, "A calm Siamese cat.", "Calm", "Brown",
                true, true, true, false, 2, 300.0, Pet.Status.AVAILABLE, false, true, "None");

        System.out.println("Pet 2 Details:");
        System.out.println("Name: " + pet2.getName());
        System.out.println("Species: " + pet2.getSpecies());
        System.out.println("Neutered: " + pet2.isNeutered());
        System.out.println("Gender: " + pet2.getGender());
        System.out.println("Description: " + pet2.getDescription());
        System.out.println("Personality: " + pet2.getPersonality());
        System.out.println("Color: " + pet2.getColor());
        System.out.println("Age: " + pet2.getAge());
        System.out.println("Price: " + pet2.getPrice());
        System.out.println("Status: " + pet2.getStatus());
        System.out.println("Suitable for House: " + pet2.isSuitableForHouse());
        System.out.println("Vaccinated: " + pet2.isVaccinated());
        System.out.println("Medical Conditions: " + pet2.getMedicalConditions());
        System.out.println();

        // Update some fields
        pet2.setStatus(Pet.Status.ADOPTED);
        pet2.setPrice(250.0);

        System.out.println("Updated Pet 2 Details:");
        System.out.println("Name: " + pet2.getName());
        System.out.println("Status: " + pet2.getStatus());
        System.out.println("Price: " + pet2.getPrice());
    }
}

