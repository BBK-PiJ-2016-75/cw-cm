package test;

import impl.MockContactImpl;
import impl.MockMeetingImpl;
import org.junit.Before;
import org.junit.Test;
import spec.Contact;
import spec.Meeting;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MeetingSpecTest {

  Calendar nowDate;
  Set<Contact> contacts;

  @Before
  public void setUp() {
    nowDate = Calendar.getInstance();
    contacts = new HashSet<Contact>();
    contacts.add(new MockContactImpl());
    contacts.add(new MockContactImpl());
  }

  @Test
  public void testConstructor() {
    try {
      new MockMeetingImpl(1, nowDate, contacts);
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testConstructorSets() {
    Meeting meeting = new MockMeetingImpl(1, nowDate, contacts);

    assertThat(meeting.getId(), is(notNullValue()));
    assertEquals(meeting.getDate(), nowDate);
    assertEquals(meeting.getContacts(), contacts);
  }

  @Test
  public void testImmutableDate() {
    Meeting meeting = new MockMeetingImpl(1, nowDate, contacts);
    Calendar date = meeting.getDate();
    date.add(Calendar.YEAR, 1);
    assertFalse(date.get(Calendar.YEAR) == meeting.getDate().get(Calendar.YEAR));
  }

  @Test
  public void testContactsImmutableFromOutsideObject() {
    Meeting meeting = new MockMeetingImpl(1, nowDate, contacts);
    Set<Contact> contacts = meeting.getContacts();
    contacts.add(new MockContactImpl());
    assertFalse(contacts.size() == meeting.getContacts().size());
  }

  @Test
  public void testUniqueIds() {
    Meeting meetingOne = new MockMeetingImpl(1, nowDate, contacts);
    Meeting meetingTwo = new MockMeetingImpl(1, nowDate, contacts);

    assertThat(meetingOne.getId(), is(not(equalTo(meetingTwo.getId()))));
  }
}
