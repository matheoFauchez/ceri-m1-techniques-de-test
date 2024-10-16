package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
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

    @Before
    public void initialiseVariables()
    {
        pokedex = Mockito.mock(IPokedex.class);
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pmp = Mockito.mock(IPokemonMetadataProvider.class);
        pf = Mockito.mock(IPokemonFactory.class);

        Mockito.when(pokedexFactory.createPokedex(pmp, pf)).thenReturn(pokedex);
    }

    @Test
    public void shouldReturnPokedex_WhenPokedexFactoryCreatePokedex_WithPokemonMetadataProviderAndPokemonFactory()
    {
        assertEquals(pokedex, pokedexFactory.createPokedex(pmp,pf));
        verify(pokedexFactory, times(1)).createPokedex(pmp, pf);
    }

}
