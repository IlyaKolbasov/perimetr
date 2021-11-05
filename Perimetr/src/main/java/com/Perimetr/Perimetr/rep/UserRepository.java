package com.Perimetr.Perimetr.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Perimetr.Perimetr.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
