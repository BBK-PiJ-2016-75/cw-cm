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
  public void testContactIdName_Constructor() throws Exception {
    try {
      new ContactImpl(1, "Homer");
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testContactIdName_GetIdGetName() throws Exception {
    ContactImpl marge = new ContactImpl(2, "Marge");
    assertEquals(2, marge.getId());
    assertEquals("Marge", marge.getName());
  }

  @Test
  public void testContactIdNameNotes_Constructor() throws Exception {
    try {
      new ContactImpl(3, "Bart", "Underachiever");
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testContactIdNameNotes_GetIdGetNameGetNotes() throws Exception {
    ContactImpl maggie = new ContactImpl(4, "Maggie", "Precocious");
    assertEquals(4, maggie.getId());
    assertEquals("Maggie", maggie.getName());
    assertEquals("Precocious", maggie.getNotes());
  }

  //  @Test
//  public void getNotes() throws Exception {
//  }

//  @Test
//  public void addNotes() throws Exception {
//  }

}