package me.becomp.persistence.dao.security;

import me.becomp.persistence.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sapun4ik on 18.03.2018.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Override
    void delete(User user);

}
