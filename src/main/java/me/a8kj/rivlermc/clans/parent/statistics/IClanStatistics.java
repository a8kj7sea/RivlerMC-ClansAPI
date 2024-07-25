package me.a8kj.rivlermc.clans.parent.statistics;

import me.a8kj.rivlermc.clans.parent.entity.clan.IClan;

/**
 * Interface for managing and manipulating clan statistics.
 */
public interface IClanStatistics {

    /**
     * Retrieves the statistic value for a specific clan and statistic type.
     *
     * @param clan               The clan for which to get the statistic.
     * @param clanStatisticsType The type of statistic to retrieve.
     * @return The value of the statistic for the given clan and type.
     */
    int getClanStatistics(IClan clan, ClanStatisticsType clanStatisticsType);

    /**
     * Sets the statistic value for a specific clan and statistic type.
     *
     * @param clan               The clan for which to set the statistic.
     * @param clanStatisticsType The type of statistic to set.
     * @param amountToSet        The value to set for the statistic.
     */
    void setClanStatistics(IClan clan, ClanStatisticsType clanStatisticsType, int amountToSet);

    /**
     * Adds a specified amount to a clan's statistic.
     *
     * @param clan               The clan to update.
     * @param clanStatisticsType The type of statistic to update.
     * @param amountToAdd        The amount to add to the statistic.
     */
    default void addClanStatistics(IClan clan, ClanStatisticsType clanStatisticsType, int amountToAdd) {
        setClanStatistics(clan, clanStatisticsType,
                getClanStatistics(clan, clanStatisticsType) + Math.abs(amountToAdd));
    }

    /**
     * Removes a specified amount from a clan's statistic.
     * If the amount to remove exceeds the current statistic value, it sets the
     * value to 0.
     *
     * @param clan               The clan to update.
     * @param clanStatisticsType The type of statistic to update.
     * @param amountToRemove     The amount to remove from the statistic.
     */
    default void removeClanStatistics(IClan clan, ClanStatisticsType clanStatisticsType, int amountToRemove) {
        int clanData = getClanStatistics(clan, clanStatisticsType);

        if (Math.abs(amountToRemove) >= clanData) {
            setClanStatistics(clan, clanStatisticsType, 0);
        } else {
            setClanStatistics(clan, clanStatisticsType, clanData - Math.abs(amountToRemove));
        }
    }

    /**
     * Returns the default number of points assigned to a new clan.
     *
     * @return The default points.
     */
    int getDefaultPoints();

    /**
     * Checks if statistics exist for a specific clan.
     *
     * @param clan The clan to check.
     * @return true if statistics exist for the clan, false otherwise.
     */
    boolean exist(IClan clan);

    /**
     * Sets up initial statistics for a new clan.
     * Assigns default points to the clan's points statistic and 0 for all other
     * statistics.
     *
     * @param clan The clan to set up.
     */
    default void setupNewClan(IClan clan) {
        if (exist(clan)) {
            return;
        }

        for (ClanStatisticsType clanStatisticsType : ClanStatisticsType.values()) {
            if (clanStatisticsType == ClanStatisticsType.POINTS) {
                setClanStatistics(clan, clanStatisticsType, getDefaultPoints());
            } else {
                setClanStatistics(clan, clanStatisticsType, 0);
            }
        }
    }

    /**
     * Enumeration representing the types of clan statistics.
     */
    public enum ClanStatisticsType {
        KILLS, DEATHS, POINTS;
    }
}
