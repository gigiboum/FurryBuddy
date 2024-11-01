package Domain;

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

    @BeforeEach
    void setUp() {
        adopter = new Adopter("Mila", "milaliv@example.com", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // Initialisation des animaux de compagnie et des demandes d'adoption
        pet1 = new Pet("Cat", "Persian", 2);
        request1 = new AdoptionRequest(adopter, pet1);
    }

    @Test
    void testAdopterInitialization() {
        assertEquals("Chiara", adopter.getName());
        assertEquals("chiaraa@example.com", adopter.getEmail());
        assertTrue(adopter.getFilters().isEmpty());
        assertTrue(adopter.getAvailablePets().isEmpty());
        assertTrue(adopter.getAdoptionRequests().isEmpty());
    }

    @Test
    void testSettersAndGetters() {
        adopter.setName("Mila");
        adopter.setEmail("milaliv@example.com");

        assertEquals("Mila", adopter.getName());
        assertEquals("milaliv@example.com", adopter.getEmail());
    }

    @Test
    void testAddFilter() {
        List<String> filters = new ArrayList<>();
        filters.add("Young");
        filters.add("Small");

        adopter.setFilters(filters);
        assertEquals(2, adopter.getFilters().size());
        assertTrue(adopter.getFilters().contains("Young"));
        assertTrue(adopter.getFilters().contains("Small"));
    }

    @Test
    void testAvailablePets() {
        List<Pet> pets = new ArrayList<>();
        pets.add(pet1);

        adopter.setAvailablePets(pets);
        assertEquals(2, adopter.getAvailablePets().size());
        assertTrue(adopter.getAvailablePets().contains(pet1));
    }

    @Test
    void testAddAdoptionRequest() {
        List<AdoptionRequest> requests = new ArrayList<>();
        requests.add(request1);

        adopter.setAdoptionRequests(requests);
        assertEquals(1, adopter.getAdoptionRequests().size());
        assertTrue(adopter.getAdoptionRequests().contains(request1));
    }
}
