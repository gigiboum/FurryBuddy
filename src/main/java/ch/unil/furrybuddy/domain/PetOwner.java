package ch.unil.furrybuddy.domain;

import java.util.*;

public class PetOwner extends User {

    private List<Advertisement> advertisements;

    // Constructors

    public PetOwner() {
        super();
        advertisements = new ArrayList<>();
    }

    public PetOwner(String email, String password, String firstname, String lastname, Location location, Role role) {
        this(null, email, password, firstname, lastname, location, role);
    }

    public PetOwner(UUID id, String email, String password, String firstname, String lastname, Location location, Role role) {
        super(id, email, password, firstname, lastname, location, role);
        advertisements = new ArrayList<>();
    }

    //Getters and setters
    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
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

        Advertisement ad = new Advertisement(UUID.randomUUID(), pet, this.getUserID(), pet.getDescription(),getLocation(), Advertisement.Status.AVAILABLE);
        advertisements.add(ad);
        return ad;
    }

    public void deleteAdvertisement(Advertisement advertisement) {
        this.advertisements.remove(advertisement);
    }

    public void acceptRequest(AdoptionRequest adoptionRequest) {
        if (adoptionRequest.getStatus() != AdoptionRequest.Status.PENDING) {
            throw new IllegalArgumentException("Adoption request is not waiting for decision");
        }
        adoptionRequest.setStatus(AdoptionRequest.Status.APPROVED);
        adoptionRequest.getAdvertisement().setStatus(Advertisement.Status.UNAVAILABLE);

    }

    public void rejectRequest(AdoptionRequest adoptionRequest) {
        if (adoptionRequest.getStatus() == AdoptionRequest.Status.PENDING) {
            adoptionRequest.setStatus(AdoptionRequest.Status.REJECTED);
        }
    }
}
