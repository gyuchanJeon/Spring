package com.ch10.repository;

import com.ch10.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReporitory extends JpaRepository<User, String> {
}
