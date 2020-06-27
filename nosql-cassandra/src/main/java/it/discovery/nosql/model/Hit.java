package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Hit {
    private String ip;

    private String referer;

    private Book book;

    private LocalDateTime viewed;

    private String browser;

    private boolean mobile;
}
