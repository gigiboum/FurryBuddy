package ch.unil.furrybuddy.domain;

import java.util.UUID;

public class Pet {

    //class fields
    private UUID petID;
    private String name;
    private String species;
    private String breed;
    private boolean neutered;
    private Gender gender;
    private String description;
    private String personality;
    private String color;
    private boolean isCompatibleWithInexperiencedOwners;
    private boolean isCompatibleWithKids;
    private boolean isCompatibleWithFamilies;
    private boolean isCompatibleWithOtherAnimals;
    private int age;
    private double price;
    private Status status;
    private boolean isSuitableForHouse;
    private boolean isVaccinated;
    private String medicalConditions;

    // Enum for Gender
    public enum Gender {
        MALE, FEMALE
    }
    // Enum for status
    public enum Status {
        AVAILABLE, PENDING, ADOPTED
    }

    //Constructors
    public Pet(){
        this(null, null, null, false, null, null, null, null, false, false, false, false, 0, 0.0,null, false,false, null);
    }

    public Pet(String name, String species, String breed, boolean neutered, Gender gender, String description, String personality, String color, boolean isCompatibleWithInexperiencedOwners,boolean isCompatibleWithKids,  boolean isCompatibleWithFamilies, boolean isCompatibleWithOtherAnimals, int age, double price, Status status, boolean isSuitableForHouse, boolean isVaccinated, String medicalConditions) {
        this(null, name, species, breed, neutered, gender, description, personality, color, isCompatibleWithInexperiencedOwners, isCompatibleWithKids, isCompatibleWithFamilies, isCompatibleWithOtherAnimals, age, price, status, isSuitableForHouse, isVaccinated, medicalConditions );
    }

    public Pet(UUID petID, String name, String species, String breed, boolean neutered, Gender gender, String description, String personality, String color, boolean isCompatibleWithInexperiencedOwners,boolean isCompatibleWithKids,  boolean isCompatibleWithFamilies, boolean isCompatibleWithOtherAnimals, int age, double price, Status status, boolean isSuitableForHouse, boolean isVaccinated, String medicalConditions) {
        this.petID = petID;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.neutered = neutered;
        this.gender = gender;
        this.description = description;
        this.personality = personality;
        this.color = color;
        this.isCompatibleWithInexperiencedOwners = isCompatibleWithInexperiencedOwners;
        this.isCompatibleWithKids = isCompatibleWithKids;
        this.isCompatibleWithFamilies = isCompatibleWithFamilies;
        this.isCompatibleWithOtherAnimals = isCompatibleWithOtherAnimals;
        this.age = age;
        this.price = price;
        this.status = status;
        this.isSuitableForHouse = isSuitableForHouse;
        this.isVaccinated = isVaccinated;
        this.medicalConditions = medicalConditions;
    }

    //Getters and Setters

    public UUID getPetID() {
        return petID;
    }
    public void setPetID(UUID petID) {
        this.petID = petID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public String getBreed(){
        return breed;
    }
    public void setBreed(String breed){
        this.breed = breed;
    }
    public boolean isNeutered() {
        return neutered;
    }
    public void setNeutered(boolean neutered) {
        this.neutered = neutered;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPersonality() {
        return personality;
    }
    public void setPersonality(String personality) {
        this.personality = personality;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isCompatibleWithInexperiencedOwners() {
        return isCompatibleWithInexperiencedOwners;
    }
    public void setCompatibleWithInexperiencedOwners(boolean compatibleWithInexperiencedOwners) { isCompatibleWithInexperiencedOwners = compatibleWithInexperiencedOwners; }
    public boolean isCompatibleWithKids() {
        return isCompatibleWithKids;
    }
    public void setCompatibleWithKids(boolean compatibleWithKids) {isCompatibleWithKids = compatibleWithKids; }
    public boolean isCompatibleWithFamilies() {
        return isCompatibleWithFamilies;
    }
    public void setCompatibleWithFamilies(boolean compatibleWithFamilies) {isCompatibleWithFamilies = compatibleWithFamilies; }
    public boolean isCompatibleWithOtherAnimals() {
        return isCompatibleWithOtherAnimals;
    }
    public void setCompatibleWithOtherAnimals(boolean compatibleWithOtherAnimals) {isCompatibleWithOtherAnimals = compatibleWithOtherAnimals; }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public boolean isSuitableForHouse() {
        return isSuitableForHouse;
    }
    public void setSuitableForHouse(boolean suitableForHouse) {
        isSuitableForHouse = suitableForHouse;
    }
    public boolean isVaccinated() {
        return isVaccinated;
    }
    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }
    public String getMedicalConditions() {
        return medicalConditions;
    }
    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    // functionalities / methods
    public void replaceWith(Pet pet){
        this.petID = pet.petID;
        this.name = pet.name;
        this.species = pet.species;
        this.breed = pet.breed;
        this.neutered = pet.neutered;
        this.gender = pet.gender;
        this.description = pet.description;
        this.personality = pet.personality;
        this.color = pet.color;
        this.isCompatibleWithInexperiencedOwners = pet.isCompatibleWithInexperiencedOwners;
        this.isCompatibleWithKids = pet.isCompatibleWithKids;
        this.isCompatibleWithFamilies = pet.isCompatibleWithFamilies;
        this.isCompatibleWithOtherAnimals = pet.isCompatibleWithOtherAnimals;
        this.age = pet.age;
        this.price = pet.price;
        this.status = pet.status;
        this.isSuitableForHouse = pet.isSuitableForHouse;
        this.isVaccinated = pet.isVaccinated;
        this.medicalConditions = pet.medicalConditions;
    }
}
