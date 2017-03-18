package impl;

import spec.Contact;

/**
 * A contact is a person we are making business with or may do in the future.
 *
 * <p>Contacts have an ID (unique, a non-zero positive integer), a name (not
 * necessarily unique), and notes that the user may want to save about them.</p>
 */
public class ContactImpl implements Contact {
  private int contactId;
  private String name;
  private String notes;

  /**
   * Constructs a contact from a provided id, name, and notes.
   * @param id the contact's id number
   * @param name the contact's name
   * @param notes relevant notes on the contact
   */
  public ContactImpl(final int id, final String name, final String notes) {
    if (id < 1) {
      throw new IllegalArgumentException();
    }
    if (name == null || notes == null) {
      throw new NullPointerException();
    }
    this.contactId = id;
    this.name = name;
    this.notes = notes;
  }

  /**
   * Constructs a contact from a provided id, and name.
   * @param id the contact's id number
   * @param name the contact's name
   */
  public ContactImpl(final int id, final String name) {
    if (id < 1) {
      throw new IllegalArgumentException();
    }
    if (name == null) {
      throw new NullPointerException();
    }
    this.contactId = id;
    this.name = name;
    this.notes = "";
  }

  /**
   * Returns the ID of the contact.
   *
   * @return the ID of the contact.
   */
  @Override
  public int getId() {
    return contactId;
  }

  /**
   * Returns the name of the contact.
   *
   * @return the name of the contact.
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Returns our notes about the contact, if any.
   *
   * <p>If we have not written anything about the contact, the empty
   * string is returned.</p>
   *
   * @return a string with notes about the contact, maybe empty.
   */
  @Override
  public String getNotes() {
    return notes;
  }

  /**
   * Add notes about the contact.
   *
   * @param note the notes to be added
   */
  @Override
  public void addNotes(final String note) {
    if (notes.equals("")) {
      this.notes = note;
    } else {
      notes += ", " + note;
    }
  }
}
