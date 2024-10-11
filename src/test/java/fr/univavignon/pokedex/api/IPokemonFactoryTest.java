package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest
{
    Pokemon pikachu;

    @Before
    public void initialiseVariables()
    {
        pikachu = new Pokemon(25, "Pikachu", 3, 2, 3, 1,2,3,4,5);
    }

}
