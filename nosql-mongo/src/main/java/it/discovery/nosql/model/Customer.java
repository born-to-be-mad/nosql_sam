package it.discovery.nosql.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Document(collection = "customers")
@ToString
public class Customer extends BaseEntity {

    private String login;

    private String password;

    private String name;

    private Contact contact;
}
