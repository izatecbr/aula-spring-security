package com.izaplay.aula.spring.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query("SELECT e FROM UserEntity e JOIN FETCH e.roles WHERE e.username= (:username)")
    public UserEntity findByUsername(@Param("username") String username);
}
