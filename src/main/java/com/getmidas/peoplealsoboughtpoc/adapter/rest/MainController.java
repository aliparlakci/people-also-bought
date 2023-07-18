package com.getmidas.peoplealsoboughtpoc.adapter.rest;

import com.getmidas.peoplealsoboughtpoc.application.service.MemberService;
import com.getmidas.peoplealsoboughtpoc.domain.model.PeopleAlsoBoughtResult;
import com.getmidas.peoplealsoboughtpoc.application.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequiredArgsConstructor
public class MainController {

    private final StockService stockService;
    private final MemberService memberService;

    @GetMapping("/v1/stocks/{stockUid}/people-also-bought")
    public List<PeopleAlsoBoughtResult> getPeopleAlsoBought(@PathVariable String stockUid) {
        return stockService.getPeopleAlsoBought(stockUid);
    }

    @PostMapping("/v1/stocks/{stockUid}")
    public void createStock(@PathVariable String stockUid, @RequestBody StockCreateRequest request) {
        stockService.createStock(stockUid, request);
    }

    @PostMapping("/v1/members/{memberUid}")
    public void createStock(@PathVariable String memberUid) {
        memberService.createMember(memberUid);
    }

    @PutMapping("/v1/members/{memberUid}/stocks/{stockUid}")
    public void memberBuysStock(@PathVariable String memberUid, @PathVariable String stockUid) {
        stockService.memberBuysStock(memberUid, stockUid);
    }

}
