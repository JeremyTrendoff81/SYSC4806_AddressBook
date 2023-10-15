package org.lab4;

import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    BuddyInfo findById(long id);
    BuddyInfo findByName(String name);
    BuddyInfo findByPhoneNumber(String phoneNumber);
}
