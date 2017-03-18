package impl;

import spec.Contact;

/**
 * Created by Dennis on 18/03/2017.
 */
public class ContactImpl implements Contact {
  private int contactId;
  private String name;
  private String notes;

  /**
   * dennis.
   * @param id den
   * @param name den
   * @param notes den
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
   * dennis.
   * @param id den
   * @param name den
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

  }
}
