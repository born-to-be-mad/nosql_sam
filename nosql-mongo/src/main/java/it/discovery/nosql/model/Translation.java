package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Translation holder.
 *
 * @author dzmitry.marudau
 * @since 2020.3
 */
@Getter
@Setter
public class Translation {
    private String text;
    private String locale;
}

