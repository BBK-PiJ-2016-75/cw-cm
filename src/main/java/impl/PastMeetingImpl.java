package impl;

import spec.Contact;
import spec.PastMeeting;

import java.util.Calendar;
import java.util.Set;

/**
 * A meeting that was held in the past.
 *
 * <p>It includes your notes about what happened and what was agreed.</p>
 */
public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
  private final String notes;

  /**
   * Constructs a past meeting from a provided id, date, set of contacts, and notes.
   * @param id the past meeting's id number
   * @param date the past meeting's date
   * @param contacts the set of attending contacts
   * @param notes relevant notes on the meeting
   */
  public PastMeetingImpl(final int id, final Calendar date, final Set<Contact> contacts,
                         final String notes) {
    super(id, date, contacts);
    if (notes == null) {
      throw new NullPointerException();
    }
    this.notes = notes;
  }

  /**
   * Returns the notes from the meeting.
   *
   * <p>If there are no notes, the empty string is returned.</p>
   *
   * @return the notes from the meeting.
   */
  public String getNotes() {
    return notes;
  }
}
