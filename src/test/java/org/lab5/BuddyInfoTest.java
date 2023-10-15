package org.lab5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests of BuddyInfo class.
 *  @author Jeremy Trendoff, 101160306
 */
public class BuddyInfoTest {

    /**
     * Test Buddy.
     */
    BuddyInfo testBuddy;

    /**
     * Set up before each test.
     */
    @Before
    public void setUp() {
        testBuddy = new BuddyInfo("Test", "Test");
    }

    /**
     * Test getName() method.
     */
    @Test
    public void getName() {
        assertSame("Test", testBuddy.getName());
    }

    /**
     * Test getPhoneNumber() method.
     */
    @Test
    public void getPhoneNumber() {
        assertSame("Test", testBuddy.getPhoneNumber());
    }

    /**
     * Test setName() method.
     */
    @Test
    public void setName() {
        assertSame("Test", testBuddy.getName());
        testBuddy.setName("New");
        assertSame("New", testBuddy.getName());
    }

    /**
     * Test setPhoneNumber() method.
     */
    @Test
    public void setPhoneNumber() {
        assertSame("Test", testBuddy.getPhoneNumber());
        testBuddy.setPhoneNumber("New");
        assertSame("New", testBuddy.getPhoneNumber());
    }
}