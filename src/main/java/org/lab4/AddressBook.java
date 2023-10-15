package org.lab4;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The AddressBook class containing a list of buddies you can update.
 * @author Jeremy Trendoff, 101160306
 */
@Entity
public class AddressBook {

    /**
     * Your list of buddies.
     */
    private List<BuddyInfo> buddies;

    /**
     * AddressBook ID.
     */
    private Long id;

    /**
     * Default constructor. Empty list created.
     */
    public AddressBook() {
        this(new ArrayList<>());
    }

    /**
     * Create a new address book with some buddies.
     * @param buddies ArrayList, buddies to add.
     */
    public AddressBook(ArrayList<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    /**
     * Add a new buddy to your address book.
     * @param name String, Buddy's Name.
     * @param phoneNumber String, Buddy's Phone Number.
     * @return True if the buddy was added.
     */
    public boolean addBuddy(String name, String phoneNumber) {
        BuddyInfo buddyToAdd = new BuddyInfo(name, phoneNumber);
        return buddies.add(buddyToAdd);
    }

    /**
     * Remove a Buddy.
     * @return True if a buddy was removed.
     */
    public boolean removeBuddy(BuddyInfo buddyInfo) {
        return buddies.remove(buddyInfo);
    }

    /**
     * Update a buddy's name.
     * @param currentName String, the current name of your buddy.
     * @param newName String, the buddy's new name.
     */
    public void updateBuddyName(String currentName, String newName) {
        for (BuddyInfo buddy : buddies) {
            if (Objects.equals(buddy.getName(), currentName)) {
                buddy.setName(newName);
            }
        }
    }

    /**
     * Update a buddy's name.
     * @param currentName String, the current name of your buddy.
     * @param newPhoneNumber String, the buddy's new number.
     */
    public void updateBuddyPhoneNumber(String currentName, String newPhoneNumber) {
        for (BuddyInfo buddy : buddies) {
            if (Objects.equals(buddy.getName(), currentName)) {
                buddy.setPhoneNumber(newPhoneNumber);
            }
        }
    }

    /**
     * Set ID of address book.
     * @param id Long, id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get id of address book.
     * @return Long, the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * Get the list of buddies.
     * @return ArrayList, the list of buddies.
     */
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    /**
     * Set the buddies list.
     * @param buddies ArrayList, list of buddies.
     */
    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    /**
     * Generated toString for better printed description of object.
     */
    @Override
    public String toString() {
        return "AddressBook{" +
                "buddies=" + buddies +
                '}';
    }
}
