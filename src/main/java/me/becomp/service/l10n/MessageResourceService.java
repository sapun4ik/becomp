package me.becomp.service.l10n;


import me.becomp.persistence.model.l10n.MessageResource;

import java.util.List;

/**
 * Created by Sapun4ik on 03.06.2017.
 */
public interface MessageResourceService {
    List<MessageResource> findAll();
}
