package com.getmidas.peoplealsoboughtpoc.adapter.neo4j.member;

import com.getmidas.peoplealsoboughtpoc.application.port.MemberPersistencePort;
import com.getmidas.peoplealsoboughtpoc.domain.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberNeo4jJpaAdapter implements MemberPersistencePort {

    private final MemberRepository memberRepository;

    @Override
    public Member retrieveMember(String memberUid) {
        return memberRepository.findByMemberUid(memberUid)
                .orElseThrow()
                .toModel();
    }

    @Override
    public void create(String memberUid) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberUid(memberUid);
        memberRepository.save(memberEntity);
    }

}
