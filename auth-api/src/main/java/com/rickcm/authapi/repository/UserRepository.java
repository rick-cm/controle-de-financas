package com.rickcm.authapi.repository;

import com.rickcm.authapi.entity.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

@EnableScan
public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByUuid(UUID uuid);
    Optional<User> findByEmail(String email);
}