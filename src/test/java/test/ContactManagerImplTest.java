package test;

import impl.ContactManagerImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spec.Contact;
import spec.Meeting;

import java.util.HashMap;

import static org.junit.Assert.fail;

/**
 * Created by Dennis on 19/03/2017.
 */
public class ContactManagerImplTest {
  private HashMap<Integer, Meeting> meetings;
  private HashMap<Integer, Contact> attendees;
  private int meetingIndex;
  private int attendeeIndex;

  @Before
  public void setUp() {
    meetings = new HashMap<>();
    attendees = new HashMap<>();
    meetingIndex = 1;
    attendeeIndex = 1;
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testContactManager_Constructor() {
    try {
      new ContactManagerImpl();
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void addFutureMeeting() {
  }

  @Test
  public void getPastMeeting() {
  }

  @Test
  public void getFutureMeeting() {
  }

  @Test
  public void getMeeting() {
  }

  @Test
  public void getFutureMeetingList() {
  }

  @Test
  public void getMeetingListOn() {
  }

  @Test
  public void getPastMeetingListFor() {
  }

  @Test
  public void addNewPastMeeting() {
  }

  @Test
  public void addMeetingNotes() {
  }

  @Test
  public void addNewContact() {
  }

  @Test
  public void getContacts() {
  }

  @Test
  public void getContacts1() {
  }

  @Test
  public void flush() {
  }

}