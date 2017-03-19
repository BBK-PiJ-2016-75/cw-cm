package impl;

import spec.Contact;
import spec.PastMeeting;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by Dennis on 18/03/2017.
 */
public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
  private final String notes;

  /**
   * dennis.
   * @param id den
   * @param date den
   * @param contacts den
   * @param notes den
   */
  public PastMeetingImpl(final int id, final Calendar date, final Set<Contact> contacts,
                         final String notes) {
    super(id, date, contacts);
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
