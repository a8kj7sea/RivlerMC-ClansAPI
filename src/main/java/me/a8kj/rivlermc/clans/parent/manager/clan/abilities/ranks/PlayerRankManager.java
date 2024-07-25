package me.a8kj.rivlermc.clans.parent.manager.clan.abilities.ranks;

import java.util.Set;

import me.a8kj.rivlermc.clans.parent.entity.player.impl.IMember;
import me.a8kj.rivlermc.clans.parent.entity.player.ranks.IRank;
import me.a8kj.rivlermc.clans.parent.entity.player.ranks.abilitiy.IAbility;
import me.a8kj.rivlermc.clans.parent.utils.Manager;
import me.a8kj.rivlermc.clans.parent.utils.MetaData;

/**
 * Manages rank-related operations such as granting, promoting, demoting,
 * updating, and removing ranks.
 */
public interface PlayerRankManager extends Manager {

    /**
     * Provides meta-data specific to the PlayerRankManager.
     *
     * @return Meta-data with the value "manager.member.ranks".
     */
    @Override
    default MetaData getMetaData() {
        return new MetaData("manager.member.ranks");
    }

    /**
     * Grants a specific rank to a member within a clan.
     *
     * @param member The member to whom the rank is being granted.
     * @param rank   The rank to grant.
     */
    void grantRank(IMember member, IRank rank);

    /**
     * Promotes a member to a higher rank within a clan.
     *
     * @param member The member to promote.
     */
    void promoteMember(IMember member);

    /**
     * Demotes a member to a lower rank within a clan.
     *
     * @param member The member to demote.
     */
    void demoteMember(IMember member);

    /**
     * Updates the rank of a member within a clan.
     *
     * @param member  The member whose rank is being updated.
     * @param newRank The new rank to set for the member.
     */
    void updateRank(IMember member, IRank newRank);

    /**
     * Removes a specific rank from a member within a clan.
     *
     * @param member The member from whom the rank is being removed.
     * @param rank   The rank to remove.
     */
    void removeRank(IMember member, IRank rank);

    /**
     * Sets a specific rank for a member within a clan.
     *
     * @param member The member whose rank is being set.
     * @param rank   The rank to set.
     */
    void setRank(IMember member, IRank rank);

    /**
     * Manages the abilities associated with ranks.
     *
     * @param rank      The rank whose abilities are being managed.
     * @param abilities The set of abilities to manage.
     */
    void manageAbilities(IRank rank, Set<IAbility> abilities);
}
