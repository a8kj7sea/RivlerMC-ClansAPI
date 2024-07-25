package me.a8kj.rivlermc.clans.parent.entity.clan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Represents a tag associated with a clan, including its display properties and
 * color.
 */
public interface IClanTag {

    /**
     * Returns the raw tag string of the clan.
     *
     * @return The tag string.
     */
    String getTag();

    /**
     * Returns the display version of the tag.
     *
     * @return The display tag string.
     */
    String getDisplayTag();

    /**
     * Returns the color associated with the tag.
     *
     * @return The color of the tag.
     */
    String getColor();

    /**
     * Returns the length constraints for the tag.
     *
     * @return The tag length constraints.
     */
    TagLength getTagLength();

    /**
     * Represents the length constraints for a tag, including minimum and maximum
     * lengths.
     */
    @AllArgsConstructor
    @Getter
    @Builder
    public class TagLength {
        private int min;
        private int max;
    }
}
