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
      new ContactImpl(0, "Homer");
    } catch (Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testContactIdName_GetIdGetName() throws Exception {
    ContactImpl marge = new ContactImpl(1, "Marge");
    assertEquals(1, marge.getId());
    assertEquals("Marge", marge.getName());
  }

//  @Test
//  public void getId() throws Exception {
//  }

//  @Test
//  public void getName() throws Exception {
//  }

//  @Test
//  public void getNotes() throws Exception {
//  }

//  @Test
//  public void addNotes() throws Exception {
//  }

}