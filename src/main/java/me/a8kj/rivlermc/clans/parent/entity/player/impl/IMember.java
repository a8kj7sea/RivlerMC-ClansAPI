package me.a8kj.rivlermc.clans.parent.entity.player.impl;

import me.a8kj.rivlermc.clans.parent.entity.clan.IClan;
import me.a8kj.rivlermc.clans.parent.entity.player.Player;
import me.a8kj.rivlermc.clans.parent.entity.player.ranks.IRank;
import me.a8kj.rivlermc.clans.parent.entity.player.ranks.abilitiy.storage.MemberAbilitiesContainer;

/**
 * Represents a member of a clan, extending the player functionality.
 * This interface is used for all players in a clan, even if they have custom
 * ranks.
 *
 */
public interface IMember extends Player {

    /**
     * Returns the clan that the member belongs to.
     *
     * @return The clan of the member.
     */
    IClan getClan();

    /**
     * Checks if the member is muted.
     *
     * @return true if the member is muted, false otherwise.
     */
    boolean isMuted();

    /**
     * Returns the reason for the member's mute, if they are muted.
     * If the member is not muted, returns null.
     *
     * @return The mute cause if muted, or null otherwise.
     */
    default MemberMuteCause getMemberMuteCause() {
        return isMuted() ? getMemberMuteCause() : null;
    }

    /**
     * Enumeration representing the possible reasons for muting a member.
     */
    public enum MemberMuteCause {
        GLOBAL, MEMBER, ALLAY;
    }

    /**
     * Enumeration representing the different processes for updating a member.
     */
    public enum MemberUpdateProcess {
        DEMOTE, PROMOTE, MODIFY_ABILITIES;
    }

    /**
     * Returns the rank of the member within the clan.
     *
     * @return The clan rank of the member.
     */
    IRank getClanRank();

    /**
     * Returns the container for the member's abilities.
     *
     * @return The container for member abilities.
     */
    MemberAbilitiesContainer getMemberAbilitiesContainer();

    /**
     * Indicates that a member does not have a clan by default.
     *
     * @return false, since this default implementation indicates no clan.
     */
    @Override
    default boolean hasClan() {
        return false;
    }

    /**
     * Indicates that a member is always in a clan.
     *
     * @return true, since this default implementation indicates the member is in a
     *         clan.
     */
    @Override
    default boolean inClan() {
        return true;
    }
}
