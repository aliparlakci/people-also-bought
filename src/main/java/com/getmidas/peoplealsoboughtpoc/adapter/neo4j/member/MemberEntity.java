package com.getmidas.peoplealsoboughtpoc.adapter.neo4j.member;

import com.getmidas.peoplealsoboughtpoc.adapter.neo4j.stock.StockEntity;
import com.getmidas.peoplealsoboughtpoc.domain.model.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Node("Member")
public class MemberEntity {

    @Id
    @GeneratedValue
    private String id;

    @Property("member_uid")
    private String memberUid;

    @Relationship(type = "BUYS", direction = Relationship.Direction.OUTGOING)
    private Set<StockEntity> stocks = new HashSet<>();

    public Member toModel() {
        return Member.builder()
                .id(this.id)
                .memberUid(this.memberUid)
                .stocks(this.stocks.stream().map(StockEntity::toModel).toList())
                .build();
    }

}
