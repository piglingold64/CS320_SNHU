/* Ashley Hensley
 * CS 320
 * 10/11/2026
 * Project One */

package contactService;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

	// HashMap stores contacts in memory
	// Key = contact ID
	// Value = Contact object
    private Map<String, Contact> contacts = new HashMap<>();

    // If ID is unique, adds a new contact
    // Will throw exception if ID not unique
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Deletes contact from service using ID
    // If ID does not exist, nothing happens
    public void deleteContact(String contactId) {
        contacts.remove(contactId);
    }

    // Updates first name of contact if contact exists
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            contact.setFirstName(firstName);
        }
    }

    // Updates last name of contact if contact exists
    public void updateLastName(String contactId, String lastName) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            contact.setLastName(lastName);
        }
    }

    // Updates phone number of contact if contact exists
    public void updatePhone(String contactId, String phone) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            contact.setPhone(phone);
        }
    }

    // Updates address of contact if contact exists
    public void updateAddress(String contactId, String address) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            contact.setAddress(address);
        }
    }

    // Retrieves contact by ID if contact exists
    // Returns null if not found
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}