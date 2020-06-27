package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order extends BaseEntity {

    private Book book;

    private int amount;
}
