package Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdvertisementTest {
    private Advertisement advertisement;
    private Pet pet;
    private PetOwner petOwner;
    private Location location;

        @BeforeEach
        void setUp() {
            // Initialisation des objets pour le test
            pet = new Pet("Dog", "Golden Retriever", 3); // Exemple d'initialisation
            petOwner = new PetOwner("Mila", "milaliv@example.com"); // Exemple d'initialisation
            location = new Location("Paris", "75000", "10 Rue de Rivoli"); // Exemple d'initialisation
            advertisement = new Advertisement(pet, petOwner, "Friendly and playful dog", location);
        }

        @Test
        void testAdvertisementInitialization() {
            assertEquals(pet, advertisement.getPet());
            assertEquals(petOwner, advertisement.getPetOwner());
            assertEquals("Friendly and playful dog", advertisement.getDescription());
            assertEquals(location, advertisement.getLocation());
        }

        @Test
        void testSettersAndGetters() {
            // Création d'un nouvel objet Pet pour tester les setters
            Pet newPet = new Pet("Cat", "Persian", 2);
            advertisement.setPet(newPet);
            assertEquals(newPet, advertisement.getPet());

            // Création d'un nouvel objet PetOwner pour tester les setters
            PetOwner newPetOwner = new PetOwner("Mila", "milaliv@example.com");
            advertisement.setPetOwner(newPetOwner);
            assertEquals(newPetOwner, advertisement.getPetOwner());

            // Test du setter pour description
            advertisement.setDescription("Calm and affectionate cat");
            assertEquals("Calm and affectionate cat", advertisement.getDescription());

            // Création d'un nouvel objet Location pour tester les setters
            Location newLocation = new Location("Lyon", "69000", "5 Rue de la République");
            advertisement.setLocation(newLocation);
            assertEquals(newLocation, advertisement.getLocation());
        }
    }

