package com.getmidas.peoplealsoboughtpoc.application.service;

import com.getmidas.peoplealsoboughtpoc.adapter.rest.StockCreateRequest;
import com.getmidas.peoplealsoboughtpoc.application.port.MemberPersistencePort;
import com.getmidas.peoplealsoboughtpoc.application.port.StockPersistencePort;
import com.getmidas.peoplealsoboughtpoc.domain.model.Member;
import com.getmidas.peoplealsoboughtpoc.domain.model.PeopleAlsoBoughtResult;
import com.getmidas.peoplealsoboughtpoc.domain.model.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockPersistencePort stockPersistencePort;
    private final MemberPersistencePort memberPersistencePort;

    public List<PeopleAlsoBoughtResult> getPeopleAlsoBought(String stockUid) {
        return stockPersistencePort.getPeopleAlsoBought(stockUid);
    }

    public void memberBuysStock(String memberUid, String stockUid) {
        Member member = memberPersistencePort.retrieveMember(memberUid);
        Stock stock = stockPersistencePort.retrieveStock(stockUid);
        stockPersistencePort.createBuysRelation(member.getMemberUid(), stock.getStockUid());
    }

    public void createStock(String stockUid, StockCreateRequest request) {
        String symbol = request.getSymbol();
        stockPersistencePort.create(stockUid, symbol);
    }

}
