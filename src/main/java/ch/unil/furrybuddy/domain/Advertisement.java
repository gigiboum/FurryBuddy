package ch.unil.furrybuddy.domain;

import java.util.UUID;

public class Advertisement {

    // Class fields
    private UUID advertisementID;
    private Pet pet;
    private UUID petOwnerID;
    private String description;
    private Location location;
    private Status status;

    public enum Status {
        AVAILABLE, UNAVAILABLE
    }

    // Constructors
    public Advertisement() {
        this(null, null, null, null, null);
    }

    public Advertisement(Pet pet, UUID petOwnerID, String description, Location location, Status status){
        this(null, pet, petOwnerID, description, location, status);
    }
    public Advertisement(UUID advertisementID, Pet pet, UUID petOwnerID, String description, Location location, Status status) {
        this.advertisementID = advertisementID;
        this.pet = pet;
        this.petOwnerID = petOwnerID;
        this.description = description;
        this.location = location;
        this.status = status;
    }

    // Getters and setters
    public UUID getAdvertisementID() {return advertisementID;}
    public void setAdvertisementID(UUID advertisementID) {this.advertisementID = advertisementID;}
    public Pet getPet() {return pet;}
    public void setPet(Pet pet) { this.pet = pet; }
    public UUID getPetOwnerID() {return petOwnerID;}
    public void setPetOwnerID(UUID petOwnerID) { this.petOwnerID = petOwnerID;}
    public String getDescription() {return description;}
    public void setDescription(String description) { this.description = description;}
    public Location getLocation() {return location;}
    public void setLocation(Location location) { this.location = location;}
    public Status getStatus() {return status;}
    public void setStatus(Status status) {this.status = status;}

    public void replaceWith(Advertisement advertisement) {
        if (advertisement == null) {
            throw new IllegalArgumentException("Advertisement cannot be null");
        }
        this.advertisementID = advertisement.advertisementID;
        this.pet = advertisement.pet;
        this.petOwnerID = advertisement.petOwnerID;
        this.description = advertisement.description;
        this.location = advertisement.location;
        this.status = advertisement.status;
    }
}
