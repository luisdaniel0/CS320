package Contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contactsMap;

    public ContactService() {
        this.contactsMap = new HashMap<>();
    }

    public void addContact(Contact contact) {
        // Ensure the contact ID is unique before adding
        if (!contactsMap.containsKey(contact.getContactId())) {
            contactsMap.put(contact.getContactId(), contact);
        } else {
            throw new IllegalArgumentException("Contact ID must be unique.");
        }
    }

    public void deleteContact(String contactId) {
        // Remove contact with the given contact ID
        contactsMap.remove(contactId);
    }

    public void updateContactFields(String contactId, String newFirstName, String newLastName, String newPhone, String newAddress) {
        // Update contact fields based on the specified contact ID
        if (contactsMap.containsKey(contactId)) {
            Contact contact = contactsMap.get(contactId);

            // Update fields if the new values are not null
            if (newFirstName != null) {
                contact.setFirstName(newFirstName);
            }
            if (newLastName != null) {
                contact.setLastName(newLastName);
            }
            if (newPhone != null) {
                contact.setPhone(newPhone);
            }
            if (newAddress != null) {
                contact.setAddress(newAddress);
            }
        } else {
            throw new IllegalArgumentException("Contact with ID " + contactId + " not found.");
        }
    }


    // Getter for all contacts (for testing or other purposes)
    public Map<String, Contact> getAllContacts() {
        return contactsMap;
    }
}
