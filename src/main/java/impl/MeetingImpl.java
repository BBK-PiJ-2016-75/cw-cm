package impl;

import spec.Contact;
import spec.Meeting;
import spec.PastMeeting;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by Dennis on 17/03/2017.
 */
public class MeetingImpl implements Meeting, PastMeeting {
  /**
   * dennis.
   * @param nowDate den
   * @param contacts den
   */
  public MeetingImpl(final Calendar nowDate, final Set<Contact> contacts) {

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
