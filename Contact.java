/* Ashley Hensley
 * CS 320
 * 10/11/2026
 * Project One */

package contactService;

public class Contact {
	
	// Contact fields to set attributes of a Contact
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Contact Constructor to create new Contact object
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {

    	// Validation checks for each field as prompt asked for
    	// contactId: must not be null and must be 10 characters or fewer
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        // firstName: required and has max length of 10
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        // lastName: required and has max length of 10
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        // phone: required and must be exactly 10 digits
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        // address: required and has max length of 30
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        
        // Save validated fields into Contact object
        // contactID is final, cannot be changed after object created
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

/* GETTER METHODS provide read-only access to fields */
    
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

/* SETTER METHODS allow fields to be updated while enforcing validation */
  
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}