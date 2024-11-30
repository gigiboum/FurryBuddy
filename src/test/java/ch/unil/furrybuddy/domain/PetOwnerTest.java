package ch.unil.furrybuddy.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PetOwnerTest {

    private PetOwner petOwner;
    private Pet pet1;
    private Pet pet2;
    private Advertisement advertisement1;
    private Advertisement advertisement2;
    private Adopter adopter;
    private AdoptionRequest request;

    @BeforeEach
    void setUp() {
        petOwner = new PetOwner(UUID.randomUUID(),
                "jean@dupont.com",
                "password123",
                "Jean",
                "Dupont",
                new Location("Geneva","1203","Rue voltaire"),
                User.Role.PET_OWNER);

        pet1 = new Pet("Buddy", "Dog", "German Shepard", true, Pet.Gender.MALE, "Friendly", true, true, true, false, 3, 150.0, true, true, null);
        pet2 = new Pet("Kiti", "Cat","Siamese",false, Pet.Gender.FEMALE, "Playful", true, true, false, true, 2, 100.0, false, true, null);

        advertisement1 = new Advertisement(UUID.randomUUID(), pet1, petOwner.getUserID(), "Friendly and playful dog", petOwner.getLocation(), Advertisement.Status.AVAILABLE);
        advertisement2 = new Advertisement(UUID.randomUUID(), pet2, petOwner.getUserID(), "Friendly and playful dog", petOwner.getLocation(), Advertisement.Status.AVAILABLE);

        adopter = new Adopter("milaliv@example.com", "12345", "Mila", "Livron", new Location("Paris", "75000", "10 Rue de Rivoli"), User.Role.PET_OWNER);
        request = new AdoptionRequest(UUID.randomUUID(), adopter.getUserID(), advertisement1, AdoptionRequest.Status.PENDING, "message from adopter");

    }

    @Test
    public void testSetAndGetAd(){
        //Creates a new set of ads
        List<Advertisement> ads = new ArrayList<>();
        ads.add(advertisement1);
        ads.add(advertisement2);

        //Uses the setter to define the set of ads
        petOwner.setAdvertisements(ads);

        //Check that getter returns the correct set
        assertEquals(ads, petOwner.getAdvertisements());
        assertTrue(petOwner.getAdvertisements().contains(advertisement1), "Pet1 should be added to the list");
        assertTrue(petOwner.getAdvertisements().contains(advertisement2), "Pet2 should be added to the list");
    }

    @Test
    void testReplaceWith() {
        PetOwner newPetOwner = new PetOwner(UUID.randomUUID(), "newtest@example.com", "newpassword", "NewFirst", "NewLast", petOwner.getLocation(), User.Role.PET_OWNER);
        petOwner.replaceWith(newPetOwner);

        assertEquals(newPetOwner.getAdvertisements(), petOwner.getAdvertisements(), "Advertisements should be replaced");
        assertEquals(newPetOwner.getEmail(), petOwner.getEmail(), "Email should be replaced");
        assertEquals(newPetOwner.getPassword(), petOwner.getPassword(), "Password should be replaced");
    }

    @Test
    void testCreateAdvertisement() {
        Advertisement createdAd = petOwner.createAdvertisement(pet1);

        assertTrue(petOwner.getAdvertisements().contains(createdAd), "Created advertisement should be added to the set");
//        assertEquals(petOwner, createdAd.getPetOwner(), "Owner of advertisement should be pet owner");

        assertEquals(pet1.getDescription(), createdAd.getDescription(), "Description of advertisement should match pet description");
        assertEquals(Advertisement.Status.AVAILABLE, createdAd.getStatus(), "Advertisement should have AVAILABLE status");

        //attempt to create a second ad for the same pet, should throw an exception
        Exception exception = assertThrows(IllegalStateException.class, () -> petOwner.createAdvertisement(pet1));

        assertEquals("An advertisement for this pet already exists.", exception.getMessage(),
                "Exception message should indicate duplicate advertisement creation is not allowed");

    }

    @Test
    void testDeleteAdvertisement() {
        var createdAd = petOwner.createAdvertisement(pet1);
        petOwner.deleteAdvertisement(createdAd);

        assertFalse(petOwner.getAdvertisements().contains(createdAd), "Advertisement should be removed from the set");
    }

    @Test
    void testAcceptRequest() {
        petOwner.acceptRequest(request);

        assertEquals(AdoptionRequest.Status.APPROVED, request.getStatus(), "Adoption request status should be APPROVED");
        assertEquals(Advertisement.Status.UNAVAILABLE, request.getAdvertisement().getStatus(), "Advertisement status should be UNAVAILABLE");
    }

    @Test
    void testRejectRequest() {
        petOwner.rejectRequest(request);

        assertEquals(AdoptionRequest.Status.REJECTED, request.getStatus(), "Adoption request status should be REJECTED");
        assertEquals(Advertisement.Status.AVAILABLE, request.getAdvertisement().getStatus(), "Advertisement status should be UNAVAILABLE");

    }

}