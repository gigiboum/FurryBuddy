package Domain;

public class AdoptionRequest {
    private String RequestID;
    private String userID;
    private String petID;
    private Status status;

    public enum Status {
        PENDING, APPROVED, REJECTED // permet de clarifier le status de la demande
    }

    public Request(String requestID, String userID, String petID, Status statuts) {
        this.requestID = requestID;
        this.userID = userID;
        this.petID = petID;
        this.status = statuts;
    }
}
