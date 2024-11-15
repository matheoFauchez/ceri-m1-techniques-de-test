package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        try
        {
            PokemonMetadataProvider pmp = new PokemonMetadataProvider();
            PokemonFactory pf = new PokemonFactory();
            IPokedex pokedex = pokedexFactory.createPokedex(pmp, pf);
            return new PokemonTrainer(name, team, pokedex);
        }
        catch (PokedexException pe)
        {
            pe.printStackTrace();
            return null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
