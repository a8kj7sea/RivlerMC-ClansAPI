package me.a8kj.rivlermc.clans.parent.entity.clan;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import me.a8kj.rivlermc.clans.parent.entity.clan.relation.Relation;
import me.a8kj.rivlermc.clans.parent.entity.clan.utils.IClanProfile;
import me.a8kj.rivlermc.clans.parent.entity.clan.utils.IClanRecord;
import me.a8kj.rivlermc.clans.parent.entity.clan.utils.invites.IInvite;
import me.a8kj.rivlermc.clans.parent.entity.player.impl.ILeader;
import me.a8kj.rivlermc.clans.parent.entity.player.impl.IMember;
import me.a8kj.rivlermc.clans.parent.entity.player.impl.IMember.MemberUpdateProcess;
import me.a8kj.rivlermc.clans.parent.entity.player.ranks.IRank;
import me.a8kj.rivlermc.clans.parent.entity.player.ranks.impl.parents.CustomRank;
import me.a8kj.rivlermc.clans.parent.statistics.IPrestige;
import me.a8kj.rivlermc.clans.parent.utils.SimpleCollectionManager;
import net.md_5.bungee.api.connection.ProxiedPlayer;

/**
 * Represents a clan with various attributes, including its name, size, and
 * relations.
 */
public interface IClan {

    /**
     * Returns the name of the clan.
     *
     * @return The name of the clan.
     */
    String getClanName();

    /**
     * Returns the display name of the clan.
     *
     * @return The display name of the clan.
     */
    String getDisplayName();

    /**
     * Returns the unique identifier for the clan.
     *
     * @return The unique identifier for the clan.
     */
    String getClanId();

    /**
     * Returns the tag associated with the clan.
     *
     * @return The clan tag.
     */
    IClanTag getClanTag();

    /**
     * Returns the size of the clan.
     *
     * @return The size of the clan.
     */
    ClanSize getClanSize();

    /**
     * Returns the prestige level of the clan.
     *
     * @return The prestige of the clan.
     */
    IPrestige getPrestige();

    /**
     * Returns the count of online members in the clan.
     *
     * @return The number of online members.
     */
    int getOnlineMembersCount();

    /**
     * Returns the statistics associated with the clan.
     *
     * @return The clan record.
     */
    IClanRecord getClanRecord();

    /**
     * Returns a set of members belonging to the clan.
     *
     * @return A set of members in the clan.
     */
    <Type> Set<IMember> getMembers();

    /**
     * Returns a set of ranks within the clan.
     *
     * @return A set of ranks.
     */
    Set<CustomRank> getRanks();

    /**
     * Returns the profile associated with the clan.
     *
     * @return The clan profile.
     */
    IClanProfile getClanProfile();

    /**
     * Returns a set of relationships the clan has with other clans.
     *
     * @return A set of relations.
     */
    Set<Relation<IClan>> getRelations();

    /**
     * Returns a set of invitations associated with the clan.
     *
     * @return A set of invitations.
     */
    Set<IInvite> getInvites();

    /**
     * @deprecated Use {@link #getLeader()} instead.
     *             Returns the leader of the clan.
     *
     * @return The leader of the clan.
     */
    @Deprecated
    default ILeader getOwner() {
        return getLeader();
    }

    /**
     * Returns the leader of the clan.
     *
     * @return The leader of the clan.
     */
    ILeader getLeader();

    /**
     * Provides a manager for handling members of the clan.
     *
     * @return a {@link SimpleCollectionManager} instance for managing
     *         {@link IMember} objects
     *         related to {@link ProxiedPlayer}. Returns null by default.
     */
    default SimpleCollectionManager<IMember> getMembersManager() {
        return null;
    }

    /**
     * Provides a manager for handling relations between clans.
     *
     * @return a {@link SimpleCollectionManager} instance for managing
     *         {@link Relation} objects
     *         related to {@link IClan}. Returns null by default.
     */
    default SimpleCollectionManager<Relation<IClan>> getRelationsManager() {
        return null;
    }

    /**
     * Provides a manager for handling invites within the clan.
     *
     * @return a {@link SimpleCollectionManager} instance for managing
     *         {@link IInvite} objects.
     *         Returns null by default.
     */
    default SimpleCollectionManager<IInvite> getInvitesManager() {
        return null;
    }

    /**
     * Provides a manager for handling ranks within the clan.
     *
     * @return a {@link SimpleCollectionManager} instance for managing {@link IRank}
     *         objects.
     *         Returns null by default.
     */
    default SimpleCollectionManager<IRank> getRanksManager() {
        return null;
    }

    /**
     * Checks if a member can be updated within the clan.
     *
     * @param member              The member to be updated.
     * @param memberUpdateProcess The process involved in updating the member.
     * @return true if the member can be updated, false otherwise.
     */
    <Type> boolean canAcceptMemberUpdate(IMember member, MemberUpdateProcess memberUpdateProcess);

    /**
     * Represents the size of the clan, including minimum and maximum player limits.
     */
    @Getter
    @AllArgsConstructor
    @Builder
    public class ClanSize {
        private int minPlayers;
        private int maxPlayers;
    }
}
