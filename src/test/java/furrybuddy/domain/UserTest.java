package furrybuddy.domain;

import Domain.Location;
import Domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    private User Dummy;

    // Classe interne pour tester car User est abstrait.
    private static class TestDummy extends User {
        public TestDummy(String email, String password, String firstName, String lastName, Location location, Role role) {
            super(email, password, firstName, lastName, location, role);
        }
    }

    @BeforeEach
    void setUp() { Dummy = new User(); }


    // Test que les constructeurs sont correctement définis

    @Test
    void testParameterizedConstructor() {
        assertEquals("test@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("City", user.getLocation().getCity());
        assertEquals(User.Role.ADOPTER, user.getRole());
    }


    // Test des setters et getters

    @Test
    void testSetUserID() {
        UUID newID = UUID.randomUUID();
        user.setUserID(newID);
        assertEquals(newID, user.getUserID());
    }

    @Test
    void testSetEmail() {
        user.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", user.getEmail());
    }

    @Test
    void testSetPassword() {
        user.setPassword("newpassword");
        assertEquals("newpassword", user.getPassword());
    }

    @Test
    void testSetFirstName() {
        user.setFirstName("Jane");
        assertEquals("Jane", user.getFirstName());
    }

    @Test
    void testSetLastName() {
        user.setLastName("Smith");
        assertEquals("Smith", user.getLastName());
    }

    @Test
    void testSetLocation() {
        Location newLocation = new Location("NewCity", "NewCountry");
        user.setLocation(newLocation);
        assertEquals("NewCity", user.getLocation().getCity());
        assertEquals("NewCountry", user.getLocation().getCountry());
    }

    @Test
    void testSetRole() {
        user.setRole(User.Role.PET_OWNER);
        assertEquals(User.Role.PET_OWNER, user.getRole());
    }
}
