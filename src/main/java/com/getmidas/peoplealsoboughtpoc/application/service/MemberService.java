package com.getmidas.peoplealsoboughtpoc.application.service;

import com.getmidas.peoplealsoboughtpoc.application.port.MemberPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberPersistencePort memberPersistencePort;

    public void createMember(String memberUid) {
        memberPersistencePort.create(memberUid);
    }

}
