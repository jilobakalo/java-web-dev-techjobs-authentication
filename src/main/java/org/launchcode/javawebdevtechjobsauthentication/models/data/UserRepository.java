package org.launchcode.javawebdevtechjobsauthentication.models.data;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    User findByUsername(String username);
}
