package it.discovery.nosql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Translation holder.
 *
 * @author dzmitry.marudau
 * @since 2020.3
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Translation {
    private String name;
    private String locale;
}

