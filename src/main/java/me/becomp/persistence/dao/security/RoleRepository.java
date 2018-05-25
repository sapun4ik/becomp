package me.becomp.persistence.dao.security;

import me.becomp.persistence.model.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sapun4ik on 18.03.2018.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}

