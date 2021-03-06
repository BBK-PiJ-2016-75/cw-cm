package impl;

import spec.Contact;
import spec.ContactManager;
import spec.FutureMeeting;
import spec.Meeting;
import spec.PastMeeting;

import java.util.*;

/**
 * A class to manage your contacts and meetings.
 */
public class ContactManagerImpl implements ContactManager {
  private final HashMap<Integer, Meeting> meetings;
  private final HashMap<Integer, Contact> attendees;
  private int meetingIndex;
  private int attendeeIndex;

  /**
   * Constructs a contact manager.
   */
  public ContactManagerImpl() {
    this.meetings = new HashMap<>();
    this.attendees = new HashMap<>();
    this.meetingIndex = 1;
    this.attendeeIndex = 1;
  }

  /**
   * Add a new meeting to be held in the future.
   *
   * <p>An ID is returned when the meeting is put into the system. This
   * ID must be positive and non-zero.</p>
   *
   * @param contacts a set of contacts that will participate in the meeting
   * @param date     the date on which the meeting will take place
   * @return the ID for the meeting
   * @throws IllegalArgumentException if the meeting is set for a time
   *                                  in the past, of if any contact is unknown / non-existent.
   * @throws NullPointerException     if the meeting or the date are null
   */
  @Override
  public int addFutureMeeting(final Set<Contact> contacts, final Calendar date) {
    if (contacts == null || date == null) {
      throw new NullPointerException();
    }
    Calendar currentDate = Calendar.getInstance();
    if (date.before(currentDate)) {
      throw new IllegalArgumentException("The date is already past.");
    }
    for (Contact contact : contacts) {
      if (!attendees.containsValue(contact)) {
        throw new IllegalArgumentException("Unknown contact.");
      }
    }
    int result = meetingIndex;
    Meeting meeting = new FutureMeetingImpl(meetingIndex, date, contacts);
    meetings.put(meetingIndex, meeting);
    meetingIndex++;
    return result;
  }

  /**
   * Returns the PAST meeting with the requested ID, or null if it there is none.
   *
   * <p>The meeting must have happened at a past date.</p>
   *
   * @param id the ID for the meeting
   * @return the meeting with the requested ID, or null if it there is none.
   * @throws IllegalStateException if there is a meeting with that ID happening
   *                               in the future
   */
  @Override
  public PastMeeting getPastMeeting(final int id) {
    if (!meetings.containsKey(id)) {
      return null;
    }
    Calendar currentDate = Calendar.getInstance();
    if (meetings.get(id).getDate().after(currentDate)) {
      throw new IllegalStateException("The date is in the future.");
    } else {
      return (PastMeeting) meetings.get(id);
    }
  }

  /**
   * Returns the FUTURE meeting with the requested ID, or null if there is none.
   *
   * @param id the ID for the meeting
   * @return the meeting with the requested ID, or null if it there is none.
   * @throws IllegalStateException if there is a meeting with that ID happening
   *                               in the past
   */
  @Override
  public FutureMeeting getFutureMeeting(final int id) {
    return null;
  }

  /**
   * Returns the meeting with the requested ID, or null if it there is none.
   *
   * @param id the ID for the meeting
   * @return the meeting with the requested ID, or null if it there is none.
   */
  @Override
  public Meeting getMeeting(final int id) {
    return null;
  }

  /**
   * Returns the list of future meetings scheduled with this contact.
   *
   * <p>If there are none, the returned list will be empty. Otherwise,
   * the list will be chronologically sorted and will not contain any
   * duplicates.</p>
   *
   * @param contact one of the user’s contacts
   * @return the list of future meeting(s) scheduled with this contact (maybe empty).
   * @throws IllegalArgumentException if the contact does not exist
   * @throws NullPointerException     if the contact is null
   */
  @Override
  public List<Meeting> getFutureMeetingList(final Contact contact) {
    return null;
  }

  /**
   * Returns the list of meetings that are scheduled for, or that took
   * place on, the specified date.
   *
   * <p>If there are none, the returned list will be empty. Otherwise,
   * the list will be chronologically sorted and will not contain any
   * duplicates.</p>
   *
   * @param date the date
   * @return the list of meetings
   * @throws NullPointerException if the date are null
   */
  @Override
  public List<Meeting> getMeetingListOn(final Calendar date) {
    return null;
  }

  /**
   * Returns the list of past meetings in which this contact has participated.
   *
   * <p>If there are none, the returned list will be empty. Otherwise,
   * the list will be chronologically sorted and will not contain any
   * duplicates.</p>
   *
   * @param contact one of the user’s contacts
   * @return the list of future meeting(s) scheduled with this contact (maybe empty).
   * @throws IllegalArgumentException if the contact does not exist
   * @throws NullPointerException     if the contact is null
   */
  @Override
  public List<PastMeeting> getPastMeetingListFor(final Contact contact) {
    return null;
  }

