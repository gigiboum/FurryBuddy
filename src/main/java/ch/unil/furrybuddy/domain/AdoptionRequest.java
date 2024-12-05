package ch.unil.furrybuddy.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class AdoptionRequest {
    @Id
    private UUID requestID;

    private UUID adopterID;

    @OneToOne
    @JoinColumn(name="ADVERTISEMENT")
    private Advertisement advertisement;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String message;

    // Enum for Status
    public enum Status {
        PENDING, APPROVED, REJECTED, CANCELLED
    }

    // Constructors
    public AdoptionRequest() {
        this(null, null, null, null);
    }

    public AdoptionRequest(UUID adopterID, Advertisement advertisement, Status status, String message) {
        this(null, adopterID, advertisement, status, message);
    }

    public AdoptionRequest(UUID requestID, UUID adopterID, Advertisement advertisement, Status status, String message) {
        this.requestID = requestID;
        this.adopterID = adopterID;
        this.advertisement = advertisement;
        this.status = status;
        this.message = message;
    }
    // Getters and Setters
    public UUID getRequestID() {
        return requestID;
    }
    public void setRequestID(UUID requestID) {
        this.requestID = requestID;
    }
    public UUID getAdopterID() {return adopterID;
    }
    public void setAdopterID(UUID adopterID) {this.adopterID = adopterID;
    }
    public Advertisement getAdvertisement() {return advertisement;
    }
    public void setAdvertisement(Advertisement advertisement) {this.advertisement = advertisement;
    }
    public Status getStatus() {return status;
    }
    public void setStatus(Status status) {this.status = status;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public boolean isPending() {return this.status == Status.PENDING;
    }

    public void replaceWith(AdoptionRequest adoptionRequest) {
        if (adoptionRequest == null) {
            throw new IllegalArgumentException("Adoption Request cannot be null");
        }
        this.requestID = adoptionRequest.getRequestID();
        this.adopterID = adoptionRequest.getAdopterID();
        this.advertisement = adoptionRequest.getAdvertisement();
        this.status = adoptionRequest.getStatus();
    }
}
