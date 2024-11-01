package Domain;

import java.util.UUID;

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
    public AdoptionRequest(Adopter adopter, Advertisement advertisement) {
        this.requestID = UUID.randomUUID().toString();
        this.adopter = adopter;
        this.advertisement = advertisement;
        this.status = Status.PENDING; // Statut initial de la demande (not sure)
    }

    public AdoptionRequest(String requestID, Adopter adopter, Advertisement advertisement, Status status) {
        this.requestID = requestID;
        this.adopter = adopter;
        this.advertisement = advertisement;
        this.status = status;
    }

// Getters and Setters
    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public Adopter getAdopter() {return adopter;
    }

    public void setAdopter(Adopter adopter) {this.adopter = adopter;
    }

    public Advertisement getAdvertisement() {return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {this.advertisement = advertisement;
    }

    public Status getStatus() {return status;
    }

    public void setStatus(Status status) {this.status = status;
    }

    public void approveRequest() {this.status = Status.APPROVED;
    }
    public void rejectRequest() {this.status = Status.REJECTED;
    }
    public boolean isPending() {return this.status == Status.PENDING;
    }

}



