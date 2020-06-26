package it.discovery.nosql.model;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author dzmitry.marudau
 * @since 2020.3
 */
@RedisHash(timeToLive = 30 * 60, value = "cart")
@Getter
@Setter
public class ShoppingCart {

    @Id
    private String id;

    @CreatedDate
    private LocalDateTime created;

    private List<String> books;

}
