package com.burn.com.burn.repository;

import com.burn.com.burn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * User repository class, contains all the DB related operations and access from here
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * Custom query made for getting the user based on the username
     * @param username username
     * @return User object
     */
    @Query("from User u where u.username=:username")
    User findByUsername(@Param("username") String username);
}
