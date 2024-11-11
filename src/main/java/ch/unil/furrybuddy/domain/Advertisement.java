package ch.unil.furrybuddy.domain;

public class Advertisement {

    // Class fields
    public Pet pet;
    public PetOwner petOwner;
    public String description;
    public Location location;
    public Status status;

    public enum Status {
        AVAILABLE, UNAVAILABLE
    }

    // Constructors
    public Advertisement() {
        this(null, null, null, null, null);
    }

    public Advertisement(Pet pet, PetOwner petOwner, String description, Location location, Status status) {
        this.pet = pet;
        this.petOwner = petOwner;
        this.description = description;
        this.location = location;
        this.status = status;
    }

    // Getters and setters

    public Pet getPet() {return pet;}
    public void setPet(Pet pet) { this.pet = pet; }
    public PetOwner getPetOwner() {return petOwner;}
    public void setPetOwner(PetOwner petOwner) { this.petOwner = petOwner;}
    public String getDescription() {return description;}
    public void setDescription(String description) { this.description = description;}
    public Location getLocation() {return location;}
    public void setLocation(Location location) { this.location = location;}
    public Status getStatus() {return status;}
    public void setStatus(Status status) {this.status = status;}

}
