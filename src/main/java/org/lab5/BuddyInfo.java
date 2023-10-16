package org.lab5;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * The BuddyInfo Class containing the Name and Phone Number of your Buddy.
 * @author Jeremy Trendoff, 101160306
 */
@Entity
public class BuddyInfo {

    /**
     * Your Buddy's Name
     */
    private String name;

    /**
     * Your Buddy's Phone Number
     */
    private String phoneNumber;

    /**
     * Your Buddy's Address
     */
    private String address;

    /**
     * Buddy's ID.
     */
    private Long id;

    /**
     * Default Constructor. Sets default name and phone number.
     */
    public BuddyInfo() {
        this("AddName", "AddAddress", "AddNumber");
    }

    /**
     * Constructor. Build a new Buddy Info by setting a Name and Phone Number.
     * @param name String, The name of your buddy.
     * @param phoneNumber String, the phone number of your buddy.
     */
    public BuddyInfo(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets the id of this Player to the specified value.
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the id of this Buddy. The persistence provider should
     * autogenerate a unique id for new player objects.
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * Get your buddy's name.
     * @return String, your buddy's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get your buddy's phone number.
     * @return String, the phone number of your buddy.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get your Buddy's Address
     * @return String, the address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set your buddy's new name.
     * @param name String, your buddy's new name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set your buddy's new phone number.
     * @param phoneNumber String, your buddy's new number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Set the buddies address*
     * @param address String, address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Generated equals method for more accurate comparisons.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BuddyInfo)) return false;
        BuddyInfo buddyInfo = (BuddyInfo) o;
        return Objects.equals(getName(), buddyInfo.getName()) && Objects.equals(getPhoneNumber(), buddyInfo.getPhoneNumber());
    }

    /**
     * Generated hashcode method for more accurate comparisons.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhoneNumber());
    }

    /**
     * Provide a String representation of the buddy
     * @return String, the buddy's string representation.
     */
    @Override
    public String toString() {
        return "BuddyInfo{" +
                "name=" + name +
                ", phoneNumber=" + phoneNumber +
                ", address=" + address +
                '}';
    }
}
