# Rapport TP6

## Implémentation de la classe de la team Rocket

Tout d'abord, on copie la classe dans le package de notre api

## Problèmes remarqués

### Analyse et Execution des tests deja en place

Après avoir executé les tests deja en place et avoir analysé la nouvelle
implémentation on peut se rendre compte de plusieurs problemes/différences

#### Difference de langues

Les noms des pokemons dans la classe RocketPokemonFactory sont en anglais alors
que les notre sont en francais

#### Difference d'index de pokemon

Jusqu'ici le pokemon (bulbizarre) avait l'index 0, or dans cette nouvelle
implémentation, il a l'index 1, l'index 0 correspondants à 'MISSINGNO', servant
d'erreur.
De plus ici, il y a un nouveau pokemon avec un index négatif (-1), ce qui rompt
la règle définie qu'il
ne peut y avoir des pokemons qu'entre 0 et 150, avec MISSINGNO l'indexage est
décalé
de 1 et on a donc maintenant 152 pokemons (de -1 a 151)

#### Gestion des erreurs

L'erreur n'est pas gérée avec une classe d'exception comme nous avons pu le
faire
Mais avec le renvoi d'un pokemon avec index 0 et des statistiques aberrantes (
1000,1000,1000)

#### Calcul de l'indice de perfection (IV)

Précédemment, nous calculions l'iv à partir des 3 valeurs que nous rajoutions
a l'attaque, la défense et l'endurance. Ces 3 valeurs aléatoires entre 0 et 15
une fois additions et la somme divisée par 45 nous donnait le % de perfection du
pokemon.
Ici le IV est a 1 d'office quand le pokemon n'est pas le pikachu de Sacha (0 si
pikachu de Sacha).
Ici l'équivalent de nos 3 valeurs rajoutées sur l'attaque la défense et
l'endurance sont
générées aléatoirement par la fonction generateRandomStat(), dont nous parlerons
plus en détail
plus tard, la principale différence est qu'on ajoute une valeur entre 0 et 100
au lieu
d'une valeur entre 0 et 15

#### Performances???

La fonction generateRandomStat() semble generer une valeur entre 0 et 100 en
utilisant
Random et une boucle for, ce qui me semble excessif. En effet on initialise 1
000 000 de fois
une variable Random pour inserer dans un int une valeur entre 0 et 1, une fois
la boucle
terminée on divise le total par 10 000 et on renvoie le résultat de l'opération.
Il me semble plus adapté de directement generer une valeur aléatoire entre 0 et
100 en faisant
quelque chose comme :

```java
private static int generateRandomStat() {
    return new Random().nextInt(101);
}
```

Ce qui sera surement plus performant en évitant un nombre non négligeable
d'opérations superflues

#### Attaque, défense et endurance

Dans notre implémentation ces 3 statistiques sont définies à partir de :
1 - Les métadonnées de l'espèce d'un pokémon (si c'est un Bulbizarre alors ces
données seront respectivement 126, 126, et 90)
2 - On génère pour chaque statistique une valeur aléatoire entre 0 et 15
3 - On crée notre pokemon avec ses statistiques individuelles (attaque +
ivAttaque, defense + ivDefense, endurance + ivEndurance)

Dans l'implémentation de la team Rocket, nous avons :
1 - Les statistiques d'attaque, défense, et endurance sont une valeur aléatoire
entre 0 et 100 peu importe le pokémon.

On voit donc bien la différence entre ces deux façons de faire, et surtout
que dans la version de la team rocket, que les métadonnées de l'espèce du
pokemon n'ont que peu d'importance.

#### Pas de commentaires

Bien que l'implémentation ai ses défauts, elle est également exempt de
commentaires, ce qui n'est pas une bonne pratique.
Checkstyle qu'on a utilisé au TP précedent relève 24 violations rien que dans
cette nouvelle classe.

## Solutions?

L'implémentation étant bien loin de ce que nos tests avaient prévu, il serait
pratique de refaire une classe de test adaptée à cette implémentation, bien que
la team Rocket ait fourni un code non acceptable/recevable dans le cadre d'un
TDD.

Cette implémentation n'étant pas correcte ni par rapport à notre TDD ni à ce qui
est trouvable sur internet par rapport au pourcentage de perfection et aux
variations d'un individu par rapport a son espèce, une classe de test
RocketPokemonFactoryTest.java sera créée pour tester tous les cas possibles de
cette nouvelle implémentation, et éviter d'avoir à démolir l'ancienne
fonctionnelle pour notre implémentation.

## RocketPokemonFactoryTest.java

Cette nouvelle classe de test devra donc tester :

### Les 3 pokemons créées a partir de pokemons existants

- On vérifie que le pokémon créée quand on entre un index de pokémon connu
  fonctionne bien
    - Par exemple : si on essaie de creer un pokemon avec l'index 1 il devra
      créer un Bulbasaur

### Cas d'erreurs

- On vérifie que si l'index entré dans createPokemon() n'est pas dans notre map
  on renvoie bien le pokémon qui a pour index 0 (MISSINGNO)

### Cas extreme de tests

Cas non nécessaires car non modifiés par les fonctions, on entre une valeur en
paramètre et elle est inscrite telle quelle dans notre objet.

#### Verifier les hp, cp, et candy

Bien que ces valeurs ne soient pas alterées il peut etre 'intéressant' de les
tester pour s'assurer qu'il n'y ai pas de problème en chemin

#### Verifier l'IV

Cette valeur est définie a 0 pour Ash's Pikachu, 1 sinon. L'interet de tester
cette valeur est moindre mais on peut toujours implémenter un test pour.