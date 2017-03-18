package impl;

import spec.Contact;
import spec.PastMeeting;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by Dennis on 18/03/2017.
 */
public class PastMeetingImpl extends MeetingImpl implements PastMeeting {

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
  }

  /**
   * Returns the id of the meeting.
   *
   * @return the id of the meeting.
   */
  @Override
  public int getId() {
    return 0;
  }

  /**
   * Return the date of the meeting.
   *
   * @return the date of the meeting.
   */
  @Override
  public Calendar getDate() {
    return null;
  }

  /**
   * Return the details of people that attended the meeting.
   *
   * <p>The list contains a minimum of one contact (if there were
   * just two people: the user and the contact) and may contain an
   * arbitrary number of them.</p>
   *
   * @return the details of people that attended the meeting.
   */
  @Override
  public Set<Contact> getContacts() {
    return null;
  }

  /**
   * Returns the notes from the meeting.
   *
   * <p>If there are no notes, the empty string is returned.</p>
   *
   * @return the notes from the meeting.
   */
  @Override
  public String getNotes() {
    return null;
  }
}
