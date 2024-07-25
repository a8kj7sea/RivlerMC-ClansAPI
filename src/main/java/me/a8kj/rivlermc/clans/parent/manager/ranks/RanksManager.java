package me.a8kj.rivlermc.clans.parent.manager.ranks;

import java.util.Set;

import me.a8kj.rivlermc.clans.parent.entity.player.ranks.abilitiy.IAbility;
import me.a8kj.rivlermc.clans.parent.entity.player.ranks.impl.parents.CustomRank;
import me.a8kj.rivlermc.clans.parent.utils.Manager;
import me.a8kj.rivlermc.clans.parent.utils.MetaData;

public interface RanksManager extends Manager {

    /**
     * Provides meta-data specific to the RankManager.
     *
     * @return Meta-data with the value "manager.member.ranks".
     */
    @Override
    default MetaData getMetaData() {
        return new MetaData("manager.member.ranks");
    }

    /**
     * Creates a new rank with the specified details.
     *
     * @param name       The name of the new rank.
     * @param color      The color associated with the rank.
     * @param weight     The weight or importance of the rank.
     * @param abilities  The abilities to assign to the new rank.
     * @return The newly created rank.
     */
    CustomRank createRank(String name, String color, int weight, Set<IAbility> abilities);

    /**
     * Removes an existing rank.
     *
     * @param rank The rank to remove.
     */
    void removeRank(CustomRank rank);

    /**
     * Updates the details of an existing rank.
     *
     * @param rank       The rank to update.
     * @param newName    The new name for the rank.
     * @param newColor   The new color for the rank.
     * @param newWeight  The new weight for the rank.
     */
    void updateRank(CustomRank rank, String newName, String newColor, int newWeight);

    /**
     * Adds an ability to the specified rank.
     *
     * @param rank     The rank to update.
     * @param ability  The ability to add.
     */
    void addAbilityToRank(CustomRank rank, IAbility ability);

    /**
     * Removes an ability from the specified rank.
     *
     * @param rank     The rank to update.
     * @param ability  The ability to remove.
     */
    void removeAbilityFromRank(CustomRank rank, IAbility ability);

    /**
     * Updates an existing ability within the rank.
     *
     * @param rank      The rank to update.
     * @param oldAbility The ability to be replaced.
     * @param newAbility The new ability to add.
     */
    void updateAbilityInRank(CustomRank rank, IAbility oldAbility, IAbility newAbility);

    /**
     * Retrieves all abilities associated with a specific rank.
     *
     * @param rank The rank whose abilities are to be retrieved.
     * @return A set of abilities associated with the rank.
     */
    Set<IAbility> getAbilitiesForRank(CustomRank rank);

    /**
     * Checks if a specific ability is associated with a rank.
     *
     * @param rank     The rank to check.
     * @param ability  The ability to check.
     * @return True if the rank has the ability, false otherwise.
     */
    boolean hasAbility(CustomRank rank, IAbility ability);
}

