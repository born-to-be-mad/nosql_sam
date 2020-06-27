package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public abstract class BaseEntity {
    @Id
    private String id;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime modified;

    public BaseEntity() {
        id = UUID.randomUUID().toString();
    }
}
