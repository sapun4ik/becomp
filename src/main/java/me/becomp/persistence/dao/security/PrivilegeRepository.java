package me.becomp.persistence.dao.security;

import me.becomp.persistence.model.security.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sapun4ik on 18.03.2018.
 */
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);

}
