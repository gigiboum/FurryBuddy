package ch.unil.furrybuddy.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    private User dummyUser;

    @BeforeEach
    void setUp() {
        dummyUser = new User("test@example.com", "password123", "John", "Doe", new Location("City", "67890", "Address"), User.Role.ADOPTER);
    }


    // Test que les constructeurs sont correctement définis

    @Test
    void testParameterizedConstructor() {
        assertEquals("test@example.com", dummyUser.getEmail());
        assertEquals("password123", dummyUser.getPassword());
        assertEquals("John", dummyUser.getFirstName());
        assertEquals("Doe", dummyUser.getLastName());
        assertEquals("City", dummyUser.getLocation().getTown());
        assertEquals(User.Role.ADOPTER, dummyUser.getRole());
    }


    // Test des setters et getters

    @Test
    void testSetUserID() {
        UUID newID = UUID.randomUUID();
        dummyUser.setUserID(newID);
        assertEquals(newID, dummyUser.getUserID());
    }

    @Test
    void testSetEmail() {
        dummyUser.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", dummyUser.getEmail());
    }

    @Test
    void testSetPassword() {
        dummyUser.setPassword("newpassword");
        assertEquals("newpassword", dummyUser.getPassword());
    }

    @Test
    void testSetFirstName() {
        dummyUser.setFirstName("Jane");
        assertEquals("Jane", dummyUser.getFirstName());
    }

    @Test
    void testSetLastName() {
        dummyUser.setLastName("Smith");
        assertEquals("Smith", dummyUser.getLastName());
    }

    @Test
    void testSetLocation() {
        Location newLocation = new Location("NewCity", "67790", "NewAddress");
        dummyUser.setLocation(newLocation);
        assertEquals("NewCity", dummyUser.getLocation().getTown());
        assertEquals("NewAddress", dummyUser.getLocation().getAddress());
    }

    @Test
    void testSetRole() {
        dummyUser.setRole(User.Role.PET_OWNER);
        assertEquals(User.Role.PET_OWNER, dummyUser.getRole());
    }
}
