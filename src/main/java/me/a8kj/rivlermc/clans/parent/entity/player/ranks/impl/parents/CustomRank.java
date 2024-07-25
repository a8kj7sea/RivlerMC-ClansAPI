package me.a8kj.rivlermc.clans.parent.entity.player.ranks.impl.parents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import me.a8kj.rivlermc.clans.parent.entity.player.ranks.IRank;

/**
 * Represents a custom rank within a clan, extending the IRank interface with
 * additional properties.
 */
public interface CustomRank extends IRank {

    /**
     * Returns the color associated with the custom rank.
     *
     * @return The color of the custom rank.
     */
    String getColor();

    /**
     * Returns the display name of the custom rank, combining its color and name.
     *
     * @return The display name of the custom rank.
     */
    default String getDisplayName() {
        return getColor() + getName();
    }

    /**
     * Returns the weight or importance of the custom rank.
     *
     * @return The weight of the custom rank.
     */
    int getWeight();

    /**
     * Represents the length constraints for the name of the custom rank, including
     * minimum and maximum lengths.
     */
    @AllArgsConstructor
    @Getter
    @Builder
    public class NameLength {
        private int min;
        private int max;
    }

    /**
     * Returns the type of this rank, which is CUSTOM for custom ranks.
     *
     * @return The rank type, which is CUSTOM.
     */
    @Override
    default RankType getRankType() {
        return RankType.CUSTOM;
    }
}
