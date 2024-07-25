package me.a8kj.rivlermc.clans.parent.manager.clan.invites;

import java.util.Map;
import java.util.UUID;

import me.a8kj.rivlermc.clans.parent.entity.clan.IClan;
import me.a8kj.rivlermc.clans.parent.entity.clan.utils.invites.IInvite;
import me.a8kj.rivlermc.clans.parent.enums.ClanInviteType;
import me.a8kj.rivlermc.clans.parent.utils.Manager;
import me.a8kj.rivlermc.clans.parent.utils.MetaData;

/**
 * Manages the creation, removal, and handling of invites within the system.
 */
public interface InviteManager extends Manager {

    /**
     * Provides meta-data specific to the InviteManager.
     *
     * @return Meta-data with the value "manager.clan.invites".
     */
    @Override
    default MetaData getMetaData() {
        return new MetaData("manager.clan.invites");
    }

    /**
     * Creates a new clan invite with a specified type.
     *
     * @param clan           The clan for which the invite is created.
     * @param clanInviteType The type of the clan invite.
     */
    void createClanInvite(IClan clan, ClanInviteType clanInviteType);

    /**
     * Removes an invite using its unique identifier.
     *
     * @param inviteId The unique identifier of the invite to remove.
     */
    void removeInvite(String inviteId);

    /**
     * Sends an invite to a specified source.
     *
     * @param <T>    The type of the source (e.g., a player or another system
     *               component).
     * @param source The source to which the invite is sent.
     * @param invite The invite to send.
     */
    <T> void sendInvite(T source, IInvite invite);

    /**
     * Sends an invite to a specified source using the invite code.
     *
     * @param <T>        The type of the source (e.g., a player or another system
     *                   component).
     * @param source     The source to which the invite is sent.
     * @param inviteCode The code of the invite to send.
     */
    <T> void sendInvite(T source, String inviteCode);

    /**
     * Accepts an invite from a specified source.
     *
     * @param <T>    The type of the source (e.g., a player or another system
     *               component).
     * @param source The source accepting the invite.
     * @param invite The invite to accept.
     */
    <T> void acceptInvite(T source, IInvite invite);

    /**
     * Accepts an invite using the invite code from a specified source.
     *
     * @param <T>        The type of the source (e.g., a player or another system
     *                   component).
     * @param source     The source accepting the invite.
     * @param inviteCode The code of the invite to accept.
     */
    <T> void acceptInvite(T source, String inviteCode);

    /**
     * Deprecated method for sharing an invite.
     * 
     * @param clan   The clan related to the invite.
     * @param invite The invite to share.
     */
    @Deprecated
    default void shareInvite(IClan clan, IInvite invite) {
    }

    /**
     * Retrieves a map of all invites with their unique identifiers.
     *
     * @return A map of invites, where the key is the unique identifier (UUID) and
     *         the value is the invite.
     */
    Map<UUID, IInvite> getInvites();
}
