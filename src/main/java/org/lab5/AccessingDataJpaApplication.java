package org.lab5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
        return (args) -> {
            // Set up a list of buddies.
            ArrayList<BuddyInfo> buddies = new ArrayList<>();
            buddies.add(new BuddyInfo("Steve", "613-555-1111"));
            buddies.add(new BuddyInfo("John", "613-555-2222"));
            buddies.add(new BuddyInfo("Mary", "613-555-3333"));
            buddies.add(new BuddyInfo("Kate", "613-555-4444"));
            buddies.add(new BuddyInfo("David", "613-555-5555"));

            // Set the AddressBook
            AddressBook addressBook = new AddressBook();
            for (BuddyInfo buddyInfo1 : buddies) {
                addressBook.getBuddies().add(buddyInfo1);
            }

            // Save the AddressBook
            addressBookRepository.save(addressBook);

//            // Fetch the AddressBook by ID
//            AddressBook addressBook1 = addressBookRepository.findById(1L);
//            log.info("AddressBook found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(addressBook1.toString());
//            log.info("");
//
//            /*
//            * When using this line, buddies must be persisted first before address book. Then, in address book
//            * change the cascade type to MERGE.
//            */
//
//            // Save the BuddyInfo buddies.
//            buddyInfoRepository.saveAll(buddies);
//
//            // Fetch all buddies
//            log.info("BuddyInfo's found with findAll():");
//            log.info("-------------------------------");
//            for (BuddyInfo buddyInfo : buddyInfoRepository.findAll()) {
//                log.info(buddyInfo.toString());
//            }
//            log.info("");
//
//            // Fetch Individual Buddy By ID
//            BuddyInfo buddyInfo = buddyInfoRepository.findById(1L);
//            log.info("Buddy found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(buddyInfo.toString());
//            log.info("");
//
//            // Fetch Individual Buddy By Name
//            buddyInfo = buddyInfoRepository.findByName("Mary");
//            log.info("Buddy found with findByName('Mary'):");
//            log.info("--------------------------------");
//            log.info(buddyInfo.toString());
//            log.info("");
//
//
//            // Fetch Individual Buddy By Phone Number
//            buddyInfo = buddyInfoRepository.findByPhoneNumber("613-555-5555");
//            log.info("Buddy found with findByPhoneNumber('613-555-5555'):");
//            log.info("--------------------------------");
//            log.info(buddyInfo.toString());
//            log.info("");
        };
    }
}
