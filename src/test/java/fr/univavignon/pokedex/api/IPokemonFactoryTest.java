package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class IPokemonFactoryTest
{
    Pokemon pikachu;
    IPokemonFactory pokemonFactory;

    @Before
    public void initialiseVariables()
    {
        pikachu = new Pokemon(25, "Pikachu", 3, 2, 3, 1,2,3,4,5);

        pokemonFactory=Mockito.mock(IPokemonFactory.class);
        Mockito.when(pokemonFactory.createPokemon(25,1,2,3,4)).thenReturn(pikachu);
    }

    @Test
    public void shouldReturnPikachu_WhenCreatePokemon_25_1_2_3_4()
    {
        assertEquals(pikachu, pokemonFactory.createPokemon(25,1,2,3,4));
        verify(pokemonFactory, times(1)).createPokemon(25,1,2,3,4);
    }

}
