package Domain;

public class PetFilter {

    //Class fields
    private String species;
    private String breed;
    private Integer minAge;
    private Integer maxAge;
    private Boolean neutered;
    private Boolean isCompatibleWithKids;
    private Pet.Gender gender;
    private Boolean isCompatibleWithInexperiencedOwners;
    private Boolean isCompatibleWithFamilies;
    private boolean isCompatibleWithOtherAnimals;
    private boolean isSuitableForHouse;
    private boolean isVaccinated;

    public boolean matches(Pet pet) {
        return (species == null || pet.getSpecies().equalsIgnoreCase(species)) &&
                (breed == null || pet.getBreed().equalsIgnoreCase(breed)) &&
                (minAge == null || pet.getAge() >= minAge) &&
                (maxAge == null || pet.getAge() <= maxAge) &&
                (neutered == null || pet.isNeutered() == neutered) &&
                (isCompatibleWithKids == null || pet.isCompatibleWithKids() == isCompatibleWithKids) &&
                (gender == null || pet.getGender().equals(gender)) &&
                (isCompatibleWithFamilies == null || pet.isCompatibleWithFamilies() == isCompatibleWithFamilies);
    }

    // Getters and Setters for each field

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Boolean getNeutered() {
        return neutered;
    }

    public void setNeutered(Boolean neutered) {
        this.neutered = neutered;
    }

    public Boolean getIsCompatibleWithKids() {
        return isCompatibleWithKids;
    }

    public void setIsCompatibleWithKids(Boolean isCompatibleWithKids) {
        this.isCompatibleWithKids = isCompatibleWithKids;
    }
}
