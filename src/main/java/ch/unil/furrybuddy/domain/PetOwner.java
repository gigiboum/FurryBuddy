package ch.unil.furrybuddy.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PetOwner extends User{

    public Set<Pet> pets; // (redondant)
    public Set<Advertisement> advertisements;

    // Constructors

    public PetOwner() {
        super();
        pets = new HashSet<>();
        advertisements = new HashSet<>();
    }

    public PetOwner(String email,String password, String firstname, String lastname, Location location, Role role) {
        this(null, email, password, firstname, lastname, location, role);
    }

    public PetOwner(UUID id, String email, String password, String firstname, String lastname, Location location, Role role) {
        super(id, email, password, firstname, lastname, location, role);
        pets = new HashSet<>();
        advertisements = new HashSet<>();
    }

    //Getters and setter

    public Set<Pet> getPets() {return pets;
    }
    public void setPets(Set<Pet> pets) {this.pets = pets;
    }
    public void addPet(Pet pet) {pets.add(pet);
    }
    public void removePet(Pet pet) {pets.remove(pet);
    }

    public Set<Advertisement> getAdvertisements() {return advertisements;}
    public void setAdvertisements(Set<Advertisement> advertisements) {}
    public void addAdvertisement(Advertisement advertisement) {
        advertisements.add(advertisement);
    }
    public void removeAdvertisement(Advertisement advertisement) {
        advertisements.remove(advertisement);
    }

    // methods
    public void replacewith(PetOwner petOwner){
        super.replaceWith(petOwner);
//        this.pets = petOwner.pets;
        this.advertisements = petOwner.advertisements;
    }

    // actions
    public Advertisement createAdvertisement(Pet pet) {
        Advertisement ad = new Advertisement(pet, this, pet.getDescription(), this.getLocation(), Advertisement.Status.AVAILABLE);

        advertisements.add(ad);
//        pets.add(pet);
        return ad;
    }

    public void deleteAdvertisement(Advertisement advertisement){
        advertisements.remove(advertisement);
//        pets.remove(advertisement.getPet());
    }

    public void acceptRequest(AdoptionRequest adoptionRequest){
        if (adoptionRequest.getStatus() == AdoptionRequest.Status.PENDING){
            adoptionRequest.setStatus(AdoptionRequest.Status.APPROVED);
            adoptionRequest.getAdvertisement().setStatus(Advertisement.Status.UNAVAILABLE);
        }
    }

    public void rejectRequest(AdoptionRequest adoptionRequest){
        if (adoptionRequest.getStatus() == AdoptionRequest.Status.PENDING) {
            adoptionRequest.setStatus(AdoptionRequest.Status.REJECTED);
        }
    }
}
