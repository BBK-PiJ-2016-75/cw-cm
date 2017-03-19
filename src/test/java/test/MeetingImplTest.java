package test;

import impl.ContactImpl;
import impl.MockMeetingImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spec.Contact;
import spec.Meeting;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * Created by Dennis on 19/03/2017.
 */
public class MeetingImplTest {
  private Calendar date;
  private HashSet<Contact> contacts;

  @Before
  public void setUp() throws Exception {
    date = Calendar.getInstance();
    contacts = new HashSet<Contact>();
    contacts.add(new ContactImpl(1, "Homer"));
    contacts.add(new ContactImpl(2, "Marge", "Hmmmmm"));
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testMeeting_Constructor() {
    try {
      new MockMeetingImpl(1, date, contacts);
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testMeeting_GetIdDateContacts() throws Exception {
    Meeting meeting = new MockMeetingImpl(1, date, contacts);
    assertEquals(1, meeting.getId());
    assertEquals(date, meeting.getDate());
    assertEquals(contacts, meeting.getContacts());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMeeting_IdIsZero() {
    Meeting meeting = new MockMeetingImpl(0, date, contacts);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMeeting_IdLessThanZero() {
    Meeting meeting = new MockMeetingImpl(-1, date, contacts);
  }

  @Test(expected = NullPointerException.class)
  public void testMeeting_DateIsNull() {
    Meeting meeting = new MockMeetingImpl(1, null, contacts);
  }

  @Test(expected = NullPointerException.class)
  public void testMeeting_ContactsIsNull() {
    Meeting meeting = new MockMeetingImpl(1, date, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMeeting_ContactsIsEmpty() {
    contacts.clear();
    Meeting meeting = new MockMeetingImpl(1, date, contacts);
  }

  @Test
  public void testMeeting_DateIsMutable() {
    Meeting meeting = new MockMeetingImpl(1, date, contacts);
    Calendar testDate = meeting.getDate();
    testDate.add(Calendar.YEAR, 1);
    assertFalse(testDate.get(Calendar.YEAR) == meeting.getDate().get(Calendar.YEAR));
  }

  @Test
  public void testMeeting_ContactsIsMutable() {
    Meeting meeting = new MockMeetingImpl(1, date, contacts);
    Set<Contact> testContacts = meeting.getContacts();
    testContacts.add(new ContactImpl(3, "Bart"));
    assertFalse(testContacts.size() == meeting.getContacts().size());
  }
}