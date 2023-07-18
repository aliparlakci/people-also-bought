package com.getmidas.peoplealsoboughtpoc.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Stock {

    private String id;

    private String symbol;

    private String stockUid;
}
