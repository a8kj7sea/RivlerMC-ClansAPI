package me.a8kj.rivlermc.clans.parent.manager.clan.punishments;

import me.a8kj.rivlermc.clans.parent.entity.clan.IClan;
import me.a8kj.rivlermc.clans.parent.entity.player.impl.IMember;
import me.a8kj.rivlermc.clans.parent.utils.Manager;
import me.a8kj.rivlermc.clans.parent.utils.MetaData;

/**
 * Manages operations related to clan and ally chat, including sending messages,
 * muting members, and managing chat permissions.
 */
public interface ClanChatManager extends Manager {

    /**
     * Provides meta-data specific to the ClanChatManager.
     *
     * @return Meta-data with the value "manager.clan.chat".
     */
    @Override
    default MetaData getMetaData() {
        return new MetaData("manager.clan.chat");
    }

    /**
     * Sends a message to a specific clan's chat.
     *
     * @param clan    The clan to send the message to.
     * @param message The message to send.
     * @param sender  The member sending the message.
     */
    void sendMessageToClanChat(IClan clan, String message, IMember sender);

    /**
     * Sends a message to the ally chat of a specific clan.
     *
     * @param clan    The clan whose ally chat to send the message to.
     * @param message The message to send.
     * @param sender  The member sending the message.
     */
    void sendMessageToAllyChat(IClan clan, String message, IMember sender);

    /**
     * Mutes a member in a specific clan's chat.
     *
     * @param clan   The clan to mute the member in.
     * @param member The member to mute.
     */
    void muteMember(IClan clan, IMember member);

    /**
     * Unmutes a member in a specific clan's chat.
     *
     * @param clan   The clan to unmute the member in.
     * @param member The member to unmute.
     */
    void unmuteMember(IClan clan, IMember member);

    /**
     * Closes a clan's chat (global mute) to prevent any further messages from being
     * sent.
     *
     * @param clan The clan whose chat is to be closed.
     */
    void closeChat(IClan clan);

    /**
     * Adds a member to the ally chat of a specific clan with read and write
     * permissions.
     *
     * @param clan   The clan whose ally chat to add the member to.
     * @param member The member to add to the ally chat.
     */
    void addMemberToAllyChat(IClan clan, IMember member);

    /**
     * Removes a member from the ally chat of a specific clan.
     *
     * @param clan   The clan whose ally chat to remove the member from.
     * @param member The member to remove from the ally chat.
     */
    void removeMemberFromAllyChat(IClan clan, IMember member);

    /**
     * Grants read abilities to a member for a specific clan's ally chat.
     *
     * @param clan   The clan whose ally chat to grant read abilities for.
     * @param member The member to grant read abilities to.
     */
    void grantReadAbilityToAllyChat(IClan clan, IMember member);

    /**
     * Grants write abilities to a member for a specific clan's ally chat.
     *
     * @param clan   The clan whose ally chat to grant write abilities for.
     * @param member The member to grant write abilities to.
     */
    void grantWriteAbilityToAllyChat(IClan clan, IMember member);

    /**
     * Revokes read abilities from a member for a specific clan's ally chat.
     *
     * @param clan   The clan whose ally chat to revoke read abilities from.
     * @param member The member to revoke read abilities from.
     */
    void revokeReadAbilityFromAllyChat(IClan clan, IMember member);

    /**
     * Revokes write abilities from a member for a specific clan's ally chat.
     *
     * @param clan   The clan whose ally chat to revoke write abilities from.
     * @param member The member to revoke write abilities from.
     */
    void revokeWriteAbilityFromAllyChat(IClan clan, IMember member);

}
