package test;

import impl.ContactImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dennis on 18/03/2017.
 */
public class ContactImplTest {
  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

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
    ContactImpl marge = new ContactImpl(2, "Marge");
    assertEquals(2, marge.getId());
    assertEquals("Marge", marge.getName());
  }

  @Test
  public void testContactIdNameNotes_Constructor() {
    try {
      new ContactImpl(3, "Bart", "Underachiever");
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testContactIdNameNotes_GetIdGetNameGetNotes() {
    ContactImpl maggie = new ContactImpl(4, "Maggie", "Precocious");
    assertEquals(4, maggie.getId());
    assertEquals("Maggie", maggie.getName());
    assertEquals("Precocious", maggie.getNotes());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testContactIdName_IdIsZero() {
    ContactImpl homer = new ContactImpl(0, "Homer");;
  }

  @Test(expected = IllegalArgumentException.class)
  public void testContactIdName_IdLessThanZero() {
    ContactImpl homer = new ContactImpl(-1, "Marge");;
  }

  @Test(expected = IllegalArgumentException.class)
  public void testContactIdNameNotes_IdIsZero() {
    ContactImpl homer = new ContactImpl(0, "Bart", "Underachiever");;
  }

  @Test(expected = IllegalArgumentException.class)
  public void testContactIdNameNotes_IdLessThanZero() {
    ContactImpl homer = new ContactImpl(-1, "Maggie", "Precocious");;
  }

  @Test(expected = NullPointerException.class)
  public void testContactIdName_NameIsNull() {
    ContactImpl homer = new ContactImpl(1, null);
  }

  @Test(expected = NullPointerException.class)
  public void testContactIdNameNotes_NameIsNull() {
    ContactImpl marge = new ContactImpl(2, null, "Hmmmmm");
  }

  @Test(expected = NullPointerException.class)
  public void testContactIdNameNotes_NotesIsNull() {
    ContactImpl marge = new ContactImpl(2, "Marge", null);
  }

  //  @Test
//  public void getNotes() throws Exception {
//  }

//  @Test
//  public void addNotes() throws Exception {
//  }
}