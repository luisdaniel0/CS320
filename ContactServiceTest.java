package Test;

import Contact.Contact;  // Import the Contact class from the Contact package
import Contact.ContactService;  // Import the ContactService class from the Contact package
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService contactService = new ContactService();

        // Test adding a contact
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "Sample Address");
        contactService.addContact(contact);

        // Assert that the contact is added
        assertTrue(contactService.getAllContacts().containsKey("12345"));
        assertEquals(contact, contactService.getAllContacts().get("12345"));
    }

    @Test
    public void testDeleteContact() {
        ContactService contactService = new ContactService();

        // Test deleting a contact
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "Sample Address");
        contactService.addContact(contact);

        // Delete the contact
        contactService.deleteContact("12345");

        // Assert that the contact is deleted
        assertFalse(contactService.getAllContacts().containsKey("12345"));
    }

    @Test
    public void testUpdateContactFields() {
        ContactService contactService = new ContactService();

        // Test updating contact fields
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "Sample Address");
        contactService.addContact(contact);

        // Update contact fields
        contactService.updateContactFields("12345", "Jane", "Smith", "9876543210", "New Address");

        // Assert that the contact fields are updated
        assertEquals("Jane", contactService.getAllContacts().get("12345").getFirstName());
        assertEquals("Smith", contactService.getAllContacts().get("12345").getLastName());
        assertEquals("9876543210", contactService.getAllContacts().get("12345").getPhone());
        assertEquals("New Address", contactService.getAllContacts().get("12345").getAddress());
    }

    @Test
    public void testUpdateContactFieldsNotFound() {
        ContactService contactService = new ContactService();

        // Test updating contact fields for a non-existent contact
        assertThrows(IllegalArgumentException.class, () ->
                contactService.updateContactFields("NonExistentId", "Jane", "Smith", "9876543210", "New Address"));
    }

    
}
