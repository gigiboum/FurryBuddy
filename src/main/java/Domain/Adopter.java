package Domain;

import java.util.ArrayList;
import java.util.List;

public class Adopter {

    private String name;
    private String email;
    private List<String> filters;
    private List<Pet> availablePets;
    private List<AdoptionRequest> adoptionRequests;

    public Adopter(String name, String email) {
        this.name = name;
        this.email = email;
        this.filters = new ArrayList<>();
        this.availablePets = new ArrayList<>();
        this.adoptionRequests = new ArrayList<>();
    }
    public void requestAdoption(Pet pet) {
        // Permet de faire une requête vers le PetOwner
    }
    public void cancelRequest(Request request) {
        // Permet d'annuler la précédente requête
    }
}

    // Permet de trouver un animal avec ou sans filtres
   /* public List<Pet> findPet(List<String> filters) {
        List<Pet> filteredPets = new ArrayList<>();

        if (filters == null || filters.isEmpty()) {
            return availablePets; // Retourne tous les animaux disponibles si aucun filtre
        }

    }*/