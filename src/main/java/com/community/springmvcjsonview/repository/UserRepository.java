package com.community.springmvcjsonview.repository;

import com.community.springmvcjsonview.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}