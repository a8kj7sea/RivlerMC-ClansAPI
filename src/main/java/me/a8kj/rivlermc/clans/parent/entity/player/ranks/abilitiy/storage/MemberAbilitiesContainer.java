package me.a8kj.rivlermc.clans.parent.entity.player.ranks.abilitiy.storage;

import me.a8kj.rivlermc.clans.parent.entity.player.ranks.abilitiy.IAbility;
import me.a8kj.rivlermc.clans.parent.entity.player.ranks.impl.parents.EmptyRank;

/**
 * Manages and handles player abilities within a single rank, serving as a
 * permissions container.
 * 
 * This class allows for the modification of permissions separately from the
 * main rank,
 * similar to how permissions are managed on GitHub. It enables a temporary
 * solution for
 * managing abilities such as mute status, which can be different from the main
 * rank's
 * permissions. This is particularly useful for members with full permissions
 * who need
 * specific abilities handled in a distinct manner.
 */
public interface MemberAbilitiesContainer extends EmptyRank {

    /**
     * Checks if the container includes an ability with the specified label.
     *
     * @param label The label of the ability to check.
     * @return true if the ability with the specified label is present, false
     *         otherwise.
     */
    default boolean contains(String label) {
        return getAbilities().stream()
                .filter(ability -> ability.getLabel().equalsIgnoreCase(label))
                .findAny()
                .isPresent();
    }

    /**
     * Checks if the container includes the specified ability object.
     *
     * @param ability The ability object to check.
     * @return true if the ability object is present, false otherwise.
     */
    default boolean contains(IAbility ability) {
        return getAbilities() == null ? false : getAbilities().contains(ability);
    }

    /**
     * Returns the rank type, which is EMPTY for this container.
     *
     * @return The rank type, which is EMPTY.
     */
    @Override
    default RankType getRankType() {
        return RankType.EMPTY;
    }
}
