package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;
import java.util.List;

@RedisHash(timeToLive = 30 * 60, value = "cart")
@Getter
@Setter
public class ShoppingCart {
    @Id
    private String id;

    private LocalDateTime created;

    private List<String> books;
}
