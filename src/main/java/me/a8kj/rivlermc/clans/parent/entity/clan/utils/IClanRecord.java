package me.a8kj.rivlermc.clans.parent.entity.clan.utils;

import me.a8kj.rivlermc.clans.parent.statistics.IClanStatistics.ClanStatisticsType;

/**
 * Represents the record of a clan, including its statistics such as kills,
 * deaths, and points.
 * Provides methods to get and set clan statistics, as well as to modify them.
 */
public interface IClanRecord {

    /**
     * Retrieves the total number of kills recorded for the clan.
     *
     * @return The number of kills.
     */
    public int getKills();

    /**
     * Retrieves the total number of deaths recorded for the clan.
     *
     * @return The number of deaths.
     */
    public int getDeaths();

    /**
     * Retrieves the total number of points recorded for the clan.
     *
     * @return The number of points.
     */
    public int getPoints();

    /**
     * Retrieves the amount of a specific clan statistic based on the provided type.
     *
     * @param clanStatisticsType The type of the clan statistic.
     * @return The amount of the specified statistic.
     */
    public int getClanStatisticsAmount(ClanStatisticsType clanStatisticsType);

    /**
     * Sets the amount of a specific clan statistic based on the provided type.
     *
     * @param clanStatisticsType The type of the clan statistic.
     * @param amount             The new amount to set for the statistic.
     * @return The previous amount of the statistic.
     */
    public int setClanStatisticsAmount(ClanStatisticsType clanStatisticsType, int amount);

    /**
     * Adds a specified amount to a specific clan statistic. The amount is added to
     * the current value.
     *
     * @param clanStatisticsType The type of the clan statistic.
     * @param amount             The amount to add.
     */
    default public void addClanStatistics(ClanStatisticsType clanStatisticsType, int amount) {
        setClanStatisticsAmount(clanStatisticsType, getClanStatisticsAmount(clanStatisticsType) + Math.abs(amount));
    }

    /**
     * Removes a specified amount from a specific clan statistic. The amount is
     * subtracted from the current value.
     * If the amount to be removed exceeds the current value, the statistic is set
     * to zero.
     *
     * @param clanStatisticsType The type of the clan statistic.
     * @param amount             The amount to remove.
     */
    default public void removeClanStatistics(ClanStatisticsType clanStatisticsType, int amount) {
        int currentStats = getClanStatisticsAmount(clanStatisticsType);

        if (Math.abs(amount) >= currentStats) {
            setClanStatisticsAmount(clanStatisticsType, 0);
            return;
        }
        setClanStatisticsAmount(clanStatisticsType, currentStats - Math.abs(amount));
    }
}
