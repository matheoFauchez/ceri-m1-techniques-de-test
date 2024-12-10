package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPokemonFactoryTest {
    Pokemon bulbizarre;
    IPokemonFactory pokemonFactory;
    IPokemonMetadataProvider pokemonMetadataProvider;
    PokemonMetadata pokemonMetadata;

    @Before
    public void initialiseVariables() throws PokedexException {
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

        pokemonFactory = new PokemonFactory();
        //pokemonFactory = new RocketPokemonFactory();

        pokemonMetadata = new PokemonMetadata(0, "Bulbizare", 126, 126, 90);

        pokemonMetadataProvider = new PokemonMetadataProvider();
        /*pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata);*/
    }

    @Test
    public void shouldReturnBulbizarre_WhenCreatePokemon_0_613_64_4000_4() throws PokedexException {
        assertEquals(bulbizarre.getName(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getName());
        //verify(pokemonFactory, times(1)).createPokemon(0,613,64,4000,4);
    }

    @Test
    public void returnedPokemonShouldHaveAttackDefenseAndStaminaBetween0And15() throws PokedexException {
        Pokemon Pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        PokemonMetadata PokemonSpecsEspece = pokemonMetadataProvider.getPokemonMetadata(0);
        assertTrue("L'attaque de l'individu doit être comprise entre 0 et 15", Pokemon.getAttack() - PokemonSpecsEspece.getAttack() >= 0 || Pokemon.getAttack() - PokemonSpecsEspece.getAttack() <= 15);
        assertTrue("La défense de l'individu doit être comprise entre 0 et 15", Pokemon.getDefense() - PokemonSpecsEspece.getDefense() >= 0 || Pokemon.getDefense() - PokemonSpecsEspece.getDefense() <= 15);
        assertTrue("L'endurance de l'individu doit être comprise entre 0 et 15", Pokemon.getStamina() - PokemonSpecsEspece.getStamina() >= 0 || Pokemon.getStamina() - PokemonSpecsEspece.getStamina() <= 15);
    }

    @Test
    public void checkIfTheIvHasBeenCorrectlyCalculated() throws PokedexException {
        Pokemon Pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        PokemonMetadata PokemonSpecsEspece = pokemonMetadataProvider.getPokemonMetadata(0);
        int PokemonAttack = Pokemon.getAttack() - PokemonSpecsEspece.getAttack();
        int PokemonDefense = Pokemon.getDefense() - PokemonSpecsEspece.getDefense();
        int PokemonStamina = Pokemon.getStamina() - PokemonSpecsEspece.getStamina();
        //int PokemonIv = (int)(Pokemon.getIv()/100)*15;
        /*assertTrue("Le pourcentage d'iv pour l'attaque a mal été calculé", PokemonAttack==PokemonIv);
        assertTrue("Le pourcentage d'iv pour la defense a mal été calculé", PokemonDefense==PokemonIv);
        assertTrue("Le pourcentage d'iv pour l'endurance a mal été calculé", PokemonStamina==PokemonIv);*/
        double ivCalcule = (double) (PokemonAttack + PokemonDefense + PokemonStamina) / 45;
        assertTrue("Le pourcentage de perfection est mal calculé", ivCalcule == Pokemon.getIv());
    }

    @Test
    public void shouldThrowPokedexExceptionWhenTryToCreatePokemonNotInList() {
        assertThrows(PokedexException.class, () -> pokemonFactory.createPokemon(255, 1, 2, 3, 4));
    }

}
