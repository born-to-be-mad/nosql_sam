package it.discovery.nosql;

import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * TODO
 *
 * @author dzmitry.marudau
 * @since 2020.3
 */
@DataRedisTest
@Testcontainers
public class BaseRedisTest {

    @Container
    static GenericContainer redis = new GenericContainer("redis:6").withExposedPorts(6379);

    @DynamicPropertySource
    static void redisProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.redis.port", () -> redis.getMappedPort(6379));
    }
}
