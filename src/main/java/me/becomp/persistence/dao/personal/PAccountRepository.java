package me.becomp.persistence.dao.personal;

import me.becomp.persistence.model.personal.PAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sapun4ik on 24.04.2018.
 */
public interface PAccountRepository extends JpaRepository<PAccount, Long> {
}
