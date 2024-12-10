package fr.univavignon.pokedex.api;

/**
 * Pokemon POJO.
 *
 * @author fv
 */
public final class Pokemon extends PokemonMetadata {

    /**
     * Combat Point of the pokemon.
     **/
    private final int cp;

    /**
     * HP of the pokemon.
     **/
    private final int hp;

    /**
     * Required dust for upgrading this pokemon.
     **/
    private final int dust;

    /**
     * Required candy for upgrading this pokemon.
     **/
    private final int candy;

    /**
     * IV perfection percentage.
     **/
    private final double iv;

    /**
     * Default constructor.
     *
     * @param index   Pokemon index.
     * @param name    Pokemon name.
     * @param attack  Attack level.
     * @param defense Defense level.
     * @param stamina Stamina level.
     * @param lcp      Pokemon cp.
     * @param lhp      Pokemon hp.
     * @param ldust    Required dust for upgrading this pokemon.
     * @param lcandy   Required candy for upgrading this pokemon.
     * @param liv      IV perfection percentage.
     */
    public Pokemon(final int index,
                   final String name,
                   final int attack,
                   final int defense,
                   final int stamina,
                   final int lcp,
                   final int lhp,
                   final int ldust,
                   final int lcandy,
                   final double liv) {
        super(index, name, attack, defense, stamina);
        this.cp = lcp;
        this.hp = lhp;
        this.dust = ldust;
        this.candy = lcandy;
        this.iv = liv;
    }

    /**
     * Gets the Combat Point (CP) of the pokemon.
     *
     * @return the CP of the pokemon.
     */
    public int getCp() {
        return cp;
    }

    /**
     * Gets the HP of the pokemon.
     *
     * @return the HP of the pokemon.
     */
    public int getHp() {
        return hp;
    }

    /**
     * Gets the required dust for upgrading the pokemon.
     *
     * @return the required dust for upgrading the pokemon.
     */
    public int getDust() {
        return dust;
    }

    /**
     * Gets the required candy for upgrading the pokemon.
     *
     * @return the required candy for upgrading the pokemon.
     */
    public int getCandy() {
        return candy;
    }

    /**
     * Gets the IV perfection percentage of the pokemon.
     *
     * @return the IV perfection percentage.
     */
    public double getIv() {
        return iv;
    }

}
