package me.a8kj.rivlermc.clans.parent.entity.player.ranks.abilitiy;

/**
 * Represents an interface for blocking specific abilities of a player.
 * 
 * This is useful for cases where a member might have an ability, such as mute
 * permissions,
 * in the main rank but should have that ability overridden or canceled in
 * specific contexts.
 * For instance, a member might have the ability to talk in their main rank but
 * should be
 * muted by a canceling mechanism in certain situations.
 */
public interface AbilityCancellable {

    /**
     * Checks if the ability is canceled (blocked).
     *
     * @return true if the ability is canceled, false otherwise.
     */
    boolean isCancelled();

    /**
     * Sets the cancellation state of the ability.
     *
     * @param state true to cancel (block) the ability, false to allow it.
     */
    void setCancelled(boolean state);
}
