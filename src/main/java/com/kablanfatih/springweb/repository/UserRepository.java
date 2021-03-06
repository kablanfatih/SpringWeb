package com.kablanfatih.springweb.repository;

import com.kablanfatih.springweb.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
