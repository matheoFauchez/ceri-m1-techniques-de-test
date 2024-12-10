package fr.univavignon.pokedex.api;

/**
 * Pokemon metadata POJO (Plain Old Java Object).
 * This class holds the metadata for a Pokemon, such as its index, name,
 * attack, defense, and stamina levels.
 *
 * @author fv
 */
public class PokemonMetadata {

    /**
     * Pokemon index.
     **/
    private final int index;

    /**
     * Pokemon name.
     **/
    private final String name;

    /**
     * Pokemon attack level.
     **/
    private final int attack;

    /**
     * Pokemon defense level.
     **/
    private final int defense;

    /**
     * Pokemon stamina level.
     **/
    private final int stamina;

    /**
     * Default constructor for creating a PokemonMetadata object.
     *
     * @param lindex   Pokemon index.
     * @param lname    Pokemon name.
     * @param lattack  Attack level.
     * @param ldefense Defense level.
     * @param lstamina Stamina level.
     */
    public PokemonMetadata(final int lindex,
                           final String lname,
                           final int lattack,
                           final int ldefense,
                           final int lstamina) {
        this.index = lindex;
        this.name = lname;
        this.attack = lattack;
        this.defense = ldefense;
        this.stamina = lstamina;
    }

    /**
     * Gets the Pokemon index.
     *
     * @return Pokemon index.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Gets the Pokemon name.
     *
     * @return Pokemon name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the Pokemon attack level.
     *
     * @return Pokemon attack level.
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Gets the Pokemon defense level.
     *
     * @return Pokemon defense level.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Gets the Pokemon stamina level.
     *
     * @return Pokemon stamina level.
     */
    public int getStamina() {
        return stamina;
    }
}
