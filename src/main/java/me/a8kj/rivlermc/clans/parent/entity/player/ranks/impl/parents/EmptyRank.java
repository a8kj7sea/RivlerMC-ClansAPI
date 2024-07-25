package me.a8kj.rivlermc.clans.parent.entity.player.ranks.impl.parents;

import me.a8kj.rivlermc.clans.parent.entity.player.ranks.IRank;

/**
 * @deprecated
 *             Represents an empty rank within a clan, extending the IRank
 *             interface with no
 *             additional properties.
 */
@Deprecated
public interface EmptyRank extends IRank {

    /**
     * Returns the type of this rank, which is EMPTY for empty ranks.
     *
     * @return The rank type, which is EMPTY.
     */
    @Override
    default RankType getRankType() {
        return RankType.EMPTY;
    }
}
