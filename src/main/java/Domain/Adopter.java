package Domain;

import java.util.ArrayList;
import java.util.List;

public class Adopter extends User {

    private List<String> filters;
    private List<Pet> availablePets;
    private List<AdoptionRequest> adoptionRequests;

    public Adopter(String userId, String password, String firstName, String lastName, Location location, String email) {
        super(userId, password, firstName, lastName, location, Role.ADOPTER, email); // Utilisation de Role.ADOPTER au lieu de "Adopter"
        this.filters = new ArrayList<>();
        this.availablePets = new ArrayList<>();
        this.adoptionRequests = new ArrayList<>();
    }

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
    adoptionRequests.add(new AdoptionRequest(this, pet));
}

public void cancelAdoptionRequest(AdoptionRequest request) {
    // Implémentation pour annuler une demande d'adoption
    adoptionRequests.remove(request);
}
}