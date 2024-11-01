package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID

public class Adopter {

    // Class fields
    private String name;
    private String email;
    private List<String> filters;
    private List<Pet> availablePets;
    private List<AdoptionRequest> adoptionRequests;

    // Constructors
    public Adopter() {
        this( null, null)
    }
    public Adopter(String Name

    public Adopter(String name, String email, List<String> filters, List<Pet> availablePets, List<AdoptionRequest> adoptionRequests) {
        this.name = name;
        this.email = email;
        this.filters = new ArrayList<>();
        this.availablePets = new ArrayList<>();
        this.adoptionRequests = new ArrayList<>();
    }

    // Getters and Setters

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<String> getFilters() { return filters; }
    public void setFilters(List<String> filters) { this.filters = filters; }
    public List<Pet> getAvailablePets() { return availablePets; }
    public void setAvailablePets(List<Pet> availablePets) { this.availablePets = availablePets; }
    public List<AdoptionRequest> getAdoptionRequests() { return adoptionRequests; }
    public void setAdoptionRequests(List<AdoptionRequest> adoptionRequests) {
        this.adoptionRequests = adoptionRequests;
    }


    // functionalities / methods
}

    // Permet de trouver un animal avec ou sans filtres
   /* public List<Pet> findPet(List<String> filters) {
        List<Pet> filteredPets = new ArrayList<>();

        if (filters == null || filters.isEmpty()) {
            return availablePets; // Retourne tous les animaux disponibles si aucun filtre
        }

    }*/