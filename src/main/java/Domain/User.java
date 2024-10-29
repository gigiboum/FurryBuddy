package Domain;

public class User {

    private String userID;
    private String Password;
    private String FirstName;
    private String LastName;
    private location location;
    private role role;

    public User(String userID, String Password,
                String FirstName, String LastName,
                location location, role role) {
        this.userID= userID;
        this.Password = Password;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.location = location;
        this.role = role;
    }

    public enum role {
        ADOPTER, PET_OWNER
    }
}
