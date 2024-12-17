# Branca martinez-llegir-fitxer-csv
Les instruccions  ens indiquen que hem de
canviar la llògica del nostre programa perque
el càlcul dels dies de vacances a gaudir
s'extreguin des de un fitxer csv, al igual que
els departaments.
Llavors, d'una sola linea del fitxer csv tenim:
"Atenció al client",6,14,20
I amb la nova llògica hem de poguer obtenir
el mateix resultat.

Per fer l'extracció de dades haurem d'incloure una
nova dimensió al for loop utilitzat per afegir els
departaments. Ara, encomptes de nomes la [i] després
de un split o la lectura de una linea sola el que fem
es agafar la posicio [i][0] per obtenir el primer valor
de cada linea. Per tant si el document és:

```
"Atenció al client",6,6,14, 20
"Logística",7, 7, 15, 22
"Gerència",10, 10, 20, 30
```
Quan mirem la posició [i] o la linea com abans obtenim:
```
"Atenció al client",6,6,14, 20
```
Ens interessa separar la linea amb un split i per els 
departaments agafem la posició [i][0] obtenint:
```
"Atenció al client"
```
