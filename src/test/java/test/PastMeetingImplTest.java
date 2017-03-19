package test;

import impl.ContactImpl;
import impl.PastMeetingImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spec.Contact;
import spec.PastMeeting;

import java.util.Calendar;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests the constructor and the methods of the PastMeetingImpl class.
 */
public class PastMeetingImplTest {
  private Calendar pastDate;
  private HashSet<Contact> contacts;
  private String notes;

  @Before
  public void setUp() {
    pastDate = Calendar.getInstance();
    pastDate.add(Calendar.YEAR, -1);
    contacts = new HashSet<Contact>();
    contacts.add(new ContactImpl(1, "Homer"));
    contacts.add(new ContactImpl(2, "Marge", "Hmmmmm"));
    notes = "";
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testPastMeeting_Constructor() {
    try {
      new PastMeetingImpl(1, pastDate, contacts, notes);
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testPastMeeting_GetIdDateContacts() {
    PastMeeting pastMeeting = new PastMeetingImpl(1, pastDate, contacts, notes);
    assertEquals(1, pastMeeting.getId());
    assertEquals(pastDate, pastMeeting.getDate());
    assertEquals(contacts, pastMeeting.getContacts());
  }

  @Test
  public void testPastMeeting_GetNotes() {
    PastMeeting pastMeeting = new PastMeetingImpl(1, pastDate, contacts, notes);
    assertEquals(notes, pastMeeting.getNotes());
  }

  @Test(expected = NullPointerException.class)
  public void testPastMeeting_NotesIsNull() {
    PastMeeting pastMeeting = new PastMeetingImpl(1, pastDate, contacts, null);
  }
}