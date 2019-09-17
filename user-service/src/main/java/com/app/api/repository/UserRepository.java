package com.app.api.repository;

import com.app.api.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Anish Panthi
 */

public interface UserRepository extends CrudRepository<User, Long>, JpaRepository<User, Long> {

    User findByUsernameOrEmail(String username, String email);

    Optional<User> findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    Page<User> findAll(Pageable pageable);
}