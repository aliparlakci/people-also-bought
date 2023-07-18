package com.getmidas.peoplealsoboughtpoc.adapter.neo4j.member;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface MemberRepository extends Neo4jRepository<MemberEntity, String> {

    Optional<MemberEntity> findByMemberUid(String memberUid);

}