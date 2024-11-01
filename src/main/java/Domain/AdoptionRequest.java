package Domain;

public class AdoptionRequest {
    private String requestID;
    private Adopter adopter;
    private Advertisement advertisement;
    private Status status;

    // Enum for Status
    public enum Status {
        PENDING, APPROVED, REJECTED
    }

    // Constructors
    public AdoptionRequest(String requestID, Adopter adopter, Advertisement advertisement, Status status) {}

    //Getters and Setters
}
