package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class IPokemonFactoryTest
{
    Pokemon pikachu;
    IPokemonFactory pokemonFactory;

    @Before
    public void initialiseVariables()
    {
        pikachu = new Pokemon(25, "Pikachu", 1, 2, 3, 1,2,3,4,5);

        pokemonFactory=Mockito.mock(IPokemonFactory.class);
        Mockito.when(pokemonFactory.createPokemon(25,1,2,3,4)).thenReturn(pikachu);
    }

    @Test
    public void shouldReturnPikachu_WhenCreatePokemon_25_1_2_3_4()
    {
        Pokemon test;
        assertEquals(pikachu, test=pokemonFactory.createPokemon(25,1,2,3,4));
        verify(pokemonFactory, times(1)).createPokemon(25,1,2,3,4);
        assertTrue("L'attaque doit être comprise entre 0 et 15", test.getAttack() >= 0 && test.getAttack() <= 15);
        assertTrue("L'attaque doit être comprise entre 0 et 15", test.getDefense() >= 0 && test.getDefense() <= 15);
        assertTrue("L'attaque doit être comprise entre 0 et 15", test.getStamina() >= 0 && test.getStamina() <= 15);

    }

}
