package it.discovery.nosql.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author dzmitry.marudau
 * @since 2020.3
 */
@Data
@NoArgsConstructor
@Table(value = "users")
public class User {

    @PrimaryKey("user_id")
    private Long id;

    @Column("uname")
    private String username;
    @Column("fname")
    private String firstname;
    @Column("lname")
    private String lastname;

    public User(Long id) {
        this.setId(id);
    }
}
