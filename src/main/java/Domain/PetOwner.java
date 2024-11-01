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

    public PetOwner(String email,String password, String firstname, String lastname, Location location, Role role) {
        this(null, email, password, firstname, lastname, location, role);
    }

    public PetOwner(UUID id, String email, String password, String firstname, String lastname, Location location, Role role) {
        super(id, email, password, firstname, lastname, location, role);
        pets = new HashSet<>();
    }
}
