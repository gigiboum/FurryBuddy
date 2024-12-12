package ch.unil.furrybuddy.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Adopter extends User {

    // Class fields
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ADOPTER")
    private List<AdoptionRequest> adoptionRequests;

    // Constructors

    public Adopter(){
        super();
        adoptionRequests = new ArrayList<>();
    }

    public Adopter(String email, String password, String firstname, String lastname, Location location, Role role) {
        this(null, email, password, firstname, lastname, location, role);
    }

    public Adopter(UUID adopterID, String email, String password, String firstname, String lastname, Location location, Role role) {
        super(adopterID, email, password, firstname, lastname, location, role);
        adoptionRequests = new ArrayList<>();
    }

    // Getters and Setters
    public List<AdoptionRequest> getAdoptionRequests() { return adoptionRequests; }
    public void setAdoptionRequests(List<AdoptionRequest> adoptionRequests) {
        this.adoptionRequests = adoptionRequests;
    }

    // actions

    // create a new adoption request
    public AdoptionRequest createAdoptionRequest(Advertisement advertisement, String message) {
        if (advertisement == null) {
            throw new IllegalArgumentException("Advertisement cannot be null");
        }
        for (AdoptionRequest ar : adoptionRequests) {
            if (ar.getAdvertisement().equals(advertisement)) {
                throw new IllegalStateException("A request for this advertisement has already been made.");
            }
        }
        AdoptionRequest request = new AdoptionRequest(UUID.randomUUID(), this.getUserID(),advertisement, AdoptionRequest.Status.PENDING, message);
        adoptionRequests.add(request);
        return request;
    }

    // cancel an existing adoption request
    public void cancelAdoptionRequest(AdoptionRequest adoptionRequest) {
        if (adoptionRequest.getStatus() == AdoptionRequest.Status.PENDING) {
            adoptionRequest.setStatus(AdoptionRequest.Status.CANCELLED);
        }
    }
}

