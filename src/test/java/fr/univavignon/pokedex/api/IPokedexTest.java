package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class IPokedexTest {
    IPokedex pokedex;
    Pokemon pikachu;
    List<Pokemon> pokemons;

    @Before
    public void initialiseVariables() throws PokedexException {
        pikachu = new Pokemon(25, "Pikachu", 2, 3, 4, 5, 6, 7, 8, 9);
        //pokemons.add(pikachu);

        pokedex = Mockito.mock(IPokedex.class);
        Mockito.when(pokedex.size()).thenReturn(1);
        Mockito.when(pokedex.addPokemon(pikachu)).thenReturn(pikachu.getIndex());
        Mockito.when(pokedex.getPokemon(26)).thenThrow(new PokedexException("Erreur pokemon inexistant"));
        Mockito.when(pokedex.getPokemon(25)).thenReturn(pikachu);
        Mockito.when(pokedex.getPokemons()).thenReturn(pokemons);
    }

    @Test
    public void shouldReturn1_WhenPokedexSize()
    {
        assertEquals(1, pokedex.size());
    }

    @Test
    public void shouldReturn25_WhenPikachuAdded()
    {
        assertEquals(25, pokedex.addPokemon(pikachu));
    }

    @Test
    public void shouldReturnPikachu_WhenGetPokemon25() throws PokedexException {
        assertEquals(pikachu, pokedex.getPokemon(25));
    }

    @Test
    public void shouldThrowPokedexException_WhenGetPokemon26()
    {
        assertThrows(PokedexException.class, () -> {
           pokedex.getPokemon(26);
        });
    }

    @Test
    public void shouldReturnPokemons_WhenGetPokemons()
    {
        assertEquals(pokemons, pokedex.getPokemons());
    }

}
