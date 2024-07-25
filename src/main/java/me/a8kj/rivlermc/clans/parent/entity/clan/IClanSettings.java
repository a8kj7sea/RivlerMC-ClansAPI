package me.a8kj.rivlermc.clans.parent.entity.clan;

/**
 * Represents the settings and configurations for a clan.
 */
public interface IClanSettings {

    /**
     * Returns the access type of the clan.
     *
     * @return The access type of the clan.
     */
    ClanAccessType getClanAccessType();

    /**
     * Checks if relation requests are accepted by the clan.
     *
     * @return true if relation requests are accepted, false otherwise.
     */
    boolean acceptRelationRequests();

    /**
     * Changes the tag associated with the clan.
     *
     * @param iClanTag The new clan tag to be set.
     */
    void changeClanTag(IClanTag iClanTag);

    /**
     * Changes the name of the clan.
     *
     * @param name The new name for the clan.
     */
    void changeClanName(String name);

    /**
     * Checks if the clan's prestige is hidden.
     *
     * @return true if the prestige is hidden, false otherwise.
     */
    boolean hidePrestige();

    /**
     * Enumeration representing the possible access types for a clan.
     */
    public enum ClanAccessType {
        /**
         * Indicates that the clan is publicly accessible.
         */
        PUBLIC,

        /**
         * Indicates that the clan is privately accessible.
         */
        PRIVATE;
    }
}
