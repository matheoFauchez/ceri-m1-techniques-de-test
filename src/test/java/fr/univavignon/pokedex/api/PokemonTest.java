package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test en plus
 * Pour un meilleur % de codecov
 * On teste la classe pokemon et ses getters setters
 */
public class PokemonTest {

    Pokemon pTest;

    @Before
    public void init()
    {
        pTest = new Pokemon(0, "Bulbizarre", 3,4,5,6,7,8,9,10);
    }

    @Test
    public void shouldReturn6WhenGetCP()
    {
        assertEquals(6, pTest.getCp());
    }

    @Test
    public void shouldReturn7WhenGetHp()
    {
        assertEquals(7, pTest.getHp());
    }

    @Test
    public void shouldReturn8WhenGetDust()
    {
        assertEquals(8, pTest.getDust());
    }

    @Test
    public void shoudReturn9WhenGetCandy()
    {
        assertEquals(9, pTest.getCandy());
    }
}
