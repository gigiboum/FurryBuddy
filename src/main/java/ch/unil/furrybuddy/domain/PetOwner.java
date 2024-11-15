package ch.unil.furrybuddy.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PetOwner extends User {

    private Set<Advertisement> advertisements;

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
    public void replaceWith(PetOwner petOwner) {
        if (petOwner == null) {
            throw new IllegalArgumentException("Pet owner cannot be null");
        }
        super.replaceWith(petOwner);
        this.advertisements = petOwner.advertisements;
    }

    //actions
    public Advertisement createAdvertisement(Pet pet) {
        if (pet == null) {
            throw new IllegalArgumentException("Pet cannot be null");
        }
        // Check if an advertisement for this pet already exists
        for (Advertisement ad : advertisements) {
            if (ad.getPet().equals(pet)) {
                throw new IllegalStateException("An advertisement for this pet already exists.");
            }
        }

        Advertisement ad = new Advertisement(pet,this,pet.getDescription(),getLocation(), Advertisement.Status.AVAILABLE);
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
