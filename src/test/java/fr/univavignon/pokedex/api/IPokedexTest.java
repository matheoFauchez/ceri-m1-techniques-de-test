package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class IPokedexTest {
    IPokedex pokedex;
    Pokemon bulbizarre;
    List<Pokemon> pokemons;

    @Before
    public void initialiseVariables() throws PokedexException
    {
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        //pokemons.add(pikachu);

        pokedex = Mockito.mock(IPokedex.class);
        Mockito.when(pokedex.size()).thenReturn(1);
        Mockito.when(pokedex.addPokemon(bulbizarre)).thenReturn(bulbizarre.getIndex());
        Mockito.when(pokedex.getPokemon(26)).thenThrow(new PokedexException("Erreur pokemon inexistant"));
        Mockito.when(pokedex.getPokemon(151)).thenThrow(new PokedexException("Index invalide, doit etre inferieur ou egal a 150"));
        Mockito.when(pokedex.getPokemon(-1)).thenThrow(new PokedexException("Index invalide, doit etre supérieur ou egal a 0"));
        Mockito.when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
        Mockito.when(pokedex.getPokemons()).thenReturn(pokemons);
        Mockito.when(pokedex.getPokemons(PokemonComparators.INDEX)).thenReturn(pokemons);
    }

    @Test
    public void shouldReturn1_WhenPokedexSize()
    {
        assertEquals(1, pokedex.size());
        verify(pokedex, times(1)).size();
    }

    @Test
    public void shouldReturn25_WhenBulbizarreAdded()
    {
        assertEquals(0, pokedex.addPokemon(bulbizarre));
        verify(pokedex, times(1)).addPokemon(bulbizarre);
    }

    @Test
    public void shouldReturnBulbizarre_WhenGetPokemon25() throws PokedexException {
        assertEquals(bulbizarre, pokedex.getPokemon(0));
        verify(pokedex, times(1)).getPokemon(0);
    }

    @Test
    public void shouldThrowPokedexException_WhenGetPokemon26()
    {
        assertThrows(PokedexException.class, () -> {
           pokedex.getPokemon(26);
           verify(pokedex, times(1)).getPokemon(26);
        });
    }

    @Test
    public void shouldThrowPokedexException_WhenGetPokemon151()
    {
        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(151);
            verify(pokedex, times(1)).getPokemon(151);
        });
    }

    @Test
    public void shouldThrowPokedexException_WhenGetPokemonNegative()
    {
        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(-1);
            verify(pokedex, times(1)).getPokemon(-1);
        });
    }

    @Test
    public void shouldReturnPokemons_WhenGetPokemons()
    {
        assertEquals(pokemons, pokedex.getPokemons());
        verify(pokedex, times(1)).getPokemons();
    }

    @Test
    public void shouldReturnPokemonsSortedByIndex_WhenGetPokemonsPokemonComparatorIndex()
    {
        assertEquals(pokemons, pokedex.getPokemons(PokemonComparators.INDEX));
        verify(pokedex, times(1)).getPokemons(PokemonComparators.INDEX);
    }

}
