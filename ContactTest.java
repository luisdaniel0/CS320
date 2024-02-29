package Test;

import Contact.Contact;  // Import the Contact class from the Contact package
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testContactConstructor() {
        // Test the constructor with valid values
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "Sample Address");

        // Assert that the contact object is not null
        assertNotNull(contact);

        // Assert that the values are set correctly
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("Sample Address", contact.getAddress());
    }

    @Test
    public void testContactSetters() {
        // Test the setters with valid values
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "Sample Address");

        // Update values using setters
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("9876543210");
        contact.setAddress("New Address");

        // Assert that the values are updated correctly
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("9876543210", contact.getPhone());
        assertEquals("New Address", contact.getAddress());

        // Test setters with invalid values (expecting IllegalArgumentException)
        assertThrows(IllegalArgumentException.class, () -> contact.setContactId(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("invalidPhone"));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("This address is too long and should cause an exception"));
    }

}
