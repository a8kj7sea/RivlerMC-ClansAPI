package me.a8kj.rivlermc.clans.parent.manager.clan;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import me.a8kj.rivlermc.clans.parent.entity.clan.IClan;
import me.a8kj.rivlermc.clans.parent.entity.clan.IClanSettings;
import me.a8kj.rivlermc.clans.parent.entity.clan.IClanTag;
import me.a8kj.rivlermc.clans.parent.entity.clan.utils.IClanProfile;
import me.a8kj.rivlermc.clans.parent.entity.clan.utils.invites.IInvite;
import me.a8kj.rivlermc.clans.parent.entity.player.impl.ILeader;
import me.a8kj.rivlermc.clans.parent.entity.player.impl.IMember;
import me.a8kj.rivlermc.clans.parent.entity.player.ranks.IRank;
import me.a8kj.rivlermc.clans.parent.statistics.IClanStatistics;
import me.a8kj.rivlermc.clans.parent.statistics.IPrestige;
import me.a8kj.rivlermc.clans.parent.statistics.ITopClan;
import me.a8kj.rivlermc.clans.parent.utils.Manager;
import me.a8kj.rivlermc.clans.parent.utils.MetaData;

/**
 * Manages various operations related to clans, such as creating, deleting, and
 * updating clans,
 * as well as managing members, invites, clan ownership transfers, and profiles.
 */
public interface ClanManager extends Manager {

    /**
     * Provides meta-data specific to the ClanManager.
     *
     * @return Meta-data with the value "manager.clan.general".
     */
    @Override
    default MetaData getMetaData() {
        return new MetaData("manager.clan.general");
    }

    /**
     * Creates a new clan with the specified details.
     *
     * @param name    The name of the new clan.
     * @param creator The member who is creating the clan.
     * @return The newly created clan.
     */
    IClan createClan(String name, IMember creator);

    /**
     * Deletes an existing clan.
     *
     * @param clan The clan to delete.
     */
    void deleteClan(IClan clan);

    /**
     * Updates the details of an existing clan.
     *
     * @param clan    The clan to update.
     * @param newName The new name for the clan.
     * @param newTag  The new tag for the clan.
     */
    void updateClan(IClan clan, String newName, IClanTag newTag);

    /**
     * Updates the name of an existing clan.
     *
     * @param clan    The clan whose name is to be updated.
     * @param newName The new name for the clan.
     */
    void updateClanName(IClan clan, String newName);

    /**
     * Adds a member to a specified clan.
     *
     * @param clan   The clan to add the member to.
     * @param member The member to add to the clan.
     */
    void addMember(IClan clan, IMember member);

    /**
     * Removes a member from a specified clan.
     *
     * @param clan   The clan from which the member is to be removed.
     * @param member The member to remove from the clan.
     */
    void removeMember(IClan clan, IMember member);

    /**
     * Sets the settings for a specified clan.
     *
     * @param clan     The clan for which to set the settings.
     * @param settings The settings to apply to the clan.
     */
    void setClanSettings(IClan clan, IClanSettings settings);

    /**
     * Transfers ownership of a clan to a new member.
     *
     * @param clan     The clan to transfer ownership of.
     * @param newOwner The member who will become the new owner of the clan.
     * @throws IllegalArgumentException if the new owner is not a member of the
     *                                  clan.
     */
    void transferOwnership(IClan clan, IMember newOwner) throws IllegalArgumentException;

    /**
     * Sets the profile for a specified clan.
     *
     * @param clan    The clan for which to set the profile.
     * @param profile The profile to apply to the clan.
     */
    void setClanProfile(IClan clan, IClanProfile profile);

    /**
     * Retrieves all invites for all clans.
     *
     * @return A map where the key is the clan ID and the value is a set of invites
     *         for that clan.
     */
    Map<UUID, Set<IInvite>> getAllClanInvites();

    /**
     * Retrieves the list of all clans.
     *
     * @return A list of all clans.
     */
    List<IClan> getAllClans();

    /**
     * Retrieves the clan by its unique identifier.
     *
     * @param clanId The unique identifier of the clan.
     * @return The clan with the specified identifier, or null if not found.
     */
    IClan getClanById(UUID clanId);

    /**
     * Retrieves the clan by its name.
     *
     * @param clanName The name of the clan.
     * @return The clan with the specified name, or null if not found.
     */
    IClan getClanByName(String clanName);

    /**
     * Checks if a clan exists by its unique identifier.
     *
     * @param clanId The unique identifier of the clan.
     * @return True if the clan exists, false otherwise.
     */
    boolean doesClanExist(UUID clanId);

    /**
     * Checks if a clan exists by its unique name.
     *
     * @param clanName The unique name of the clan.
     * @return True if the clan exists, false otherwise.
     */
    boolean doesClanExist(String clanName);

    /**
     * Loads all clans from the data source.
     *
     * @return A list of all loaded clans.
     */
    List<IClan> loadAllClans();

    /**
     * Saves the current state of all clans to the data source.
     */
    void saveAllClans();

