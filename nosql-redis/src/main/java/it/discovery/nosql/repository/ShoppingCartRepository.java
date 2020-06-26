package it.discovery.nosql.repository;

import org.springframework.data.keyvalue.repository.KeyValueRepository;

import it.discovery.nosql.model.ShoppingCart;

/**
 * TODO
 *
 * @author dzmitry.marudau
 * @since 2020.3
 */
public interface ShoppingCartRepository extends KeyValueRepository<ShoppingCart, String> {
}
