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
    public void initialiseVariables() throws PokedexException {
        team = Team.VALOR;
        /*pf = Mockito.mock(IPokedexFactory.class);
        ptf = Mockito.mock(IPokemonTrainerFactory.class);*/
        pf = new PokedexFactory();
        ptf = new PokemonTrainerFactory();

        sacha=new PokemonTrainer("Sacha", team, pf.createPokedex(new PokemonMetadataProvider(), new PokemonFactory()));

        //Mockito.when(ptf.createTrainer("Sacha", team, pf)).thenReturn(sacha);
    }

    @Test
    public void shouldReturnSacha_WhenPokemonTrainerFactoryCreateTrainer_Sacha_team_pf()
    {
        PokemonTrainer toTest=ptf.createTrainer("Sacha", team, pf);
        assertEquals(sacha.getName(), toTest.getName());
        assertEquals(sacha.getPokedex().size(), toTest.getPokedex().size());
        assertEquals(sacha.getTeam(), toTest.getTeam());
        //verify(ptf, times(1)).createTrainer("Sacha", team, pf);
    }

}
