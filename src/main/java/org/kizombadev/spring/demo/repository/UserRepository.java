package org.kizombadev.spring.demo.repository;

import org.kizombadev.spring.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