    /**
     * Promotes a member to a higher rank within the specified clan.
     *
     * @param clan   The clan in which to promote the member.
     * @param member The member to promote.
     */
    void promoteMember(IClan clan, IMember member);

    /**
     * Demotes a member to a lower rank within the specified clan.
     *
     * @param clan   The clan in which to demote the member.
     * @param member The member to demote.
     */
    void demoteMember(IClan clan, IMember member);

    /**
     * Sets or updates the tag of a specified clan.
     *
     * @param clan The clan to update.
     * @param tag  The new tag for the clan.
     */
    void setClanTag(IClan clan, IClanTag tag);

    /**
     * Sets or updates the prestige of a specified clan.
     *
     * @param clan     The clan to update.
     * @param prestige The new prestige for the clan.
     */
    void setClanPrestige(IClan clan, IPrestige prestige);

    /**
     * Adds a new invite to a specified clan.
     *
     * @param clan   The clan to which the invite will be added.
     * @param invite The invite to add.
     */
    void addInvite(IClan clan, IInvite invite);

    /**
     * Removes an invite from a specified clan.
     *
     * @param clan   The clan from which to remove the invite.
     * @param invite The invite to remove.
     */
    void removeInvite(IClan clan, IInvite invite);

    /**
     * Retrieves the clan that a specific leader (owner) belongs to.
     *
     * @param leader The leader whose clan is to be retrieved.
     * @return The clan that the leader belongs to.
     */
    IClan getClanByOwner(ILeader leader);

    /**
     * Retrieves specific statistics for a given clan.
     *
     * @param clan The clan for which to retrieve statistics.
     * @param type The type of statistics to retrieve.
     * @return The value of the specified statistics.
     */
    int getClanStatistics(IClan clan, IClanStatistics.ClanStatisticsType type);

    /**
     * Updates the settings of a specified clan.
     *
     * @param clan     The clan to update.
     * @param settings The new settings for the clan.
     */
    void updateClanSettings(IClan clan, IClanSettings settings);

    /**
     * Retrieves a list of all members in a specified clan.
     *
     * @param clan The clan from which to retrieve members.
     * @return A list of all members in the clan.
     */
    List<IMember> getAllMembers(IClan clan);

    /**
     * Retrieves the rank of a specific member within a clan.
     *
     * @param clan   The clan in which to retrieve the member's rank.
     * @param member The member whose rank is to be retrieved.
     * @return The rank of the member.
     */
    IRank getMemberRank(IClan clan, IMember member);

    /**
     * Retrieves the profile details of a specified clan.
     *
     * @param clan The clan whose profile details are to be retrieved.
     * @return The profile of the clan.
     */
    IClanProfile getClanProfile(IClan clan);

    /**
     * Retrieves a list of all invites associated with a specific clan.
     *
     * @param clan The clan whose invites are to be retrieved.
     * @return A list of all invites for the clan.
     */
    Set<IInvite> getClanInvites(IClan clan);

    /**
     * Checks if a specific member is part of a given clan.
     *
     * @param clan   The clan to check.
     * @param member The member to check.
     * @return True if the member is part of the clan, false otherwise.
     */
    boolean isMemberInClan(IClan clan, IMember member);

    /**
     * Adds a clan to a top list based on specific criteria.
     *
     * @param topClan The top clan to add.
     */
    void addClanToTopList(ITopClan topClan);

    /**
     * Removes a clan from the top list.
     *
     * @param topClan The top clan to remove.
     */
    void removeClanFromTopList(ITopClan topClan);

    /**
     * Kicks a member from the specified clan.
     *
     * @param clan   The clan from which to kick the member.
     * @param member The member to kick.
     * @return True if the member was successfully kicked, false otherwise.
     */
    boolean kickMember(IClan clan, IMember member);

    /**
     * Adds a relation between clans to mark them as allies.
     *
     * @param clan The clan initiating the alliance.
     * @param ally The clan to be allied with.
     * @return True if the relation was successfully established, false otherwise.
     */
    boolean addAlly(IClan clan, IClan ally);

    /**
     * Removes a relation between clans to end their alliance.
     *
     * @param clan The clan initiating the removal of the alliance.
     * @param ally The clan to remove from the allies list.
     * @return True if the relation was successfully removed, false otherwise.
     */
    boolean removeAlly(IClan clan, IClan ally);

    /**
     * Adds a relation between clans to mark them as enemies.
     *
     * @param clan  The clan initiating the enmity.
     * @param enemy The clan to be marked as an enemy.
     * @return True if the relation was successfully established, false otherwise.
     */
    boolean addEnemy(IClan clan, IClan enemy);

    /**
     * Removes a relation between clans to end their enmity.
     *
     * @param clan  The clan initiating the removal of the enmity.
     * @param enemy The clan to remove from the enemies list.
     * @return True if the relation was successfully removed, false otherwise.
     */
    boolean removeEnemy(IClan clan, IClan enemy);

    /**
     * Gets the prestige information for a specified clan.
     *
     * @param clan The clan for which to retrieve the prestige.
     * @return The prestige information of the clan.
     */
    IPrestige getClanPrestige(IClan clan);

}
