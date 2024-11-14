package ch.unil.furrybuddy.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PetOwner extends User {

    public Set<Advertisement> advertisements;

    // Constructors

    public PetOwner() {
        super();
        advertisements = new HashSet<>();
    }

    public PetOwner(String email, String password, String firstname, String lastname, Location location, Role role) {
        this(null, email, password, firstname, lastname, location, role);
    }

    public PetOwner(UUID id, String email, String password, String firstname, String lastname, Location location, Role role) {
        super(id, email, password, firstname, lastname, location, role);
        advertisements = new HashSet<>();
    }

    //Getters and setters
    public Set<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(Set<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    // methods
    public void replacewith(PetOwner petOwner) {
        super.replaceWith(petOwner);
        this.advertisements = petOwner.advertisements;
    }

    //actions
    public Advertisement createAdvertisement(Pet pet) {
        Advertisement ad = new Advertisement();
        ad.setPet(pet);
        ad.setPetOwner(this);
        ad.setDescription(pet.getDescription());
        ad.setLocation(this.getLocation());
        ad.setStatus(Advertisement.Status.AVAILABLE);

        advertisements.add(ad);
        return ad;
    }

    public void deleteAdvertisement(Advertisement advertisement) {
        advertisements.remove(advertisement);
    }

    public void acceptRequest(AdoptionRequest adoptionRequest) {
        if (adoptionRequest.getStatus() == AdoptionRequest.Status.PENDING) {
            adoptionRequest.setStatus(AdoptionRequest.Status.APPROVED);
            adoptionRequest.getAdvertisement().setStatus(Advertisement.Status.UNAVAILABLE);
        }
    }

    public void rejectRequest(AdoptionRequest adoptionRequest) {
        if (adoptionRequest.getStatus() == AdoptionRequest.Status.PENDING) {
            adoptionRequest.setStatus(AdoptionRequest.Status.REJECTED);
        }
    }
}
