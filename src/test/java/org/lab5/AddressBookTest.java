package org.lab5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Address Book Tests
 * @author Jeremy Trendoff, 101160306
 */
public class AddressBookTest {

    /**
     * Test address book.
     */
    private AddressBook addressBook;

    /**
     * Setup before each test.
     */
    @Before
    public void setup() {
        addressBook = new AddressBook();

        addressBook.addBuddy("Steve", "613-555-1111");
        addressBook.addBuddy("John", "613-555-2222");
        addressBook.addBuddy("Mary", "613-555-3333");
        addressBook.addBuddy("Kate", "613-555-4444");
        addressBook.addBuddy("David", "613-555-5555");
    }

    /**
     * Test addBuddy() method.
     */
    @Test
    public void addBuddy() {
        assertTrue(addressBook.addBuddy("Test", "Test"));
        assertTrue(addressBook.getBuddies().contains(new BuddyInfo("Test", "Test")));
        System.out.println(addressBook);
    }

    /**
     * Test removeBuddy() method.
     */
    @Test
    public void removeBuddy() {
        assertTrue(addressBook.removeBuddy(new BuddyInfo("Steve", "613-555-1111")));
        System.out.println(addressBook);
    }

    /**
     * Test updateBuddyName() method.
     */
    @Test
    public void updateBuddyName() {
        addressBook.updateBuddyName("Steve", "Adam");
        assertTrue(addressBook.getBuddies().contains(new BuddyInfo("Adam", "613-555-1111")));
        System.out.println(addressBook);
    }

    /**
     * Test updateBuddyPhoneNumber() method.
     */
    @Test
    public void updateBuddyPhoneNumber() {
        addressBook.updateBuddyPhoneNumber("Steve", "647-555-1111");
        assertTrue(addressBook.getBuddies().contains(new BuddyInfo("Steve", "647-555-1111")));
        System.out.println(addressBook);
    }
}