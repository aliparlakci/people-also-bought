package com.getmidas.peoplealsoboughtpoc.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeopleAlsoBoughtResult {

    private String stockUid;

    private String stockSymbol;

    private Long buyCount;

}
