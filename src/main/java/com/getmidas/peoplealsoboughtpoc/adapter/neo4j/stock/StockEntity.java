package com.getmidas.peoplealsoboughtpoc.adapter.neo4j.stock;

import com.getmidas.peoplealsoboughtpoc.domain.model.Stock;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Getter
@Setter
@Node("Stock")
public class StockEntity {

    @Id
    @Property("stock_uid")
    private String stockUid;

    @Property("name")
    private String stockSymbol;

    public Stock toModel() {
        return Stock.builder()
                .symbol(this.stockSymbol)
                .stockUid(this.stockUid)
                .build();
    }

}


