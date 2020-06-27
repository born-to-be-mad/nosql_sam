package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter
@Table("orders")
public class Order extends BaseEntity {

    private String bookId;

    private String customerId;

    private int amount;
}
