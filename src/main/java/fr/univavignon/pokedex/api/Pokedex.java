package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * IPokedex implementation. A Pokedex aims to store all information about
 * captured pokemon, as well as their default metadata.
 *
 * @author fv
 */
public class Pokedex implements IPokedex {

    /**
     * PokemonMetadataProvider used to retrieve metadata for each pokemon.
     */
    private IPokemonMetadataProvider metadataProvider;

    /**
     * PokemonFactory used to create new pokemon instances.
     */
    private IPokemonFactory pokemonFactory;

    /**
     * List of all pokemon contained in the Pokedex.
     */
    private List<Pokemon> pokemons;

    /**
     * @return pokemonFactory PokemonFactory
     */
    public IPokemonFactory getPokemonFactory() {
        return pokemonFactory;
    }

    /**
     * @return metadataProvider PokemonMetadataProvider
     */
    public IPokemonMetadataProvider getMetadataProvider() {
        return metadataProvider;
    }

    /**
     * @param localPokemonFactory PokemonFactory
     */
    public void setPokemonFactory(final IPokemonFactory localPokemonFactory) {
        this.pokemonFactory = localPokemonFactory;
    }

    /**
     * @param localMetadataProvider PokemonMetadataProvider
     */
    public void setMetadataProvider(
            final IPokemonMetadataProvider localMetadataProvider
    ) {
        this.metadataProvider = localMetadataProvider;
    }

    /**
     * @param localPokemons List<Pokemon>
     */
    public void setPokemons(final List<Pokemon> localPokemons) {
        this.pokemons = localPokemons;
    }

    /**
     * Pokedex constructor that initializes
     * the Pokedex with the given metadata provider
     * and pokemon factory.
     *
     * @param localMetadataProvider PokemonMetadataProvider
     * @param localPokemonFactory   PokemonFactory
     */
    public Pokedex(final IPokemonMetadataProvider localMetadataProvider,
                   final IPokemonFactory localPokemonFactory) {
        this.metadataProvider = localMetadataProvider;
        this.pokemonFactory = localPokemonFactory;
        this.pokemons = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     **/
    @Override
    public int size() {
        return pokemons.size();
    }

    /**
     * {@inheritDoc}
     **/
    @Override
    public int addPokemon(final Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1;
    }

    /**
     * {@inheritDoc}
     **/
    @Override
    public Pokemon getPokemon(final int id) throws PokedexException {
        for (final Pokemon p : pokemons) {
            if (p.getIndex() == id) {
                return p;
            }
        }
        throw new PokedexException("Pokemon introuvable");
    }

    /**
     * {@inheritDoc}
     **/
    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    /**
     * {@inheritDoc}
     **/
    @Override
    public List<Pokemon> getPokemons(final Comparator<Pokemon> order) {
        final List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(order);
        return sortedPokemons;
    }

    /**
     * {@inheritDoc}
     **/
    @Override
    public Pokemon createPokemon(
            final int index,
            final int cp,
            final int hp,
            final int dust,
            final int candy
    ) throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    /**
     * {@inheritDoc}
     **/
    @Override
    public PokemonMetadata getPokemonMetadata(final int index)
            throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }
}
