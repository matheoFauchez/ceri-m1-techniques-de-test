package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory{

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) throws PokedexException {
        if(metadataProvider!=null && pokemonFactory!=null)
            return new Pokedex(metadataProvider, pokemonFactory);
        else
            throw new PokedexException("Un des parametres est null");
    }
}
