package me.becomp.service.l10n;


import me.becomp.persistence.dao.l10n.MessageResourceRepository;
import me.becomp.persistence.model.l10n.MessageResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sapun4ik on 03.06.2017.
 */
@Service("messageResourceService")
@Transactional
public class MessageResourceServiceImpl implements MessageResourceService {
    @Autowired
    private MessageResourceRepository repository;
    @Override
    public List<MessageResource> findAll() {
        return repository.findAll();
    }
}
