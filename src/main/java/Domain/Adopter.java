import java.util.ArrayList;
import java.util.List;

public class Adopter extends User {
    private List<Request> requests; // Keeps track of requests made by the adopter

    public Adopter(String userId, String password, String firstName, String lastName, Location location) {
        super(userId, password, firstName, lastName, location, Role.ADOPTER);
        this.requests = new ArrayList<>();
    }

    public List<Pet> findPets(boolean useFilters) {
        // Stub: Implement search logic with or without filters
        // Example return, assuming a PetService for retrieval
        return useFilters ? PetService.findPetsWithFilters() : PetService.findAllPets();
    }

    public void requestAdoption(Pet pet) {
        Request newRequest = new Request(generateRequestId(), this.getUserId(), pet.getPetId(), Request.Status.PENDING);
        requests.add(newRequest);
        // Logic to save request in the system, e.g., RequestService.save(newRequest);
    }

    public void cancelRequest(Request request) {
        request.setStatus(Request.Status.CANCELLED);
        // Update in system if needed
    }

    private String generateRequestId() {
        return "REQ" + System.currentTimeMillis();
    }

    // Additional methods, getters, and setters as needed
}
