package com.burn.com.burn.repository;

import com.burn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<User, Integer> {
    @Query("from User u where u.username=:username")
    User findByUsername(@Param("username") String username);
}
