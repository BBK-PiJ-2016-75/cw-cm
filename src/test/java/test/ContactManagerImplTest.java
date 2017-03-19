package test;

import impl.ContactManagerImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.fail;

/**
 * Created by Dennis on 19/03/2017.
 */
public class ContactManagerImplTest {
  private ContactManagerImpl contactManager;
  private Calendar currentDate;
  private Calendar pastDate;
  private Calendar futureDate;

  @Before
  public void setUp() {
    contactManager = new ContactManagerImpl();
    currentDate = Calendar.getInstance();
    pastDate = Calendar.getInstance();
    pastDate.add(Calendar.YEAR, -1);
    futureDate = Calendar.getInstance();
    futureDate.add(Calendar.YEAR, 1);
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

  @Test(expected = NullPointerException.class)
  public void testContactManager_addNewContactNameIsNull() {
    contactManager.addNewContact(null, "Donuts");
  }

  @Test(expected = NullPointerException.class)
  public void testContactManager_addNewContactNotesIsNull() {
    contactManager.addNewContact("Homer", null);
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