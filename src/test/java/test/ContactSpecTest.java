package test;

import impl.ContactImpl;
import org.junit.Before;
import org.junit.Test;
import spec.Contact;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ContactSpecTest {

  @Before
  public void setUp() {

  }

  @Test
  public void testContactConstructorName() {
    try {
      new ContactImpl(1, "name");
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testContactConstructorSetName() {
    Contact sue = new ContactImpl(1, "sue");
    assertEquals("sue", sue.getName());
  }

  @Test
  public void testContactConstructorNameNotes() {
    try {
      new ContactImpl(1, "name", "notes");
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testContactConstructorSetNameNotes() {
    Contact sue = new ContactImpl(1, "sue", "notes1");
    assertEquals("sue", sue.getName());
    assertEquals("notes1", sue.getNotes());
  }

  @Test
  public void testGetNotesNone() {
    Contact sue = new ContactImpl(1, "sue");
    assertEquals("", sue.getNotes());
  }

  @Test
  public void testAddNotesSingle() {
    Contact sue = new ContactImpl(1, "sue");
    sue.addNotes("notes1");
    assertEquals("notes1", sue.getNotes());
  }


  @Test
  public void testAddNotesMultiple() {
    Contact sue = new ContactImpl(1, "sue", "notes1");
    sue.addNotes("notes2");
    sue.addNotes("notes3");
    String returned = sue.getNotes();

    assertTrue(returned.contains("notes1"));
    assertTrue(returned.contains("notes2"));
    assertTrue(returned.contains("notes3"));
  }

  @Test
  public void testContactUniqueIds() {
    Contact jim = new ContactImpl(1, "jim");
    Contact mike = new ContactImpl(2, "mike");

    assertThat(jim.getId(), is(not(equalTo(mike.getId()))));
  }

}
