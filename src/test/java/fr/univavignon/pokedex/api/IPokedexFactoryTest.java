package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {

    IPokemonMetadataProvider pmp;
    IPokemonFactory pf;
    IPokedexFactory pokedexFactory;
    IPokedex pokedex;
    Pokemon pikachu;

    @Before
    public void initialiseVariables()
    {
        //pokedex = Mockito.mock(IPokedex.class);
        //pokedexFactory = Mockito.mock(IPokedexFactory.class);
        //pmp = Mockito.mock(IPokemonMetadataProvider.class);
        //pf = Mockito.mock(IPokemonFactory.class);

        //Mockito.when(pokedexFactory.createPokedex(pmp, pf)).thenReturn(pokedex);

        pmp = new PokemonMetadataProvider();
        pf = new PokemonFactory();
        pokedexFactory = new PokedexFactory();
        pokedex = new Pokedex(pmp, pf);

        pikachu = new Pokemon(1, "Pikachu", 3, 4, 5, 6, 7, 8, 9,10);
    }

    @Test
    public void shouldReturnPokedex_WhenPokedexFactoryCreatePokedex_WithPokemonMetadataProviderAndPokemonFactory() throws PokedexException {
        //assertEquals(pokedex, pokedexFactory.createPokedex(pmp,pf));
        //Verify ne marche que sur mocks
        //verify(pokedexFactory, times(1)).createPokedex(pmp, pf);
        IPokedex ppf = pokedexFactory.createPokedex(pmp,pf);
        //assert(pokedex!=null);
        assert(ppf!=null);
        assertEquals(pokedex.size(), ppf.size());//Should be 0
        assertEquals(pokedex.addPokemon(pikachu), ppf.addPokemon(pikachu));//Should be 1
    }

    @Test
    //Ajouté au TP4
    public void shouldThrowPokedexExceptionWhenArgumentNull()
    {
        assertThrows(
                PokedexException.class, ()->{
                    pokedexFactory.createPokedex(pmp, null);
                }
        );
    }

}
