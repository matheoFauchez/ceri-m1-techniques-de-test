package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest
{
    Pokemon bulbizarre;
    IPokemonFactory pokemonFactory;
    IPokemonMetadataProvider pokemonMetadataProvider;
    PokemonMetadata pokemonMetadata;

    @Before
    public void initialiseVariables() throws PokedexException {
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613,64,4000,4,56);

        pokemonFactory=Mockito.mock(IPokemonFactory.class);
        when(pokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(bulbizarre);

        pokemonMetadata = new PokemonMetadata(0, "Bulbizare", 126, 126, 90);

        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata);
    }

    @Test
    public void shouldReturnBulbizarre_WhenCreatePokemon_0_613_64_4000_4()
    {
        Pokemon test;
        assertEquals(bulbizarre, test=pokemonFactory.createPokemon(0,613,64,4000,4));
        verify(pokemonFactory, times(1)).createPokemon(0,613,64,4000,4);

    }

    @Test
    public void returnedPokemonShouldHaveAttackDefenseAndStaminaBetween0And15() throws PokedexException
    {
        Pokemon pokemonTest = pokemonFactory.createPokemon(0,613,64,4000,4);
        PokemonMetadata pokemonTestSpecsEspece = pokemonMetadataProvider.getPokemonMetadata(0);
        assertTrue("L'attaque de l'individu doit être comprise entre 0 et 15", pokemonTest.getAttack()-pokemonTestSpecsEspece.getAttack()>=0 || pokemonTest.getAttack()-pokemonTestSpecsEspece.getAttack()<=15);
        assertTrue("La défense de l'individu doit être comprise entre 0 et 15", pokemonTest.getDefense()-pokemonTestSpecsEspece.getDefense()>=0 || pokemonTest.getDefense()-pokemonTestSpecsEspece.getDefense()<=15);
        assertTrue("L'endurance de l'individu doit être comprise entre 0 et 15", pokemonTest.getStamina()-pokemonTestSpecsEspece.getStamina()>=0 || pokemonTest.getStamina()-pokemonTestSpecsEspece.getStamina()<=15);
    }

    @Test
    public void checkIfTheIvHasBennCorrectlyCalculated() throws PokedexException {
        Pokemon pokemonTest = pokemonFactory.createPokemon(0,613,64,4000,4);
        PokemonMetadata pokemonTestSpecsEspece = pokemonMetadataProvider.getPokemonMetadata(0);
        int pokemonTestAttack = pokemonTest.getAttack()-pokemonTestSpecsEspece.getAttack();
        int pokemonTestDefense = pokemonTest.getDefense()-pokemonTestSpecsEspece.getDefense();
        int pokemonTestStamina = pokemonTest.getStamina()-pokemonTestSpecsEspece.getStamina();
        int pokemonTestIv = (int)(pokemonTest.getIv()/100)*15;
        assertTrue("Le pourcentage d'iv pour l'attaque a mal été calculé", pokemonTestAttack==pokemonTestIv);
        assertTrue("Le pourcentage d'iv pour la defense a mal été calculé", pokemonTestDefense==pokemonTestIv);
        assertTrue("Le pourcentage d'iv pour l'endurance a mal été calculé", pokemonTestStamina==pokemonTestIv);
    }

}
