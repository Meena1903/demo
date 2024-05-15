package com.example.mda.accountdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mda.accountdb.entity.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
