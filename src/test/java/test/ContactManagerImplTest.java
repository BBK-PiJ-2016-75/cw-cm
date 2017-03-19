package test;

import impl.ContactManagerImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spec.Contact;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
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

  @Test(expected = NullPointerException.class)
  public void testContactManager_addFutureMeetingContactsIsNull() {
    contactManager.addFutureMeeting(null, futureDate);
  }

  @Test(expected = NullPointerException.class)
  public void testContactManager_addFutureMeetingDateIsNull() {
    Set<Contact> attendees = new HashSet<>();
    contactManager.addFutureMeeting(attendees, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testContactManager_addFutureMeetingDateIsPast() {
    Set<Contact> attendees = new HashSet<>();
    contactManager.addFutureMeeting(attendees, pastDate);
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

  @Test(expected = IllegalArgumentException.class)
  public void testContactManager_addNewContactNameIsEmpty() {
    contactManager.addNewContact("", "Donuts");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testContactManager_addNewContactNotesIsEmpty() {
    contactManager.addNewContact("Homer", "");
  }

  @Test(expected = NullPointerException.class)
  public void testContactManager_getContactsNameIsNull() {
    contactManager.getContacts((String) null);
  }

  @Test
  public void testContactManager_getContactsName() {
    contactManager.addNewContact("Homer", "Donuts");
    contactManager.addNewContact("Marge", "Hmmmmm");
    contactManager.addNewContact("Bart", "Underachiever");
    contactManager.addNewContact("Lisa", "Precocious");
    contactManager.addNewContact("Maggie", "*suck*");
    Set<Contact> nameMa = contactManager.getContacts("Ma");
    Set<Contact> nameLisa = contactManager.getContacts("Lisa");
    Set<Contact> nameMoe = contactManager.getContacts("Moe");
    assertEquals(2, nameMa.size());
    assertEquals(1, nameLisa.size());
    assertEquals(0, nameMoe.size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testContactManager_getContactsIdIsIllegal() {
    contactManager.getContacts(-1);
  }

  @Test
  public void testContactManager_getContactsId() {
    contactManager.addNewContact("Homer", "Donuts");
    contactManager.addNewContact("Marge", "Hmmmmm");
    contactManager.addNewContact("Bart", "Underachiever");
    contactManager.addNewContact("Lisa", "Precocious");
    contactManager.addNewContact("Maggie", "*suck*");
    Set<Contact> oddNumbered = contactManager.getContacts(1, 3, 5);
    Set<Contact> evenNumbered = contactManager.getContacts(2, 4);
    assertEquals(3, oddNumbered.size());
    assertEquals(2, evenNumbered.size());
  }

  @Test
  public void flush() {
  }

}