package impl;

import spec.Contact;

/**
 * Created by Dennis on 17/03/2017.
 */
public class MockContactImpl implements Contact {
  /**
   * Returns the ID of the contact.
   *
   * @return the ID of the contact.
   */
  @Override
  public int getId() {
    return 0;
  }

  /**
   * Returns the name of the contact.
   *
   * @return the name of the contact.
   */
  @Override
  public String getName() {
    return null;
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
    return null;
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
