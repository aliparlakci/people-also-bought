package com.getmidas.peoplealsoboughtpoc.adapter.neo4j.stock;

import com.getmidas.peoplealsoboughtpoc.application.port.StockPersistencePort;
import com.getmidas.peoplealsoboughtpoc.domain.model.PeopleAlsoBoughtResult;
import com.getmidas.peoplealsoboughtpoc.domain.model.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockNeo4jJpaAdapter implements StockPersistencePort {

    private final StockRepository stockRepository;

    @Override
    public List<PeopleAlsoBoughtResult> getPeopleAlsoBought(String stockUid) {
        return stockRepository.getPeopleAlsoBought(stockUid);
    }

    @Override
    public Stock retrieveStock(String stockUid) {
        return stockRepository.findByStockUid(stockUid)
                .orElseThrow()
                .toModel();
    }

    @Override
    public void createBuysRelation(String memberUid, String stockUid) {
        stockRepository.createBuysRelation(memberUid, stockUid);
    }

    @Override
    public void create(String stockUid, String symbol) {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setSymbol(symbol);
        stockEntity.setStockUid(stockUid);
        stockRepository.save(stockEntity);
    }

}
