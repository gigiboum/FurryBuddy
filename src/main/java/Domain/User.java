package Domain;

public abstract class User {
    private String userID;
    private String password;
    private String firstName;
    private String lastName;
    private Location location; // Correction de la capitalisation
    private Role role;
    private String email;

    public User(String userID, String password, String firstName, String lastName, Location location, Role role) {
        this.userID = userID;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.role = role;
        this.email = email;
    }

    public enum Role {
        ADOPTER, PET_OWNER
    }
}
