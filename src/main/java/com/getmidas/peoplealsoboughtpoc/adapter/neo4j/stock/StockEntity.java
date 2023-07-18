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
    private String id;

    @Property("stock_uid")
    private String stockUid;

    @Property("name")
    private String symbol;

    public Stock toModel() {
        return Stock.builder()
                .id(this.id)
                .symbol(this.symbol)
                .stockUid(this.stockUid)
                .build();
    }

}


