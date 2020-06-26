package it.discovery.nosql.repository;

import it.discovery.nosql.BaseRedisTest;
import it.discovery.nosql.model.ShoppingCart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartRepositoryTest extends BaseRedisTest {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Test
    void saveCart_findOne_success() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId("10");
        shoppingCart.setCreated(LocalDateTime.now());
        shoppingCart.setBooks(List.of("1", "2"));

        shoppingCartRepository.save(shoppingCart);

        ShoppingCart old = shoppingCartRepository.findById("10").orElseThrow();
        assertEquals(2, old.getBooks().size());
    }
}
