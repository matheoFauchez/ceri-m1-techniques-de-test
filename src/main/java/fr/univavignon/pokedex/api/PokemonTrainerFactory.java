package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        try
        {
            IPokedex pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());
            return new PokemonTrainer(name, team, pokedex);
        }
        catch (PokedexException p)
        {
            p.printStackTrace();
            return null;
        }

    }
}
