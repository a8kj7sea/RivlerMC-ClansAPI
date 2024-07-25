package me.a8kj.rivlermc.clans.parent.statistics;

import me.a8kj.rivlermc.clans.parent.entity.clan.IClan;

/**
 * Represents a top clan, which includes information about the clan, its
 * statistics amount,
 * and its position in a sorted list of clans.
 */
public interface ITopClan {

    /**
     * Returns the clan associated with this top clan entry.
     *
     * @return The clan.
     */
    IClan getClan();

    /**
     * Returns the amount of statistics associated with the clan.
     *
     * @return The statistics amount.
     */
    int getClanStatisticsAmount();

    /**
     * Returns the position of the clan in the sorted list of top clans.
     *
     * @return The position of the clan.
     */
    int getPosition();
}
