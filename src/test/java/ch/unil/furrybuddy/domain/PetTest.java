package ch.unil.furrybuddy.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PetTest {

    private Pet dummyPet;

    @BeforeEach
    void setUp() {
        dummyPet = new Pet("Buddy", "Dog", "Golden Retriever", true, Pet.Gender.MALE, "Friendly", true, true, true, true, 3, 300.0, true, true, "None");
    }

    // Test that the parameterized constructor initializes the fields correctly
    @Test
    void testParameterizedConstructor() {
        assertEquals("Buddy", dummyPet.getName());
        assertEquals("Dog", dummyPet.getSpecies());
        assertEquals("Golden Retriever", dummyPet.getBreed());
        assertTrue(dummyPet.isNeutered());
        assertEquals(Pet.Gender.MALE, dummyPet.getGender());
        assertEquals("Friendly", dummyPet.getDescription());
        assertTrue(dummyPet.isCompatibleWithInexperiencedOwners());
        assertTrue(dummyPet.isCompatibleWithKids());
        assertTrue(dummyPet.isCompatibleWithFamilies());
        assertTrue(dummyPet.isCompatibleWithOtherAnimals());
        assertEquals(3, dummyPet.getAge());
        assertEquals(300.0, dummyPet.getPrice());
        assertTrue(dummyPet.isSuitableForHouse());
        assertTrue(dummyPet.isVaccinated());
        assertEquals("None", dummyPet.getMedicalConditions());
    }

    // Test setters and getters
    @Test
    void testSetPetID(){
        var petID = UUID.randomUUID();
        dummyPet.setPetID(petID);
        assertEquals(petID, dummyPet.getPetID());
    }
    @Test
    void testSetName() {
        dummyPet.setName("Max");
        assertEquals("Max", dummyPet.getName());
    }

    @Test
    void testSetSpecies() {
        dummyPet.setSpecies("Cat");
        assertEquals("Cat", dummyPet.getSpecies());
    }

    @Test
    void testSetBreed() {
        dummyPet.setBreed("Siamese");
        assertEquals("Siamese", dummyPet.getBreed());
    }

    @Test
    void testSetNeutered() {
        dummyPet.setNeutered(false);
        assertFalse(dummyPet.isNeutered());
    }

    @Test
    void testSetGender() {
        dummyPet.setGender(Pet.Gender.FEMALE);
        assertEquals(Pet.Gender.FEMALE, dummyPet.getGender());
    }

    @Test
    void testSetDescription() {
        dummyPet.setDescription("Loyal");
        assertEquals("Loyal", dummyPet.getDescription());
    }

    @Test
    void testSetCompatibilityWithInexperiencedOwners() {
        dummyPet.setCompatibleWithInexperiencedOwners(false);
        assertFalse(dummyPet.isCompatibleWithInexperiencedOwners());
    }

    @Test
    void testSetCompatibilityWithKids() {
        dummyPet.setCompatibleWithKids(false);
        assertFalse(dummyPet.isCompatibleWithKids());
    }

    @Test
    void testSetCompatibilityWithFamilies() {
        dummyPet.setCompatibleWithFamilies(false);
        assertFalse(dummyPet.isCompatibleWithFamilies());
    }

    @Test
    void testSetCompatibilityWithOtherAnimals() {
        dummyPet.setCompatibleWithOtherAnimals(false);
        assertFalse(dummyPet.isCompatibleWithOtherAnimals());
    }

    @Test
    void testSetAge() {
        dummyPet.setAge(4);
        assertEquals(4, dummyPet.getAge());
    }

    @Test
    void testSetPrice() {
        dummyPet.setPrice(350.0);
        assertEquals(350.0, dummyPet.getPrice());
    }

    @Test
    void testSetSuitableForHouse() {
        dummyPet.setSuitableForHouse(false);
        assertFalse(dummyPet.isSuitableForHouse());
    }

    @Test
    void testSetVaccinated() {
        dummyPet.setVaccinated(false);
        assertFalse(dummyPet.isVaccinated());
    }

    @Test
    void testSetMedicalConditions() {
        dummyPet.setMedicalConditions("None");
        assertEquals("None", dummyPet.getMedicalConditions());
    }

    // Test replaceWith method
    @Test
    void testReplaceWith_UpdatesPetFields() {
        Pet newPet = new Pet("Charlie", "Dog", "Labrador", true, Pet.Gender.MALE, "Loyal", true, true, false, true, 5, 400.0, true, true, "None");
        dummyPet.replaceWith(newPet);

        assertEquals("Charlie", dummyPet.getName());
        assertEquals("Dog", dummyPet.getSpecies());
        assertEquals("Labrador", dummyPet.getBreed());
        assertTrue(dummyPet.isNeutered());
        assertEquals(Pet.Gender.MALE, dummyPet.getGender());
        assertEquals("Loyal", dummyPet.getDescription());
        assertTrue(dummyPet.isCompatibleWithInexperiencedOwners());
        assertTrue(dummyPet.isCompatibleWithKids());
        assertFalse(dummyPet.isCompatibleWithFamilies());
        assertTrue(dummyPet.isCompatibleWithOtherAnimals());
        assertEquals(5, dummyPet.getAge());
        assertEquals(400.0, dummyPet.getPrice());
        assertTrue(dummyPet.isSuitableForHouse());
        assertTrue(dummyPet.isVaccinated());
        assertEquals("None", dummyPet.getMedicalConditions());
    }

}

