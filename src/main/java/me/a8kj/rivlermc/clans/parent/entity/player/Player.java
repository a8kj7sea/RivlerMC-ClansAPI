package me.a8kj.rivlermc.clans.parent.entity.player;

import net.md_5.bungee.api.connection.ProxiedPlayer;

/**
 * Represents a player with various attributes and capabilities related to
 * clans.
 *
 * @param <Type> The type representing the player.
 */
public interface Player {

    /**
     * Returns the proxied player object.
     *
     * @return The player.
     */
    ProxiedPlayer getPlayer();

    /**
     * Returns the player id .
     *
     * @return playerId.
     */
    String getPlayerId();

    /**
     * Checks if the player is blacklisted or blocked by the network from creating
     * or joining clans.
     *
     * @return true if the player is cancelled (blocked), false otherwise.
     */
    boolean isCancelled();

    /**
     * Checks if the player currently has a clan.
     *
     * @return true if the player has a clan, false otherwise.
     */
    boolean hasClan();

    /**
     * Checks if the player is currently in a clan.
     *
     * @return true if the player is in a clan, false otherwise.
     */
    boolean inClan();

    /**
     * Checks if the player is allowed to create a clan.
     * A player can create a clan if they are not cancelled.
     *
     * @return true if the player can create a clan, false otherwise.
     */
    default boolean canCreateClan() {
        return !isCancelled();
    }

    /**
     * Checks if the player is allowed to interact with clans (e.g., join, leave,
     * etc.).
     * A player can interact with clans if they are not cancelled.
     *
     * @return true if the player can cope with clans, false otherwise.
     */
    default boolean canCopeWithClans() {
        return !isCancelled();
    }
}
