package it.discovery.nosql;

import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.Neo4jContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataNeo4jTest
@Testcontainers
public abstract class BaseNeo4jTest {

    @Container
    static Neo4jContainer neo4j = new Neo4jContainer()
            .withAdminPassword("admin");

    @DynamicPropertySource
    static void neo4jProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.neo4j.uri", () ->
                "bolt://neo4j:admin@localhost:" + neo4j.getMappedPort(7687));
    }
}
