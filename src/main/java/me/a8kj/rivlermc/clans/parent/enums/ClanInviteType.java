package me.a8kj.rivlermc.clans.parent.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enumeration representing the types of clan invites.
 */
@RequiredArgsConstructor
@Getter
public enum ClanInviteType {
    /**
     * Represents an invite to form an alliance with another clan, placing it in the
     * friend zone.
     */
    ALLAY("Clan allay invite that is created to invite another clan to be allied with your clan (in friend zone)"),

    /**
     * Represents a default invite to join your clan.
     * This invite will not be valid if your clan's access type is set to private.
     */
    CLAN("Clan invite is a default invite to your clan. This invite will not be valid when your clan's access type is set to private");

    private final String description;
}
