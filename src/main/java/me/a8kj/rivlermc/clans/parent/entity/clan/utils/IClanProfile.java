package me.a8kj.rivlermc.clans.parent.entity.clan.utils;

import java.util.List;

import me.a8kj.rivlermc.clans.parent.utils.SimpleCollectionManager;

/**
 * Represents a profile for a clan, providing its description and creation date.
 */
public interface IClanProfile {

    /**
     * Returns a list of description strings for the clan.
     *
     * @return A list of description strings for the clan.
     */
    List<String> getDescription();

    /**
     * Returns the timestamp of when the clan was created.
     *
     * @return The creation date of the clan.
     */
    Long getCreationDate();

    /**
     * Provides a manager for handling descriptions within the system.
     *
     * @return a {@link SimpleCollectionManager} instance for managing
     *         {@link String} descriptions.
     *         Returns null by default.
     */
    default SimpleCollectionManager<String> getDescriptionManager() {
        return null;
    }

}
