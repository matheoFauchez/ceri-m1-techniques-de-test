package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

public class PokemonComparatorsTest {
    Pokemon pikachu;
    Pokemon bulbizarre;

    @Before
    public void init()
    {
        pikachu = new Pokemon(1, "Pikachu", 3, 4, 5, 6, 7, 8, 9, 10);
        bulbizarre = new Pokemon(2, "Bulbizarre", 3, 4, 5, 6, 7,8, 9, 10);
    }

    @Test
    public void shouldReturnNegativeWhenPikachuComparedToBulbizarre()
    {
        assert(PokemonComparators.INDEX.compare(pikachu, bulbizarre)<0);
    }
}
