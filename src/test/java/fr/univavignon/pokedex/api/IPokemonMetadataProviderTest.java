package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class IPokemonMetadataProviderTest {

    PokemonMetadata pikachuMetadata;
    IPokemonMetadataProvider pokemonMetadataProvider;

    /**
     * Create a pokemon named pikachu, with the index 25, with the name 'pikachu', 2 of attack, 3 of defense, and 1 of stamina
     * Create a mock for the getPokemon
     */
    @Before
    public void initialisationPikachu() throws PokedexException {
        pikachuMetadata = new PokemonMetadata(25, "Pikachu", 2, 3, 1);

        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        Mockito.when(pokemonMetadataProvider.getPokemonMetadata(25)).thenReturn(pikachuMetadata);

        Mockito.when(pokemonMetadataProvider.getPokemonMetadata(26)).thenThrow(new PokedexException("Erreur pokemon inexistant"));
    }

    /**
     * Try to get the pikachu metadata when trying 25 in getPokemonMetadata of mocked object pokemonMetadataProvider
     * @throws PokedexException
     */
    @Test
    public void shouldReturnPikachuMetadata_When25Index() throws PokedexException
    {
        assertEquals(pikachuMetadata, pokemonMetadataProvider.getPokemonMetadata(25));
        verify(pokemonMetadataProvider, times(1)).getPokemonMetadata(25);
    }

    /**
     * Try to get the PokedexException when trying to get the pokemon with the index=26
     */
    @Test
    public void shouldReturnPokedexException_When26Index()
    {
        assertThrows(PokedexException.class, () ->
        {
            pokemonMetadataProvider.getPokemonMetadata(26);
            verify(pokemonMetadataProvider, times(1)).getPokemonMetadata(26);
        });
    }


}
