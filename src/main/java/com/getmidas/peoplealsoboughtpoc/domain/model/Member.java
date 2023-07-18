package com.getmidas.peoplealsoboughtpoc.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Member {

    private String id;

    private String memberUid;

    private List<Stock> stocks;

}
