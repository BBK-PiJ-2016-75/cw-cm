package impl;

import spec.Contact;
import spec.FutureMeeting;

import java.util.Calendar;
import java.util.Set;

/**
 * A meeting to be held in the future.
 */
public class FutureMeetingImpl extends MeetingImpl implements FutureMeeting {

  /**
   * Constructs a future meeting from a provided id, date, and set of contacts.
   * @param id the future meeting's id number
   * @param date the future meeting's date
   * @param contacts the set of attending contacts
   */
  public FutureMeetingImpl(final int id, final Calendar date, final Set<Contact> contacts) {
    super(id, date, contacts);
  }
}
