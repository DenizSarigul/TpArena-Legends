# Arena Legends — README

## Partie 1 — Conditions et boucles

### Pourquoi un `do...while` est-il plus adapté qu'un `while` pour un menu ?

Une boucle `do...while` exécute son contenu au moins une fois avant de vérifier la condition. C'est donc adapté à un menu, car il doit s'afficher au moins une fois pour que l'utilisateur puisse choisir une option. Avec un `while`, la condition est vérifiée avant l'exécution, donc le menu pourrait ne jamais s'afficher si la condition est fausse dès le départ.

## Partie 2 — Tableaux

### Quelle est la différence entre copier un tableau avec `int[] b = a;` et le recopier case par case ? Montrez-le avec un exemple.

Avec `int[] b = a;`, les variables `a` et `b` référencent le même tableau en mémoire. Modifier une case avec `b` modifie donc également le tableau consulté avec `a`.

```java
int[] a = {10, 20, 30};
int[] b = a;

b[0] = 99;
System.out.println(a[0]); // Affiche 99
```

Pour copier les valeurs case par case, il faut créer un nouveau tableau et recopier chaque élément. Les deux tableaux sont alors indépendants.

```java
int[] a = {10, 20, 30};
int[] b = new int[a.length];

for (int i = 0; i < a.length; i++) {
    b[i] = a[i];
}

b[0] = 99;
System.out.println(a[0]); // Affiche 10
```

## Partie 3 — Encapsulation

### Pourquoi un setter `setPv(int pv)` casserait-il l'encapsulation même s'il vérifie les bornes ?

Un setter permettrait de modifier directement les points de vie depuis l'extérieur de la classe. Même s'il vérifie que les PV restent entre 0 et `pvMax`, il contournerait les règles métier prévues dans `subirDegats()` et `soigner()`.

Par exemple, un combattant pourrait récupérer des points de vie sans respecter les règles de soin. Il est donc préférable de contrôler les modifications des PV uniquement grâce aux méthodes prévues à cet effet.

## Partie 4 — Héritage et polymorphisme

### Pourquoi choisir `protected` pour la méthode `subirDegatsBruts(int d)` ?

Le mot-clé `protected` permet à la méthode d'être accessible dans la classe `Combattant`, dans ses sous-classes comme `Mage`, ainsi que dans les classes du même package.

Cela permet au Mage d'infliger des dégâts ignorant la défense sans rendre cette méthode accessible publiquement à tout le programme. Ce choix limite l'accès à cette fonctionnalité tout en permettant son utilisation par les classes concernées.

### Dans `Combattant c = new Mage(...); c.attaquer(x);`, quelle méthode est appelée et pourquoi ? Expliquez la différence entre type déclaré et type réel.

C'est la méthode `attaquer()` de la classe `Mage` qui est appelée, car Java utilise le type réel de l'objet pour déterminer la version d'une méthode redéfinie à exécuter. C'est le principe du polymorphisme.

- **Type déclaré :** `Combattant`. C'est le type de la variable `c`, qui détermine les méthodes accessibles à la compilation.
- **Type réel :** `Mage`. C'est la classe de l'objet créé avec `new Mage(...)`.

La variable est déclarée comme un `Combattant`, mais l'objet qu'elle référence est un `Mage`. La méthode exécutée est donc celle redéfinie dans `Mage`.

## Partie 5 — Listes et tournoi

### Quelle classe gagne le plus souvent après 100 simulations du tournoi ? Est-ce équilibré ?

Pour répondre à cette question, il faut lancer le tournoi 100 fois sans afficher les détails des combats et compter les victoires finales de chaque classe : Guerrier, Mage, Voleur et Paladin.

Les résultats permettront d'identifier la classe qui gagne le plus souvent. Si une classe gagne nettement plus fréquemment que les autres, cela peut indiquer un déséquilibre entre les capacités des combattants.

**Résultats des simulations :**

- Guerrier : à compléter
- Mage : à compléter
- Voleur : à compléter
- Paladin : à compléter

**Conclusion :** à rédiger après avoir comparé les résultats des 100 simulations.

