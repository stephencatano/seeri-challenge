package com.startup.seerichallenge.repositories;


import com.startup.seerichallenge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String marca);
}
