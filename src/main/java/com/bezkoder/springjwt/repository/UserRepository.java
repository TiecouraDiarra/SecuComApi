package com.bezkoder.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.User;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  /*@Modifying
  @Transactional
  @Query(value = "INSERT INTO users (email,password,username) VALUES ('tiec@c.com', 'tiec1234', 'tiec');",nativeQuery = true)
  void creationUsers();


  @Modifying
  @Transactional
  @Query(value = "INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('1', '1')",nativeQuery = true)
  void AddRoleUser();*/

  /*@Modifying
  @Transactional
  @Query(value = "UPDATE user_roles SET user_id = 1, role_id = 1; ",nativeQuery = true)
  void AddRoleUser();*/
}
