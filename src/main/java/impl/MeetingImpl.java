package impl;

import spec.Contact;
import spec.Meeting;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by Dennis on 18/03/2017.
 */
public abstract class MeetingImpl implements Meeting {
  private int meetingId;
  private Calendar date;
  private Set<Contact> contacts;

  /**
   * dennis.
   * @param id den
   * @param date den
   * @param contacts den
   */
  public MeetingImpl(final int id, final Calendar date, final Set<Contact> contacts) {
    this.meetingId = id;
    this.date = date;
    this.contacts = contacts;
  }

  /**
   * Returns the id of the meeting.
   *
   * @return the id of the meeting.
   */
  @Override
  public int getId() {
    return meetingId;
  }

  /**
   * Return the date of the meeting.
   *
   * @return the date of the meeting.
   */
  @Override
  public Calendar getDate() {
    return date;
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
    return contacts;
  }
}
