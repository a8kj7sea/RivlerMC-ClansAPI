package me.a8kj.rivlermc.clans.parent.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents metadata used to distinguish between objects and provide
 * additional details about them.
 */
@AllArgsConstructor
@Data
public class MetaData {

    /**
     * The type or additional information associated with the metadata.
     */
    private Object type;
}
