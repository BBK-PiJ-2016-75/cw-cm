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
import static org.junit.Assert.fail;

/**
 * Created by Dennis on 19/03/2017.
 */
public class MeetingImplTest {
  private Calendar date;
  private Set<Contact> contacts;

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

//  @Test
//  public void getId() throws Exception {
//  }

//  @Test
//  public void getDate() throws Exception {
//  }

//  @Test
//  public void getContacts() throws Exception {
//  }

}