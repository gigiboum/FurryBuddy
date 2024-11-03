package Domain;

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

    // functionalities / methods

    // Permet de trouver un animal avec ou sans filtres
    public List<Pet> findPet(List<String> filters) {
        List<Pet> allPets = new ArrayList<>();
        List<Pet> filteredPets = new ArrayList<>();

        if (filters == null || filters.isEmpty()) {
            return allPets; // Retourne tous les animaux disponibles si aucun filtre
        }
        return filteredPets;
    }

    public AdoptionRequest createAdoptionRequest(Advertisement advertisement) {
        AdoptionRequest request = new AdoptionRequest(this, advertisement, AdoptionRequest.Status.PENDING);
        adoptionRequests.add(request);

        return request;
    }

    public void cancelAdoptionRequest(AdoptionRequest request) {
        request.setStatus(AdoptionRequest.Status.CANCELLED);
        adoptionRequests.remove(request);
    }
}

