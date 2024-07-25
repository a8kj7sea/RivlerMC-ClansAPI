package me.a8kj.rivlermc.clans.parent.statistics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import me.a8kj.rivlermc.clans.parent.statistics.IClanStatistics.ClanStatisticsType;

/**
 * Represents the prestige system for a clan, including its statistics type,
 * name, and color.
 */
public interface IPrestige {

    /**
     * Returns the type of clan statistic associated with this prestige.
     *
     * @return The statistic type for this prestige.
     */
    ClanStatisticsType getClanStatisticsType();

    /**
     * Returns the name of the prestige.
     *
     * @return The name of the prestige.
     */
    String getName();

    /**
     * Returns the color associated with the prestige.
     *
     * @return The color of the prestige.
     */
    String getColor();

    /**
     * Returns the display name of the prestige, combining its color and name.
     *
     * @return The display name of the prestige.
     */
    default String getDisplayName() {
        return getColor() + getName();
    }

    /**
     * Returns the PrestigeRequirements.
     *
     * @return The Prestige Requirements.
     */
    public PrestigeRequirements getPrestigeRequirements();

    /**
     * Represents the requirements for a prestige level, including minimum and
     * maximum values.
     */
    @AllArgsConstructor
    @Getter
    @Builder
    public class PrestigeRequirements {
        private int min;
        private int max;
    }

    /**
     * Enumeration representing the types of prestige changes.
     */
    public enum PrestigeChangeType {
        /**
         * Represents an upgrade in prestige level.
         */
        UPGRADE,

        /**
         * Represents a downgrade in prestige level.
         */
        DOWNGRADE;
    }
}
