package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{

    IPokemonMetadataProvider pmp;
    IPokemonFactory pf;

    List<Pokemon> pokemons;

    public Pokedex(IPokemonMetadataProvider pmp, IPokemonFactory pf)
    {
        this.pmp=pmp;
        this.pf=pf;
        pokemons = new ArrayList<Pokemon>();
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size()-1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for(Pokemon p : pokemons)
        {
            if(p.getIndex()==id)
            {
                return p;
            }
        }
        throw new PokedexException("Pokemon introuvable");
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(order);
        return sortedPokemons;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pf.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pmp.getPokemonMetadata(index);
    }
}
