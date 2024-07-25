package me.a8kj.rivlermc.clans.parent.utils;

/**
 * Represents a generic manager interface used for managing meta-data and
 * protecting data/classes.
 * 
 * This interface is designed to be polymorphic for various managers and handles
 * the registration process.
 */
public interface Manager {

    /**
     * Retrieves the meta-data associated with this manager.
     *
     * @return The meta-data.
     */
    MetaData getMetaData();

    /**
     * Sets the meta-data for this manager based on the provided type.
     * This method can be overridden to provide specific implementation details for
     * setting meta-data.
     *
     * @param type The type of data to set as meta-data.
     */
    default void setMetaData(Object type) {
    }
}
