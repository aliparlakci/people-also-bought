package com.getmidas.peoplealsoboughtpoc.adapter.neo4j.stock;

import com.getmidas.peoplealsoboughtpoc.domain.model.PeopleAlsoBoughtResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends Neo4jRepository<StockEntity, String> {

    @Query("MATCH (s1:Stock {stock_uid: $stockUid})<-[:BUYS]-(t:Member)-[:BUYS]->(s2:Stock) RETURN s2.stock_uid AS stock_uid, s2.name AS stockSymbol, COUNT(DISTINCT t) AS buyCount ORDER BY buyCount DESC LIMIT 5")
    List<PeopleAlsoBoughtResult> getPeopleAlsoBought(String stockUid);

    Optional<StockEntity> findByStockUid(String stockUid);

    @Query("MATCH(m: Member {member_uid: $memberUid}) MATCH(s: Stock {stock_uid: $stockUid}) MERGE(m)-[:BUYS]->(s)")
    void createBuysRelation(String memberUid, String stockUid);

}