package me.a8kj.rivlermc.clans.parent.manager.clan.abilities.player;

import java.util.Collection;
import java.util.Set;

import me.a8kj.rivlermc.clans.parent.entity.clan.IClan;
import me.a8kj.rivlermc.clans.parent.entity.player.impl.IMember;
import me.a8kj.rivlermc.clans.parent.entity.player.impl.IMember.MemberUpdateProcess;
import me.a8kj.rivlermc.clans.parent.entity.player.ranks.abilitiy.AbilityCancellable;
import me.a8kj.rivlermc.clans.parent.entity.player.ranks.abilitiy.IAbility;
import me.a8kj.rivlermc.clans.parent.utils.Manager;
import me.a8kj.rivlermc.clans.parent.utils.MetaData;

/**
 * Manages the abilities of members, allowing for updates and modifications to a
 * member's abilities container.
 * 
 * This interface handles the private modification of member abilities without
 * affecting the main rank abilities.
 * It includes functionality for updating, adding, removing, and clearing
 * abilities, as well as checking if an ability is blocked (cancelled).
 */
@Deprecated
public interface AbilitiesContainerManager extends Manager {

    /**
     * Provides meta-data specific to the AbilitiesContainerManager.
     *
     * @return Meta-data with the value "manager.member.abilities".
     */
    @Override
    default MetaData getMetaData() {
        return new MetaData("manager.member.abilities");
    }

    /**
     * Indicates the type of update process related to modifying abilities.
     */
    @Deprecated
    final MemberUpdateProcess abilites = MemberUpdateProcess.MODIFY_ABILITIES;

    /**
     * Updates the abilities of a member within a specific clan.
     *
     * @param member   The member whose abilities are being updated.
     * @param clan     The clan the member belongs to.
     * @param abilites The set of abilities to be updated.
     */
    void updateAbilities(IMember member, IClan clan, Set<IAbility> abilites);

    /**
     * Checks if a member has a specific ability by its label.
     *
     * @param member The member to check.
     * @param label  The label of the ability.
     * @return true if the member has the ability, false otherwise.
     */
    default boolean hasAbility(IMember member, String label) {
        return member.getMemberAbilitiesContainer().contains(label);
    }

    /**
     * Checks if a member has a specific ability by the ability object.
     *
     * @param member  The member to check.
     * @param ability The ability object.
     * @return true if the member has the ability, false otherwise.
     */
    default boolean hasAbility(IMember member, IAbility ability) {
        return member.getMemberAbilitiesContainer().contains(ability);
    }

    /**
     * Sets the abilities of a member within a specific clan.
     *
     * @param member   The member whose abilities are being set.
     * @param clan     The clan the member belongs to.
     * @param abilites The set of abilities to be set.
     */
    default void setAbilities(IMember member, IClan clan, Set<IAbility> abilites) {
        updateAbilities(member, clan, abilites);
    }

    /**
     * Adds a specific ability to a member within a specific clan.
     *
     * @param member  The member to add the ability to.
     * @param clan    The clan the member belongs to.
     * @param ability The ability to add.
     */
    void addAbility(IMember member, IClan clan, IAbility ability);

    /**
     * Removes a specific ability from a member within a specific clan.
     *
     * @param member  The member from whom to remove the ability.
     * @param clan    The clan the member belongs to.
     * @param ability The ability to remove.
     */
    void removeAbility(IMember member, IClan clan, IAbility ability);

    /**
     * Clears all abilities from a member within a specific clan.
     *
     * @param member The member whose abilities are to be cleared.
     * @param clan   The clan the member belongs to.
     */
    void clearAllAbilites(IMember member, IClan clan);

    /**
     * Retrieves all abilities of a member.
     *
     * @param member The member whose abilities are to be retrieved.
     * @return A collection of the member's abilities.
     */
    Collection<IAbility> getMemberAbilites(IMember member);

    /**
     * Checks if a specific ability is cancelled (blocked).
     *
     * @param ability The ability to check.
     * @return -1 if the ability is not cancellable, 1 if it is cancelled, 0 if it
     *         is not cancelled.
     */
    default int isCancelled(IAbility ability) {
        if (ability instanceof AbilityCancellable) {
            return ((AbilityCancellable) ability).isCancelled() ? 1 : 0;
        }
        return -1;
    }

    /**
     * Sets the cancelled state of a specific ability.
     *
     * @param ability The ability to update.
     * @param state   The new cancelled state to set.
     */
    default void setCancelled(IAbility ability, boolean state) {
        if (!(ability instanceof AbilityCancellable)) {
            return;
        }
        ((AbilityCancellable) ability).setCancelled(state);
    }
}
