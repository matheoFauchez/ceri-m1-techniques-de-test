package fr.univavignon.pokedex.api;

import java.util.Comparator;

/**
 * Enumeration of pokemon comparators.
 * Provides different comparison strategies for Pokemon.
 *
 * @author fv
 */
public enum PokemonComparators implements Comparator<Pokemon> {

    /**
     * Comparator using Pokemon name.
     **/
    NAME(Comparator.comparing(Pokemon::getName)),

    /**
     * Comparator using Pokemon index.
     **/
    INDEX(Comparator.comparing(Pokemon::getIndex)),

    /**
     * Comparator using Pokemon combat point.
     **/
    CP(Comparator.comparing(Pokemon::getCp));

    /**
     * Delegate comparator instance.
     **/
    private final Comparator<Pokemon> delegate;

    /**
     * Default constructor.
     *
     * @param ldelegate Delegate comparator instance.
     */
    PokemonComparators(final Comparator<Pokemon> ldelegate) {
        this.delegate = ldelegate;
    }

    /**
     * Compares two Pokemon instances.
     *
     * @param first  The first Pokemon to compare.
     * @param second The second Pokemon to compare.
     * @return a negative integer, zero, or a positive integer as the first
     * Pokemon is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(final Pokemon first, final Pokemon second) {
        return delegate.compare(first, second);
    }
}
