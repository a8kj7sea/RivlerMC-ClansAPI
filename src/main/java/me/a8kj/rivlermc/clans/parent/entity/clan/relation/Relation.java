package me.a8kj.rivlermc.clans.parent.entity.clan.relation;

import java.util.Set;

import com.google.common.collect.Sets;

import lombok.Getter;
import me.a8kj.rivlermc.clans.parent.utils.SimpleCollectionManager;

/**
 * A generic abstract class representing a relationship with a set of related
 * entities.
 *
 * @param <T> The type of elements in the relation set.
 */
@Getter
public abstract class Relation<T> {

    /**
     * Metadata associated with the relationship.
     */
    private String metaData;

    /**
     * A set of related entities.
     */
    private final Set<T> relationSet = Sets.newHashSet();

    /**
     * @deprecated
     *             This field is deprecated and will be removed in a future version.
     *             Use the new {@link #getRelationsManager()} method to manage
     *             relations instead.
     *
     * @see #getRelationsManager()
     */
    @Deprecated
    private final SimpleCollectionManager<T> relationsManager = new SimpleCollectionManager<>(relationSet);


    /**
     * Constructs a Relation instance with the specified metadata.
     *
     * @param metaData Metadata associated with the relationship.
     */
    public Relation(String metaData) {
        this.metaData = metaData;
        setRelationValues(relationSet);
    }

    /**
     * Sets the values in the relation set.
     * This method must be implemented by subclasses to define how the set values
     * are determined.
     *
     * @param set The set of related entities to be populated.
     */
    public abstract void setRelationValues(Set<T> set);
}
