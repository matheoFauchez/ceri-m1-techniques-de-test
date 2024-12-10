package fr.univavignon.pokedex.api;

/**
 * Factory class for creating PokemonTrainer instances.
 *
 * @author fv
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    /**
     * Creates a new PokemonTrainer.
     *
     * @param name           The name of the trainer.
     * @param team           The team of the trainer.
     * @param pokedexFactory The factory used to create the trainer's pokedex.
     * @return A new PokemonTrainer instance.
     */
    @Override
    public PokemonTrainer createTrainer(final String name, final Team team,
                                        final IPokedexFactory pokedexFactory) {
        // Create the Pokedex using the provided factory.
        IPokedex pokedex = pokedexFactory.createPokedex(
                new PokemonMetadataProvider(),
                new PokemonFactory());
        // Return a new PokemonTrainer with the provided details.
        return new PokemonTrainer(name, team, pokedex);
    }
}
