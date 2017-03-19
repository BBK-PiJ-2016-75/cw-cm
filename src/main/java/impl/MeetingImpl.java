package impl;

import spec.Contact;
import spec.Meeting;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * A class to represent meetings.
 *
 * <p>Meetings have unique IDs, scheduled date and a list of participating contacts.</p>
 */
public abstract class MeetingImpl implements Meeting {
  private final int meetingId;
  private final Calendar date;
  private final HashSet<Contact> contacts;

  /**
   * Constructs a meeting from a provided id, date, and set of contacts.
   * @param id the meeting's id number
   * @param date the meeting's date
   * @param contacts the set of attending contacts
   */
  MeetingImpl(final int id, final Calendar date, final Set<Contact> contacts) {
    if (id < 1) {
      throw new IllegalArgumentException("Meeting ID must be 1 or greater.");
    }
    if (date == null || contacts == null) {
      throw new NullPointerException();
    }
    if (contacts.isEmpty()) {
      throw new IllegalArgumentException("Set of contacts cannot be empty.");
    }
    this.meetingId = id;
    this.date = date;
    this.contacts = (HashSet<Contact>) contacts;
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
    return (Calendar) date.clone();
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
    return (Set<Contact>) contacts.clone();
  }
}
