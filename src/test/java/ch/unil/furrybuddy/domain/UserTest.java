package ch.unil.furrybuddy.domain;

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
    void setUp() {
        Dummy = new TestDummy("test@example.com", "password123", "John", "Doe", new Location("City", "67890", "Address"), User.Role.ADOPTER);
    }


    // Test que les constructeurs sont correctement définis

    @Test
    void testParameterizedConstructor() {
        assertEquals("test@example.com", Dummy.getEmail());
        assertEquals("password123", Dummy.getPassword());
        assertEquals("John", Dummy.getFirstName());
        assertEquals("Doe", Dummy.getLastName());
        assertEquals("City", Dummy.getLocation().getTown());
        assertEquals(User.Role.ADOPTER, Dummy.getRole());
    }


    // Test des setters et getters

    @Test
    void testSetUserID() {
        UUID newID = UUID.randomUUID();
        Dummy.setUserID(newID);
        assertEquals(newID, Dummy.getUserID());
    }

    @Test
    void testSetEmail() {
        Dummy.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", Dummy.getEmail());
    }

    @Test
    void testSetPassword() {
        Dummy.setPassword("newpassword");
        assertEquals("newpassword", Dummy.getPassword());
    }

    @Test
    void testSetFirstName() {
        Dummy.setFirstName("Jane");
        assertEquals("Jane", Dummy.getFirstName());
    }

    @Test
    void testSetLastName() {
        Dummy.setLastName("Smith");
        assertEquals("Smith", Dummy.getLastName());
    }

    @Test
    void testSetLocation() {
        Location newLocation = new Location("NewCity", "67790", "NewAddress");
        Dummy.setLocation(newLocation);
        assertEquals("NewCity", Dummy.getLocation().getTown());
        assertEquals("NewAddress", Dummy.getLocation().getAddress());
    }

    @Test
    void testSetRole() {
        Dummy.setRole(User.Role.PET_OWNER);
        assertEquals(User.Role.PET_OWNER, Dummy.getRole());
    }
}
