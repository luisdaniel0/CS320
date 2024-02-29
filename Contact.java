package Contact;

public class Contact {
    // Fields
    private String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        setContactId(contactId);
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters with validation
    public void setContactId(String contactId) {
        // Validate contactId (not null and <= 10 characters)
        if (contactId != null && contactId.length() <= 10) {
            this.contactId = contactId;
        } else {
            throw new IllegalArgumentException("Contact ID must not be null and must not exceed 10 characters.");
        }
    }

    public void setFirstName(String firstName) {
        // Validate firstName (not null and <= 10 characters)
        if (firstName != null && firstName.length() <= 10) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("First Name must not be null and must not exceed 10 characters.");
        }
    }

    public void setLastName(String lastName) {
        // Validate lastName (not null and <= 10 characters)
        if (lastName != null && lastName.length() <= 10) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Last Name must not be null and must not exceed 10 characters.");
        }
    }

    public void setPhone(String phone) {
        // Validate phone (not null and must be exactly 10 digits)
        if (phone != null && phone.matches("\\d{10}")) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Phone must not be null and must be exactly 10 digits.");
        }
    }

    public void setAddress(String address) {
        // Validate address (not null and <= 30 characters)
        if (address != null && address.length() <= 30) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Address must not be null and must not exceed 30 characters.");
        }
    }

    
    @Override
    public String toString() {
        return "Contact{" +
                "contactId='" + contactId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
