package fr.univavignon.pokedex.api;

import java.util.Random;

/**
 * PokemonFactory is responsible for creating new Pokemon instances.
 * It generates random IV values for each Pokemon created.
 *
 * @author fv
 */
public class PokemonFactory implements IPokemonFactory {

    /**
     * PokemonMetadataProvider used to retrieve metadata for each Pokemon.
     **/
    private final PokemonMetadataProvider pmp;

    /**
     * Default constructor initializes the PokemonMetadataProvider.
     */
    public PokemonFactory() {
        this.pmp = new PokemonMetadataProvider();
    }

    /**
     * Creates a new Pokemon instance with random IV values.
     *
     * @param index The index of the Pokemon.
     * @param cp    Combat power of the Pokemon.
     * @param hp    Health points of the Pokemon.
     * @param dust  The amount of dust required for upgrading this Pokemon.
     * @param candy The amount of candy required for upgrading this Pokemon.
     * @return A new Pokemon instance
     * with the specified properties and random IV values.
     * @throws PokedexException if the Pokemon metadata cannot be retrieved.
     */
    @Override
    public Pokemon createPokemon(final int index,
                                 final int cp,
                                 final int hp,
                                 final int dust,
                                 final int candy) throws PokedexException {
        // Retrieve Pokemon metadata using the provided index
        PokemonMetadata pm = pmp.getPokemonMetadata(index);

        // Generate random IV values for Attack, Defense, and Stamina
        Random rdm = new Random();
        final int seize = 16;
        final int quaranteCinq = 45;
        int ivAttack = rdm.nextInt(seize);
        int ivDefense = rdm.nextInt(seize);
        int ivStamina = rdm.nextInt(seize);

        // Calculate the IV perfection
        // as the average of the individual stats
        double iv = (double) (ivAttack + ivDefense + ivStamina) / quaranteCinq;

        // Create and return a new Pokemon
        // with the specified properties and calculated IV
        return new Pokemon(index, pm.getName(), pm.getAttack() + ivAttack,
                pm.getDefense() + ivDefense, pm.getStamina() + ivStamina,
                cp, hp, dust, candy, iv);
    }
}
