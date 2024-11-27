package ch.unil.furrybuddy.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AdopterTest {
    private Adopter adopter;
    private Pet pet1;
    private AdoptionRequest request1;
    private Advertisement advertisement1;

    @BeforeEach
    void setUp() {

        // Exemple d'initialisation
        adopter = new Adopter("milaliv@example.com", "12345", "Mila", "Livron", new Location("Paris", "75000", "10 Rue de Rivoli"), User.Role.PET_OWNER);

        // Initialisation des animaux de compagnie et des demandes d'adoption
        pet1 = new Pet("Ivy", "Cat", "Persian", true, Pet.Gender.FEMALE, "Independant", "", "brown", true, false, false, false, 2, 150.0, true, true, "none");
        var petOwnerID = UUID.randomUUID();
        advertisement1 = new Advertisement(pet1, petOwnerID,
                "description",
                new Location(
                        "Paris",
                        "75000",
                        "Tour eiffel"),
                Advertisement.Status.AVAILABLE
                );

        request1 = new AdoptionRequest(UUID.randomUUID(), adopter.getUserID(), advertisement1, AdoptionRequest.Status.PENDING);

    }

    @Test
    void testAdopterInitialization() {
        assertEquals("Mila", adopter.getFirstName());
        assertEquals("milaliv@example.com", adopter.getEmail());
        assertTrue(adopter.getAdoptionRequests().isEmpty());
    }

    @Test
    void testSettersAndGetters() {
        adopter.setFirstName("Mila");
        adopter.setEmail("milaliv@example.com");

        assertEquals("Mila", adopter.getFirstName());
        assertEquals("milaliv@example.com", adopter.getEmail());
    }

    @Test
    void testAddAdoptionRequest() {
        List<AdoptionRequest> requests = new ArrayList<>();
        requests.add(request1);

        adopter.setAdoptionRequests(requests);
        assertEquals(1, adopter.getAdoptionRequests().size());
        assertTrue(adopter.getAdoptionRequests().contains(request1));
    }

    @Test
    void testCreateAdoptionRequest() {
        var newRequest = adopter.createAdoptionRequest(advertisement1);

        assertEquals(1, adopter.getAdoptionRequests().size());
        assertTrue(adopter.getAdoptionRequests().contains(newRequest));
        assertEquals(AdoptionRequest.Status.PENDING, newRequest.getStatus());
    }

    @Test
    void testCancelAdoptionRequest() {
        var req = adopter.createAdoptionRequest(advertisement1);
        assertEquals(1, adopter.getAdoptionRequests().size());

        adopter.cancelAdoptionRequest(req);
        assertEquals(0, adopter.getAdoptionRequests().size());
    }
}