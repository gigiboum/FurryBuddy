package Domain;

public class Advertisement {
    private String petID;
    private String description;
    private String pet_characteristics;

    public Advertisement(Pet pet, String description) {
        this.petID = pet.getPetID();
        this.description = description;
        this.pet_characteristics = pet.toString(); // résume les characteristiques du pet
    }
    public void cancelAdvertisement() {
        // annule l'annonce
    }
}
