package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Adopter extends User {

    // class fields
    private List<String> filters;
    private List<Pet> availablePets;
    private List<AdoptionRequest> adoptionRequests;

    // constructors
    public Adopter(UUID userID, String email, String password, String firstName, String lastName, Location location) {
        super(userID, email, password, firstName, lastName, location, Role.ADOPTER); // Utilisation de Role.ADOPTER au lieu de "Adopter"
        this.filters = new ArrayList<>();
        this.availablePets = new ArrayList<>();
        this.adoptionRequests = new ArrayList<>();
    }

    // getters and setters

    // functionalities (methods)
    // Méthodes pour trouver des animaux, envoyer des demandes d'adoption, annuler des demandes, etc.
    public void findPets(String filter) {
        // Implémentation pour trouver des animaux en fonction d'un filtre
        filters.add(filter);
    }

    public void viewAvailablePets() {
        // Implémentation pour afficher tous les animaux disponibles
    }

    public void requestAdoption(Pet pet) {
        // Implémentation pour demander l'adoption d'un animal
    //    adoptionRequests.add(new AdoptionRequest(this, pet));
    }

    public void cancelAdoptionRequest(AdoptionRequest request) {
        // Implémentation pour annuler une demande d'adoption
        adoptionRequests.remove(request);
    }
}