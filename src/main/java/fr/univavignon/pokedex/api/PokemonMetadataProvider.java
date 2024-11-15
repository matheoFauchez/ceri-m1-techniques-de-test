package fr.univavignon.pokedex.api;

import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider
{
    PokemonMetadata bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
    PokemonMetadata aquali = new PokemonMetadata(133, "Aquali", 186, 168, 260);
    PokemonMetadata[] listeMetadata= {bulbizarre, aquali};
    public int nbPokemonMetadata = 2;

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        for(int i = 0; i<nbPokemonMetadata; i++)
        {
            if(listeMetadata[i].getIndex()==index)
            {
                return listeMetadata[i];
            }
        }
        throw new PokedexException("Pokemon introuvable");
    }
}
