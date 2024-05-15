package com.example.mda.userdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mda.userdb.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
