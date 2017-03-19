package test;

import impl.ContactImpl;
import impl.FutureMeetingImpl;
import org.junit.Before;
import org.junit.Test;
import spec.Contact;

import java.util.Calendar;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests the constructor of the FutureMeetingImpl class.
 */
public class FutureMeetingImplTest {
  private Calendar futureDate;
  private HashSet<Contact> contacts;

  @Before
  public void setUp() {
    futureDate = Calendar.getInstance();
    futureDate.add(Calendar.YEAR, 1);
    contacts = new HashSet<Contact>();
    contacts.add(new ContactImpl(1, "Homer"));
    contacts.add(new ContactImpl(2, "Marge", "Hmmmmm"));
  }

  @Test
  public void testFutureMeeting_Constructor() {
    try {
      new FutureMeetingImpl(1, futureDate, contacts);
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testFutureMeeting_GetIdDateContacts() {
    FutureMeetingImpl futureMeeting = new FutureMeetingImpl(1, futureDate, contacts);
    assertEquals(1, futureMeeting.getId());
    assertEquals(futureDate, futureMeeting.getDate());
    assertEquals(contacts, futureMeeting.getContacts());
  }
}
