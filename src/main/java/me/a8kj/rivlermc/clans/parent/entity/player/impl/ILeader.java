package me.a8kj.rivlermc.clans.parent.entity.player.impl;

/**
 * Represents a leader of a clan, extending the member functionality.
 *
 */
public interface ILeader extends IMember {

    /**
     * Indicates that a leader always has a clan.
     *
     * @return true, since a leader is always in a clan.
     */
    @Override
    default boolean hasClan() {
        return true;
    }

    /**
     * Indicates that a leader is always in a clan.
     *
     * @return true, since a leader is always in a clan.
     */
    @Override
    default boolean inClan() {
        return true;
    }
}
