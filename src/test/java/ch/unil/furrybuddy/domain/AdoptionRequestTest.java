package ch.unil.furrybuddy.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class AdoptionRequestTest {
    private AdoptionRequest adoptionRequest;
    private Adopter adopter;
    private PetOwner petOwner;
    private Advertisement advertisement;
    private UUID requestID;

    @BeforeEach
    void setUp() {
        Location location = new Location("Zurich", "8004", "10 Rivolistrasse");
        Pet pet = new Pet("Bella", "Dog", "Golden Retriever", true, Pet.Gender.FEMALE, "Friendly and playful", "Friendly", "Beige", true, true, true, true, 3, 100.0, Pet.Status.AVAILABLE, true, true, "none"); // Exemple d'initialisation

        adopter = new Adopter("jondoe@example.com", "12345", "Jon", "Doe", location, User.Role.ADOPTER);
        petOwner = new PetOwner("milaliv@example.com", "12345", "Mila", "Livron", location, User.Role.PET_OWNER); // Exemple d'initialisation
        advertisement = new Advertisement(UUID.randomUUID(), pet, petOwner, "Friendly and playful dog", location, Advertisement.Status.AVAILABLE);
        requestID = UUID.randomUUID();
        adoptionRequest = new AdoptionRequest(requestID, adopter, advertisement, AdoptionRequest.Status.PENDING);
    }

    @Test
    void testGetRequestID() {
        assertEquals(requestID, adoptionRequest.getRequestID(), "Getter for requestID should return the correct UUID");
    }

    @Test
    void testSetRequestID() {
        UUID newRequestID = UUID.randomUUID();
        adoptionRequest.setRequestID(newRequestID);
        assertEquals(newRequestID, adoptionRequest.getRequestID(), "Setter for requestID should update the UUID");
    }

    @Test
    void testGetAdopter() {
        assertEquals(adopter, adoptionRequest.getAdopter(), "Getter for adopter should return the correct adopter");
    }

    @Test
    void testSetAdopter() {
        Adopter newAdopter = new Adopter(UUID.randomUUID(), "newadopter@example.com", "password", "NewFirstName", "NewLastName", new Location("NewTown", "1000", "NewStreet"), User.Role.ADOPTER);
        adoptionRequest.setAdopter(newAdopter);
        assertEquals(newAdopter, adoptionRequest.getAdopter(), "Setter for adopter should update the adopter");
    }

    @Test
    void testGetAdvertisement() {
        assertEquals(advertisement, adoptionRequest.getAdvertisement(), "Getter for advertisement should return the correct advertisement");
    }

    @Test
    void testSetAdvertisement() {
        Location newLocation = new Location("NewTown", "1000", "NewStreet");
        PetOwner newPetOwner = new PetOwner(UUID.randomUUID(), "newowner@example.com", "password", "NewName", "NewLastName", newLocation, User.Role.PET_OWNER);
        Pet newPet = new Pet("Milo", "Cat", "Siamese", true, Pet.Gender.FEMALE, "A cute cat", "Fun", "Brown", true, true, false, false, 2, 200.0, Pet.Status.AVAILABLE, true, true, "none");
        Advertisement newAdvertisement = new Advertisement(newPet, newPetOwner, "A cute cat", newLocation, Advertisement.Status.AVAILABLE);

        adoptionRequest.setAdvertisement(newAdvertisement);
        assertEquals(newAdvertisement, adoptionRequest.getAdvertisement(), "Setter for advertisement should update the advertisement");
    }

    @Test
    void testGetStatus() {
        assertEquals(AdoptionRequest.Status.PENDING, adoptionRequest.getStatus(), "Getter for status should return the correct status");
    }

    @Test
    void testSetStatus() {
        adoptionRequest.setStatus(AdoptionRequest.Status.APPROVED);
        assertEquals(AdoptionRequest.Status.APPROVED, adoptionRequest.getStatus(), "Setter for status should update the status");
    }

    @Test
    void testIsPendingTrue() {
        assertTrue(adoptionRequest.isPending(), "Adoption request should be pending initially");
    }

    @Test
    void testIsPendingFalseAfterApproval() {
        petOwner.acceptRequest(adoptionRequest);
        assertFalse(adoptionRequest.isPending(), "Adoption request should not be pending after approval");
        assertEquals(AdoptionRequest.Status.APPROVED, adoptionRequest.getStatus(), "Adoption request should be approved");
    }

    @Test
    void testReplaceWith() {
        Adopter newAdopter = new Adopter(UUID.randomUUID(), "newadopter@example.com", "password", "NewFirstName", "NewLastName", new Location("NewTown", "1000", "NewStreet"), User.Role.ADOPTER);
        Pet pet = new Pet("Luna", "Cat", "Persian Cat", false, Pet.Gender.FEMALE, "Independant Luna who needs a new home", "Calm", "Grey", false, true, true, false, 6, 200.0, Pet.Status.AVAILABLE, true, true, "none"); // Exemple d'initialisation
        Advertisement newAd = new Advertisement(UUID.randomUUID(), pet, petOwner, "Friendly and playful dog", newAdopter.getLocation(), Advertisement.Status.AVAILABLE);
        AdoptionRequest newRequest = new AdoptionRequest(UUID.randomUUID(), newAdopter, newAd, AdoptionRequest.Status.APPROVED);

        adoptionRequest.replaceWith(newRequest);

        assertEquals(newRequest.getRequestID(), adoptionRequest.getRequestID(), "Request ID should be replaced");
        assertEquals(newRequest.getAdopter(), adoptionRequest.getAdopter(), "Adopter should be replaced");
        assertEquals(newRequest.getAdvertisement(), adoptionRequest.getAdvertisement(), "Advertisement should be replaced");
        assertEquals(newRequest.getStatus(), adoptionRequest.getStatus(), "Status should be replaced");
    }

    @Test
    void testReplaceWithThrowsExceptionIfNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> adoptionRequest.replaceWith(null));
        assertEquals("Adoption Request cannot be null", exception.getMessage(), "Exception message should match");
    }
}

