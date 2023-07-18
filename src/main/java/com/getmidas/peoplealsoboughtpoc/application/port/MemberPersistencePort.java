package com.getmidas.peoplealsoboughtpoc.application.port;

import com.getmidas.peoplealsoboughtpoc.domain.model.Member;
import org.springframework.stereotype.Service;

@Service
public interface MemberPersistencePort {

    Member retrieveMember(String memberUid);

    void create(String memberUid);

}
