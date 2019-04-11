package com.app.boot.jpa.dao;

import com.app.boot.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Anish
 */

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
