package me.becomp.service.personal;

import me.becomp.persistence.dao.personal.PAccountRepository;
import me.becomp.persistence.model.personal.PAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sapun4ik on 24.04.2018.
 */
@Service()
@Transactional
public class PAccountService implements IPAccountService {
    @Autowired
    private PAccountRepository pAccountRepository;

    @Override
    public void addPAccount(PAccount pAccount) {
        pAccountRepository.saveAndFlush(pAccount);
    }
}
