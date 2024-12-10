package fr.univavignon.pokedex.api;

/**
 * Factory interface for classes that aim to create Pokemon instance.
 *
 * @author fv
 */
public interface IPokemonFactory {

    /**
     * Creates a pokemon instance computing its IVs.
     *
     * @param index Pokemon index.
     * @param cp    Pokemon CP.
     * @param hp    Pokemon HP.
     * @param dust  Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     * @throws PokedexException if there is an error during pokemon creation.
     */
    Pokemon createPokemon(int index, int cp, int hp, int dust, int candy)
            throws PokedexException;
}
