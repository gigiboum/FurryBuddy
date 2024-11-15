package ch.unil.furrybuddy.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class AdvertisementTest {
    private UUID requestID;
    private Advertisement advertisement;
    private Pet pet;
    private PetOwner petOwner;
    private Location location;

        @BeforeEach
        void setUp() {
            // Initialisation des objets pour le test
            requestID = UUID.randomUUID();
            pet = new Pet("Bella", "Dog", "Golden Retriever", true, Pet.Gender.FEMALE, "Friendly and playful", "Friendly", "Beige", true, true, true, true, 3, 100.0, Pet.Status.AVAILABLE, true, true, "none"); // Exemple d'initialisation
            location = new Location("Paris", "75000", "10 Rue de Rivoli"); // Exemple d'initialisation
            petOwner = new PetOwner("milaliv@example.com", "12345", "Mila", "Livron",location, User.Role.PET_OWNER); // Exemple d'initialisation
            advertisement = new Advertisement(requestID, pet, petOwner, "Friendly and playful dog", location, Advertisement.Status.AVAILABLE);
        }

        @Test
        void testAdvertisementInitialization() {
            assertEquals(requestID, advertisement.getAdvertisementID());
            assertEquals(pet, advertisement.getPet());
            assertEquals(petOwner, advertisement.getPetOwner());
            assertEquals("Friendly and playful dog", advertisement.getDescription());
            assertEquals(location, advertisement.getLocation());
        }

        @Test
        void testSettersAndGetters() {
            // Test du setter pour ID
            UUID advertisementID = UUID.randomUUID();
            advertisement.setAdvertisementID(advertisementID);
            assertEquals(advertisementID, advertisement.getAdvertisementID());

            // Création d'un nouvel objet Pet pour tester les setters
            Pet newPet = new Pet("Ivy", "Cat", "Persian", true, Pet.Gender.FEMALE, "Independant", "", "brown", true, false, false, false, 2, 150.0, Pet.Status.AVAILABLE, true, true, "none");
            advertisement.setPet(newPet);
            assertEquals(newPet, advertisement.getPet());

            // Création d'un nouvel objet PetOwner pour tester les setters
            PetOwner newPetOwner = new PetOwner("milaliv@example.com", "12345", "Mila", "Livron",location, User.Role.PET_OWNER);
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

