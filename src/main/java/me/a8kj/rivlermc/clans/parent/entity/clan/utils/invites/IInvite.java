package me.a8kj.rivlermc.clans.parent.entity.clan.utils.invites;

/**
 * Represents an invitation with an ID and code, and provides additional
 * information about the invitation.
 */
public interface IInvite {

    /**
     * Returns the unique identifier for this invitation.
     *
     * @return The unique identifier for this invitation.
     */
    String getInviteId();

    /**
     * Returns the code associated with this invitation.
     *
     * @return The code associated with this invitation.
     */
    String getInviteCode();

    /**
     * Returns the ID of the owner clan for this invitation.
     * This method is deprecated and should not be used in new implementations.
     *
     * @return The ID of the owner clan, or null if not available.
     */
    @Deprecated
    default String getOwnerClanId() {
        return null;
    }

    /**
     * Returns the timestamp of when the invitation was first created.
     *
     * @return The timestamp of the first invite time, or null if not available.
     */
    Long getFirstInviteTime();

    /**
     * Returns the timestamp of when the invitation will expire.
     *
     * @return The timestamp of the invite expiration time, or null if not
     *         available.
     */
    default Long getExpireInviteTime() {

        if (getExpireInviteTime() == null)
            throw new IllegalAccessError("first time to invite cannot be null!");

        return this.getFirstInviteTime() + 604800;
    }

    /**
     * Checks if the invitation is valid.
     *
     * @return true if the invitation is valid, false otherwise.
     */
    default boolean isVaild() {
        return (System.currentTimeMillis() / 1000) < getExpireInviteTime();
    }
}
