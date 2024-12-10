package ch.unil.furrybuddy.domain;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    // class fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USERID", updatable = false, nullable = false)
    private UUID userID;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="LOCATION")
    private Location location; // Correction de la capitalisation

    @Enumerated(EnumType.STRING)
    private Role role;

    // constructors
    public User() {
        this(null, null, null, null, null, null);
    }

    public User(String email, String password, String firstname, String lastname, Location location, Role role) {
        this(null, email, password, firstname, lastname, location, role);
    }

    public User(UUID userID, String email, String password, String firstName, String lastName, Location location, Role role) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.role = role;
    }

    public enum Role {
        ADOPTER, PET_OWNER
    }

    // getters and setters
    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userId) {
        this.userID = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // functionalities
    public void replaceWith(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        this.userID = user.userID;
        this.email = user.email;
        this.password = user.password;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.location = user.location;
        this.role = user.role;
    }

    public void changeLocation(Location location) {
        if (location == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }
        this.location = location;
    }

}
