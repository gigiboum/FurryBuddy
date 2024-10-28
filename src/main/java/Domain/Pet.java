package Domain;

public class Pet {
    private String petId;
    private String name;
    private String species;
    private String race;
    private boolean neutered;
    private String gender;
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

    public enum Status {
        AVAILABLE, PENDING, ADOPTED
    }
}
