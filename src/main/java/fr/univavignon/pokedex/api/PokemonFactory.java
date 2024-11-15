package fr.univavignon.pokedex.api;

import java.util.Random;

public class PokemonFactory implements IPokemonFactory{
    PokemonMetadataProvider pmp;

    public PokemonFactory()
    {
        pmp = new PokemonMetadataProvider();
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try
        {
            PokemonMetadata pm = pmp.getPokemonMetadata(index);
            Random rdm = new Random();
            int ivAttack = rdm.nextInt(16);
            int ivDefense = rdm.nextInt(16);
            int ivStamina = rdm.nextInt(16);
            double iv = (double) (ivAttack + ivDefense + ivStamina) /45;
            return new Pokemon(index, pm.getName(), pm.getAttack()+ivAttack, pm.getDefense()+ivDefense,
                    pm.getStamina()+ivStamina, cp, hp, dust, candy, iv);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
