
package com.example.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.api.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long> { 
    List<User> findByName(String name); 
}
