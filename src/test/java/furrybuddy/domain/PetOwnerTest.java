package furrybuddy.domain;

import Domain.Location;
import Domain.Pet;
import Domain.PetOwner;
import Domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PetOwnerTest {

    private PetOwner petOwner;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    void setUp() {
        petOwner = new PetOwner(UUID.randomUUID(),
                "jean@dupont.com",
                "password123",
                "Jean",
                "Dupont",
                new Location("Geneva","1203","Rue voltaire"),
                User.Role.PET_OWNER);

        pet1 = new Pet("Buddy", "Dog", "German Shepard", true, Pet.Gender.MALE, "Friendly", "Loyal", "Brown", true, true, true, false, 3, 150.0, Pet.Status.AVAILABLE, true, true, null);
        pet2 = new Pet("Kiti", "Cat","Siamese",false, Pet.Gender.FEMALE, "Playful", "Curious", "White", true, true, false, true, 2, 100.0, Pet.Status.AVAILABLE, false, true, null);


    }

    @Test
    public void testAddPet(){
        assertTrue(petOwner.getPets().isEmpty(), "Pets should be empty initially"); // Vérifie que la liste d'animaux est vide au début

        //Ajouter 1 animal et vérifier sa présence
        petOwner.addPet(pet1);
        assertEquals(1, petOwner.getPets().size(), "Pets should contain 1 pet");
        assertTrue(petOwner.getPets().contains(pet1), "Pet1 should be added");
    }

    @Test
    public void testRemovePet(){
        petOwner.addPet(pet1);
        petOwner.addPet(pet2);
        assertEquals(2, petOwner.getPets().size(), "Pets should contain 2 pets");

        //Retirer 1 animal et vérifier
        petOwner.removePet(pet1);
        assertEquals(1, petOwner.getPets().size(), "Pets should contain 1 pet after removal");
        assertFalse(petOwner.getPets().contains(pet1), "Pet1 should be removed from the list");
        assertTrue(petOwner.getPets().contains(pet2), "The list should still contain pet 2");


    }

    @Test
    public void testSetAndGetPet(){
        //Crée un nouvel ensemble d'animaux
        Set<Pet> pets = new HashSet<>();
        pets.add(pet1);
        pets.add(pet2);

        //Utilise le setter pour définir l'ensemble d'animaux
        petOwner.setPets(pets);

        //Vérifier que getter renvoie le bon ensemble
        assertEquals(pets, petOwner.getPets());
        assertTrue(petOwner.getPets().contains(pet1), "Pet1 should be added to the list");
        assertTrue(petOwner.getPets().contains(pet2), "Pet2 should be added to the list");
    }

}