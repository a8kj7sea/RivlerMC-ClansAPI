package me.a8kj.rivlermc.clans.parent.entity.player.ranks;

import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import me.a8kj.rivlermc.clans.parent.entity.player.ranks.abilitiy.IAbility;

/**
 * Represents a rank within a clan, including its abilities and type.
 */
public interface IRank {

    /**
     * Returns the set of abilities associated with this rank.
     *
     * @return A set of abilities for this rank.
     */
    @NonNull
    Set<IAbility> getAbilities();

    /**
     * Returns the name of the rank.
     *
     * @return The name of the rank.
     */
    String getName();

    /**
     * Returns the id of the rank.
     *
     * @return The unique id of the rank.
     */
    String getRankId();

    /**
     * Checks if the rank contains an ability with the specified label.
     *
     * @param label The label of the ability to check.
     * @return true if the rank contains an ability with the specified label, false
     *         otherwise.
     */
    default boolean contains(String label) {
        return getAbilities().stream()
                .anyMatch(ability -> ability.getLabel().equalsIgnoreCase(label));
    }

    /**
     * Checks if the rank contains the specified ability object.
     *
     * @param ability The ability object to check.
     * @return true if the rank contains the specified ability, false otherwise.
     */
    default boolean contains(IAbility ability) {
        return getAbilities().contains(ability);
    }

    /**
     * Returns the type of this rank.
     *
     * @return The rank type.
     */
    RankType getRankType();

    /**
     * Enumeration representing the possible types of ranks.
     */
    @Getter
    public enum RankType {
        /**
         * An empty rank that does not contain special properties like rank color or
         * specific abilities.
         * Used as a container for abilities only.
         */
        EMPTY("Empty rank doesn't contain special properties like rank color or specific abilities. " +
                "Used as an abilities container for members."),

        /**
         * A custom rank that can be edited to include special properties such as color
         * or name.
         * Custom ranks cannot be used as abilities containers but have a private
         * container for rank abilities.
         */
        CUSTOM("Custom rank is editable and can include special properties like color or name. " +
                "Custom rank cannot be used as an abilities container but has a private container for rank abilities.");

        private final String[] comment;

        private RankType(String... comments) {
            this.comment = comments;
        }
    }
}
