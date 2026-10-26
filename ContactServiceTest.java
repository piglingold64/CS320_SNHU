/* Ashley Hensley
 * CS 320
 * 10/11/2026
 * Project One */

package contactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

	// Tests that new contact can be added and retrieved using ID
    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        assertEquals(contact, service.getContact("1"));
    }

    // Tests that adding contact with duplicate ID throws exception
    @Test
    public void testAddDuplicateContactId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1", "Jane", "Smith", "0987654321", "456 Oak St");

        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    // Tests that contact can be deleted and then is no longer retrievable
    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.deleteContact("1");

        assertNull(service.getContact("1"));
    }
    
 // Tests that updating a non-existent contact does nothing and does not throw an exception
    @Test
    public void testUpdateNonExistentContact() {
        ContactService service = new ContactService();
        
        // Should not throw; nothing should happen
        assertDoesNotThrow(() -> {
            service.updateFirstName("999", "NewName");
        });
        
        assertNull(service.getContact("999"));
    }

    // Tests updating the editable fields of contact and then verifies the changes
    @Test
    public void testUpdateFields() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);

        service.updateFirstName("1", "Mike");
        service.updateLastName("1", "Smith");
        service.updatePhone("1", "0987654321");
        service.updateAddress("1", "456 Oak St");

        assertEquals("Mike", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak St", contact.getAddress());
    }
}