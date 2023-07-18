package com.getmidas.peoplealsoboughtpoc.application.port;

import com.getmidas.peoplealsoboughtpoc.domain.model.PeopleAlsoBoughtResult;
import com.getmidas.peoplealsoboughtpoc.domain.model.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockPersistencePort {

    List<PeopleAlsoBoughtResult> getPeopleAlsoBought(String stockUid);

    Stock retrieveStock(String stockUid);

    void createBuysRelation(String memberUid, String stockUid);

    void create(String stockUid, String symbol);

}
