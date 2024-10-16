package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class IPokemonTrainerFactoryTest {

    Team team;
    IPokedexFactory pf;
    PokemonTrainer sacha;
    IPokemonTrainerFactory ptf;

    @Before
    public void initialiseVariables()
    {
        team = Team.VALOR;
        pf = Mockito.mock(IPokedexFactory.class);
        ptf = Mockito.mock(IPokemonTrainerFactory.class);

        sacha=new PokemonTrainer("Sacha", team, Mockito.mock(IPokedex.class));

        Mockito.when(ptf.createTrainer("Sacha", team, pf)).thenReturn(sacha);
    }

    @Test
    public void shouldReturnSacha_WhenPokemonTrainerFactoryCreateTrainer_Sacha_team_pf()
    {
        assertEquals(sacha, ptf.createTrainer("Sacha", team, pf));
        verify(ptf, times(1)).createTrainer("Sacha", team, pf);
    }

}
