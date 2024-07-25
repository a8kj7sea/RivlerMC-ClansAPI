package me.a8kj.rivlermc.clans.parent.entity.player.ranks.abilitiy;

/**
 * Represents an ability that can be assigned to a player or rank.
 */
public interface IAbility {

    /**
     * Returns the label or name of the ability.
     *
     * @return The label of the ability.
     */
    String getLabel();

    // Additional functionality such as priority can be added if needed.
    // Example:
    // /**
    // * Returns the priority of the ability.
    // *
    // * @return The priority level of the ability.
    // */
    // int getPriority();
}
