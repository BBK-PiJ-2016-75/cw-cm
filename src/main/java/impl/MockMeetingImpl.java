package impl;

import spec.Contact;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by Dennis on 19/03/2017.
 */
public class MockMeetingImpl extends MeetingImpl {

  /**
   * dennis.
   *
   * @param id       den
   * @param date     den
   * @param contacts den
   */
  public MockMeetingImpl(int id, Calendar date, Set<Contact> contacts) {
    super(id, date, contacts);
  }
}
