package com.getmidas.peoplealsoboughtpoc.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeopleAlsoBoughtResult {

    private String stockUid;

    private String symbol;

    private Long buyCount;

}
