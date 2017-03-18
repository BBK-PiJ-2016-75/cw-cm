package test;

import impl.ContactImpl;
import org.junit.Test;
import spec.Contact;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests the constructor and the methods of the ContactImpl class.
 */
public class ContactImplTest {

  @Test
  public void testContactIdName_Constructor() {
    try {
      new ContactImpl(1, "Homer");
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testContactIdName_GetIdGetName() {
    Contact marge = new ContactImpl(2, "Marge");
    assertEquals(2, marge.getId());
    assertEquals("Marge", marge.getName());
  }

  @Test
  public void testContactIdNameNotes_Constructor() {
    try {
      new ContactImpl(1, "Bart", "Underachiever");
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testContactIdNameNotes_GetIdGetNameGetNotes() {
    Contact maggie = new ContactImpl(2, "Maggie", "Precocious");
    assertEquals(2, maggie.getId());
    assertEquals("Maggie", maggie.getName());
    assertEquals("Precocious", maggie.getNotes());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testContactIdName_IdIsZero() {
    Contact homer = new ContactImpl(0, "Homer");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testContactIdName_IdLessThanZero() {
    Contact homer = new ContactImpl(-1, "Marge");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testContactIdNameNotes_IdIsZero() {
    Contact homer = new ContactImpl(0, "Bart", "Underachiever");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testContactIdNameNotes_IdLessThanZero() {
    Contact homer = new ContactImpl(-1, "Maggie", "Precocious");
  }

  @Test(expected = NullPointerException.class)
  public void testContactIdName_NameIsNull() {
    Contact homer = new ContactImpl(1, null);
  }

  @Test(expected = NullPointerException.class)
  public void testContactIdNameNotes_NameIsNull() {
    Contact marge = new ContactImpl(2, null, "Hmmmmm");
  }

  @Test(expected = NullPointerException.class)
  public void testContactIdNameNotes_NotesIsNull() {
    Contact marge = new ContactImpl(2, "Marge", null);
  }

  @Test
  public void testContactIdName_GetNotes() {
    Contact homer = new ContactImpl(1, "Homer");
    assertEquals("", homer.getNotes());
  }

  @Test
  public void testContactIdNameNotes_GetNotes() {
    Contact marge = new ContactImpl(2, "Marge", "Hmmmmm");
    assertEquals("Hmmmmm", marge.getNotes());
  }

  @Test
  public void testContact_AddNote() {
    Contact bart = new ContactImpl(1, "Bart");
    Contact maggie = new ContactImpl(2, "Maggie", "Precocious");
    bart.addNotes("Underachiever");
    maggie.addNotes("Saxophonist");
    assertEquals("Underachiever", bart.getNotes());
    assertEquals("Precocious, Saxophonist", maggie.getNotes());
  }

  @Test
  public void testContact_AddNotes() {
    Contact bart = new ContactImpl(1, "Bart");
    Contact maggie = new ContactImpl(2, "Maggie", "Precocious");
    bart.addNotes("Underachiever");
    bart.addNotes("and proud of it, man!");
    maggie.addNotes("Saxophonist");
    maggie.addNotes("and Vegetarian.");
    assertEquals("Underachiever, and proud of it, man!", bart.getNotes());
    assertEquals("Precocious, Saxophonist, and Vegetarian.", maggie.getNotes());
  }
}
