package com.ch07.repository;

import com.ch07.entity.User4;
import com.ch07.entity.User5;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User5Repository extends JpaRepository<User5, String> {
}
