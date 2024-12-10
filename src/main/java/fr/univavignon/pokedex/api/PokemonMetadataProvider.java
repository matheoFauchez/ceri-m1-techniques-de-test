package fr.univavignon.pokedex.api;

/**
 * Provider for retrieving metadata about Pokemon.
 * This class holds information about Pokemon metadata and provides
 * a method to retrieve the metadata based on the Pokemon's index.
 *
 * @author fv
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    /** Pokemon index for Bulbizarre. **/
    private static final int BULBIZARRE_INDEX = 0;

    /** Pokemon name for Bulbizarre. **/
    private static final String BULBIZARRE_NAME = "Bulbizarre";

    /** Attack level for Bulbizarre. **/
    private static final int BULBIZARRE_ATTACK = 126;

    /** Defense level for Bulbizarre. **/
    private static final int BULBIZARRE_DEFENSE = 126;

    /** Stamina level for Bulbizarre. **/
    private static final int BULBIZARRE_STAMINA = 90;

    /** Pokemon index for Aquali. **/
    private static final int AQUALI_INDEX = 133;

    /** Pokemon name for Aquali. **/
    private static final String AQUALI_NAME = "Aquali";

    /** Attack level for Aquali. **/
    private static final int AQUALI_ATTACK = 186;

    /** Defense level for Aquali. **/
    private static final int AQUALI_DEFENSE = 168;

    /** Stamina level for Aquali. **/
    private static final int AQUALI_STAMINA = 260;

    /** Array holding the list of Pokemon metadata. **/
    private PokemonMetadata[] listeMetadata = {
            new PokemonMetadata(
                    BULBIZARRE_INDEX,
                    BULBIZARRE_NAME,
                    BULBIZARRE_ATTACK,
                    BULBIZARRE_DEFENSE,
                    BULBIZARRE_STAMINA),
            new PokemonMetadata(
                    AQUALI_INDEX,
                    AQUALI_NAME,
                    AQUALI_ATTACK,
                    AQUALI_DEFENSE,
                    AQUALI_STAMINA)
    };

    /** Number of Pokemon metadata available. **/
    private static final int NB_POKEMON_METADATA = 2;

    /**
     * Retrieves the metadata for a Pokemon by its index.
     *
     * @param index The index of the Pokemon.
     * @return The Pokemon metadata.
     * @throws PokedexException If the Pokemon is not found.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(final int index)
            throws PokedexException {
        for (int i = 0; i < NB_POKEMON_METADATA; i++) {
            if (listeMetadata[i].getIndex() == index) {
                return listeMetadata[i];
            }
        }
        throw new PokedexException("Pokemon introuvable");
    }
}
