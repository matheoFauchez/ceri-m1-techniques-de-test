package fr.univavignon.pokedex.api;

/**
 * Represents a Pokemon Trainer.
 * A Pokemon Trainer has a name, a team, and a pokedex of captured pokemon.
 *
 * @author fv
 */
public class PokemonTrainer {

    /**
     * Trainer's name.
     **/
    private final String name;

    /**
     * Trainer's team.
     **/
    private final Team team;

    /**
     * Trainer's Pokedex.
     **/
    private final IPokedex pokedex;

    /**
     * Default constructor.
     *
     * @param lname    Trainer's name.
     * @param lteam    Trainer's team.
     * @param lpokedex Trainer's pokedex.
     */
    public PokemonTrainer(final String lname,
                          final Team lteam,
                          final IPokedex lpokedex) {
        this.name = lname;
        this.team = lteam;
        this.pokedex = lpokedex;
    }

    /**
     * Gets the name of the trainer.
     *
     * @return Trainer's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the team of the trainer.
     *
     * @return Trainer's team.
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Gets the pokedex of the trainer.
     *
     * @return Trainer's pokedex.
     */
    public IPokedex getPokedex() {
        return pokedex;
    }
}
