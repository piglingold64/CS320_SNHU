/* Ashley Hensley
 * CS 320
 * 10/11/2026
 * Project One */

package contactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {
	
	// Tests that a valid contact object is created properly 
	// and that all fields are stored 
    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Tests that invalid contact IDs tell constructor to throw exception
    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    // Tests that invalid first names are rejected by constructor
    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Doe", "1234567890", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "ThisNameIsTooLong", "Doe", "1234567890", "123 Main St");
        });
    }

    // Tests that invalid last names are rejected by constructor
    @Test
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", null, "1234567890", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "ThisLastNameIsTooLong", "1234567890", "123 Main St");
        });
    }

    // Tests that invalid phone numbers are rejected by constructor
    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", null, "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "12345", "123 Main St");
        });
    }
    
    // Tests that phone number with non-digit characters is rejected by constructor
    @Test
    public void testInvalidPhoneNonDigit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "12345abcde", "123 Main St");
        });
    }
    
    // Tests that valid 10-digit phone number is accepted by setter
    // Also makes sure it updates correctly
    @Test
    public void testSetPhoneValid() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }
    
    // Tests that setter rejects phone numbers not exactly 10 digits
    @Test
    public void testSetPhoneInvalidLength() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("1234");
        });
    }
    
    // Tests that invalid addresses are rejected by constructor
    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", "This address is definitely more than thirty characters long");
        });
    }
}