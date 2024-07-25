package me.a8kj.rivlermc.clans.parent.entity.clan.relation.impl;

import java.util.Set;

import me.a8kj.rivlermc.clans.parent.entity.clan.IClan;
import me.a8kj.rivlermc.clans.parent.entity.clan.relation.Relation;

/**
 * A concrete implementation of the Relation class representing an enemy
 * relationship with a set of IClan entities.
 */
public abstract class EnemyRelation extends Relation<IClan> {

    /**
     * Constructs an EnemyRelation instance with the default metadata "victim".
     */
    public EnemyRelation() {
        super("victim");
    }

    /**
     * Returns the set of related IClan entities.
     *
     * @return The set of related IClan entities.
     */
    @Override
    public Set<IClan> getRelationSet() {
        return super.getRelationSet();
    }
}
