package fr.univavignon.pokedex.api;

/**
 * Factory implementation to create a Pokedex instance.
 *
 * @author fv
 */
public class PokedexFactory implements IPokedexFactory {

    /**
     * Creates a new Pokedex instance
     * using the provided metadata provider and pokemon factory.
     *
     * @param metadataProvider Metadata provider
     *                         to be used by the created Pokedex.
     * @param pokemonFactory   Pokemon factory
     *                         to be used by the created Pokedex.
     * @return A new instance of Pokedex.
     */
    @Override
    public IPokedex createPokedex(
            final IPokemonMetadataProvider metadataProvider,
            final IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
