package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * IPokedex interface. An IPokedex aims to store all information about
 * captured pokemon, as their default metadata as well.
 * @author fv
 */
public class Pokedex implements IPokedex {
    private IPokemonMetadataProvider pmp;
    private IPokemonFactory pf;
    private List<Pokemon> pokemons;

    /**
     * @return pf PokemonFactory
     */
    public IPokemonFactory getPf() {
        return pf;
    }

    /**
     * @return pmp PokemonMetadataProvider
     */
    public IPokemonMetadataProvider getPmp() {
        return pmp;
    }

    /**
     * @param pf PokemonFactory
     */
    public void setPf(IPokemonFactory pf) {
        this.pf = pf;
    }

    /**
     * @param pmp PokemonMetadataProvider
     */
    public void setPmp(IPokemonMetadataProvider pmp) {
        this.pmp = pmp;
    }

    /**
     * @param pokemons List<Pokemon>
     */
    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
    /**
     * Pokedex constructor
     * @param pmp
     * @param pf
     */
    public Pokedex(IPokemonMetadataProvider pmp, IPokemonFactory pf)
    {
        this.pmp=pmp;
        this.pf=pf;
        pokemons = new ArrayList<Pokemon>();
    }
    /** {@inheritDoc} **/
    @Override
    public int size() {
        return pokemons.size();
    }
    /** {@inheritDoc} **/
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size()-1;
    }
    /** {@inheritDoc} **/
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
    /** {@inheritDoc} **/
    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }
    /** {@inheritDoc} **/
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(order);
        return sortedPokemons;
    }
    /** {@inheritDoc} **/
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        return pf.createPokemon(index, cp, hp, dust, candy);
    }
    /** {@inheritDoc} **/
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pmp.getPokemonMetadata(index);
    }
}
