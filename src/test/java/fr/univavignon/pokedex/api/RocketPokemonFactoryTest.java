package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RocketPokemonFactoryTest {
    IPokemonFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new RocketPokemonFactory();
    }

    //Test des 3 pokemons existants

    @Test
    public void shouldReturnAPokemonNamedBulbasaurWhenCreatePokemonIndex1() throws PokedexException {
        assertEquals("Bulbasaur", factory.createPokemon(1, 2, 3, 4, 5).getName());
    }

    @Test
    public void shouldReturnAPokemonNamedMISSINGNOWhenCreatePokemonIndex0() throws PokedexException {
        assertEquals("MISSINGNO", factory.createPokemon(0, 2, 3, 4, 5).getName());
    }

    @Test
    public void shouldReturnAPokemonNamedAshSPikachuWhenCreatePokemonIndexMinus1() throws PokedexException {
        assertEquals("Ash's Pikachu", factory.createPokemon(-1, 2, 3, 4, 5).getName());
    }

    //Test des cas ou le pokemon n'est pas connu <-1 et >151

    @Test
    public void shouldReturnMISSINGNOPokemonWhenUnknownPokemon() throws PokedexException {
        assertEquals("MISSINGNO", factory.createPokemon(155, 2, 3, 4, 5).getName());
        assertEquals("MISSINGNO", factory.createPokemon(-2, 2, 3, 4, 5).getName());
    }

    //Cas extremes (presque inutiles)

    /**
     * Test if the cp, hp, dust and candy stay the same
     *
     * @throws PokedexException
     */
    @Test
    public void shouldHaveTheSameHPCPAndCandyBeforeAndAfter() throws PokedexException {
        int cp = 2;
        int hp = 3;
        int dust = 4;
        int candy = 5;
        Pokemon pokemon = factory.createPokemon(1, cp, hp, dust, candy);
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
    }

    /**
     * Test if the IV is correct (1 for any pokemon except Ash's Pikachu where it must be 0)
     */
    @Test
    public void shouldHaveTheCorrectIV() throws PokedexException {
        assertEquals(1, (int) factory.createPokemon(1,2,3,4,5).getIv());
        assertEquals(0, (int) factory.createPokemon(-1,2,3,4,5).getIv());
    }
}
