package com.shardulcode.fullstackbackend.repository;

import com.shardulcode.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<User, Long> {

}
