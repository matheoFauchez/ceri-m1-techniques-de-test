Mathéo FAUCHEZ ILSEN ALTERNANT

![Checkstyle](https://img.shields.io/badge/checkstyle-176-red)

[![CircleCI](https://dl.circleci.com/status-badge/img/circleci/DAjdGZBoVRXV9MrfLrs7v8/KQSxb7pmpKXr4eLRw7rrSZ/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/circleci/DAjdGZBoVRXV9MrfLrs7v8/KQSxb7pmpKXr4eLRw7rrSZ/tree/master)

[![codecov](https://codecov.io/gh/matheoFauchez/ceri-m1-techniques-de-test/graph/badge.svg?token=6VDI8F05M3)](https://codecov.io/gh/matheoFauchez/ceri-m1-techniques-de-test)

## Un peu de documentation sur l'implementation

Etant donné que nous travaillons en TDD (Test Driven Development) les tests ont été mis en place avant l'implémentation,
je vais donc suivre ce que j'ai défini dans mes classes de tests, mais il peut y avoir des changements (dans les tests et implémentations)
si je le juge nécessaire (ajout de cas d'erreurs par exemple)

### Pokedex

Cette classe nous servira a gerer notre pokedex, elle stockera tout les pokémons capturés par un dresseur (PokemonTrainer)
Son implémentation suivra l'interface et les tests existants
On aura donc :

#### size

Renvoie la taille de notre pokedex (nombre de pokémons inscrits dedans)

#### addPokemon

Ajoute un pokemon dans notre pokedex, renverra une erreur si le pokémon est deja dans le pokedex

#### getPokemon

Renvoie un pokemon du pokedex a partir d'un id passé en parametre, renvoie une erreur si l'id du pokemon est inconnu dans le pokedex

#### getPokemons

Renvoie une liste de tout les pokemons inscrits dans le pokedex

#### getPokemons(Comparator<Pokemon> order)

Renvoie une liste de tout les pokemons inscrits dans le pokedex triée par id, nom ou cp (points de combat)

### PokedexFactory

Cette classe nous servira a créer des pokedex

#### createPokedex

Créée et renvoie un pokedex, si un des paramatres est null alors renvoie une PokedexException

### PokemonFactory

#### createPokemon

Permet de créer un pokemon, récupere ses metadata d'espece (données communes a tout les bulbizarres par exemple) et attribue des nombres aleatoires entre 0 et 15
a l'attaque, défense et l'endurance. Puis calcule l'indice de perfection en additionnant ces 3 valeurs et en divisant la somme par 45 pour obtenir un pourcentage de perfection

### PokemonMetadataProvider

Cette classe nous servira a récuperer les metadata d'un pokemon a partir de son id
Elle stocke egalement les metadata de toutes les especes de pokemons differentes

#### getPokemonMetadata

Cette méthode renvoie les PokemonMetadata d'un pokemon a partir de son id,
les PokemonMetadata étant les statistiques de base commune a tout les pokemons d'une espece (par exemple tout les pikachu)
Doit renvoyer une erreur si 

### PokemonTrainerFactory

Cette classe nous servira a créer des dresseurs pokemons(PokemonTrainer)

#### createTrainer

Cette méthode nous renvoie un dresseur pokemon (PokemonTrainer) qu'elle vient de créer,
elle prend en parametre 3 elements :
- name : le nom du dresseur
- team : l'equipe du dresseur (Team etant un enum)
- pokedexFactory : une factory de pokedex pour pouvoir lui creer un pokedex

## Ajout d'une classe
### PokemonTest
J'ai ajouté cette classe de test afin de tester la classe Pokemon et d'avoir un meilleur pourcentage de couverture de code

# README ORIGINAL :

# UCE Génie Logiciel Avancé : Techniques de tests

## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.
