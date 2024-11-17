package ch.unil.furrybuddy.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Adopter extends User {

    // Class fields
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
    public AdoptionRequest createAdoptionRequest(Advertisement advertisement) {
        var request = new AdoptionRequest();
        request.setAdopter(this);
        request.setAdvertisement(advertisement);
        request.setStatus(AdoptionRequest.Status.PENDING);
        adoptionRequests.add(request);

        return request;
    }

    // cancel an existing adoption request
    public void cancelAdoptionRequest(AdoptionRequest request) {
        request.setStatus(AdoptionRequest.Status.CANCELLED);
        adoptionRequests.remove(request);
    }
}

