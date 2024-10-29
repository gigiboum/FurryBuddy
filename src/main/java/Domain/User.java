package Domain;

public abstract class User {
    private String userId;
    private String password;
    private String firstName;
    private String lastName;
    private location location;
    private role role;

    public User(String userId, String password, String firstName, String lastName, Location location, Role role) {
        this.userId = userId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.role = role;
    }

    public enum Role {
        ADOPTER, PET_OWNER
    }
