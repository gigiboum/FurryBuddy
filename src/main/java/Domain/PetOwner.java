package Domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PetOwner extends User{

    public Set<Pet> pets;

    public PetOwner() {
        super();
        pets = new HashSet<>();
    }


    // Constructors
    public PetOwner(String email,String password, String firstname, String lastname, Location location, Role role) {
        this(null, email, password, firstname, lastname, location, role);
    }

    public PetOwner(UUID id, String email, String password, String firstname, String lastname, Location location, Role role) {
        super(id, email, password, firstname, lastname, location, role);
        pets = new HashSet<>();
    }

    //Getters and setter
    public Set<Pet> getPets() {return pets;
    }
    public void setPets(Set<Pet> pets) {this.pets = pets;
    }
    public void addPet(Pet pet) {pets.add(pet);
    }
    public void removePet(Pet pet) {pets.remove(pet);
    }
//
}
