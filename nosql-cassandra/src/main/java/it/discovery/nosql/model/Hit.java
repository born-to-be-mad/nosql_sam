package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Table("hits")
/**
 * CREATE TABLE hits(id text,customerId text, bookId text, viewed timestamp, ip text, PRIMARY KEY(bookId, customerId));
 */
public class Hit {
    @Id
    private String id;

    private String ip;

    private String referer;

    private String bookId;

    private String customerId;

    private LocalDateTime viewed;

    private String browser;

    private boolean mobile;

    public Hit() {
        id = UUID.randomUUID().toString();
    }
}