  /**
   * Create a new record for a meeting that took place in the past.
   *
   * @param contacts a set of participants
   * @param date     the date on which the meeting took place
   * @param text     messages to be added about the meeting.
   * @return the ID for the meeting
   * @throws IllegalArgumentException if the list of contacts is
   *                                  empty, if any of the contacts does not exist, or if
   *                                  the date provided is in the future
   * @throws NullPointerException     if any of the arguments is null
   */
  @Override
  public int addNewPastMeeting(final Set<Contact> contacts, final Calendar date,
                               final String text) {
    if (contacts == null || date == null || text == null) {
      throw new NullPointerException();
    }
    if (contacts.isEmpty()) {
      throw new IllegalArgumentException("No contacts provided.");
    }
    for (Contact contact : contacts) {
      if (!attendees.containsValue(contact)) {
        throw new IllegalArgumentException("Unknown contact.");
      }
    }
    Calendar currentDate = Calendar.getInstance();
    if (date.after(currentDate)) {
      throw new IllegalArgumentException("The date is in the future.");
    }
    int result = meetingIndex;
    Meeting meeting = new PastMeetingImpl(meetingIndex, date, contacts, text);
    meetings.put(meetingIndex, meeting);
    meetingIndex++;
    return result;
  }

  /**
   * Add notes to a meeting.
   *
   * <p>This method is used when a future meeting takes place, and is
   * then converted to a past meeting (with notes) and returned.</p>
   *
   * <p>It can be also used to add notes to a past meeting at a later date.</p>
   *
   * @param id   the ID of the meeting
   * @param text messages to be added about the meeting.
   * @return the past meeting (with notes)
   * @throws IllegalArgumentException if the meeting does not exist
   * @throws IllegalStateException    if the meeting is set for a date in the future
   * @throws NullPointerException     if the notes are null
   */
  @Override
  public PastMeeting addMeetingNotes(final int id, final String text) {
    if (text == null) {
      throw new NullPointerException();
    }
    if (id < 1 || id > meetingIndex) {
      throw new IllegalArgumentException("No such meeting ID.");
    }
    return null;
  }

  /**
   * Create a new contact with the specified name and notes.
   *
   * @param name  the name of the contact.
   * @param notes notes to be added about the contact.
   * @return the ID for the new contact
   * @throws IllegalArgumentException if the name or the notes are empty strings
   * @throws NullPointerException     if the name or the notes are null
   */
  @Override
  public int addNewContact(final String name, final String notes) {
    if (name == null || notes == null) {
      throw new NullPointerException();
    }
    if (name.equals("") || notes.equals("")) {
      throw new IllegalArgumentException("A required parameter is empty.");
    }
    int result = attendeeIndex;
    Contact attendee = new ContactImpl(attendeeIndex, name, notes);
    attendees.put(attendeeIndex, attendee);
    attendeeIndex++;
    return result;
  }

  /**
   * Returns a set with the contacts whose name contains that string.
   *
   * <p>If the string is the empty string, this methods returns the set
   * that contains all current contacts.</p>
   *
   * @param name the string to search for
   * @return a set with the contacts whose name contains that string.
   * @throws NullPointerException if the parameter is null
   */
  @Override
  public Set<Contact> getContacts(final String name) {
    if (name == null) {
      throw new NullPointerException();
    }
    Set<Contact> result = new LinkedHashSet<>();
    for (Contact attendee : attendees.values()) {
      if (name.equals("") || attendee.getName().contains(name)) {
        result.add(attendee);
      }
    }
    return result;
  }

  /**
   * Returns a set containing the contacts that correspond to the IDs.
   * Note that this method can be used to retrieve just one contact by passing only one ID.
   *
   * @param ids an arbitrary number of contact IDs
   * @return a set containing the contacts that correspond to the IDs.
   * @throws IllegalArgumentException if no IDs are provided or if
   *                                  any of the provided IDs does not correspond to a real contact
   */
  @Override
  public Set<Contact> getContacts(final int... ids) {
    Set<Contact> result = new LinkedHashSet<>();
    for (int id : ids) {
      if (id < 1 || id > attendeeIndex) {
        throw new IllegalArgumentException("One or more IDs are out of range.");
      }
      result.add(attendees.get(id));
    }
    return result;
  }

  /**
   * Save all data to disk.
   *
   * <p>This method must be executed when the program is
   * closed and when/if the user requests it.</p>
   */
  @Override
  public void flush() {

  }
}
