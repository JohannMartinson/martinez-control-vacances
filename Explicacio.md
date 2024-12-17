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
"Atenció al client",6,14,20
```
Ens interessa separar la linea amb un split i per els 
departaments agafem la posició [i][0] obtenint:
```
"Atenció al client"
```
Per adaptar la llògica dels dies de vacances haurem
de fer algun tipus de comprovació en algun punt. En el
meu codi obtenia el resultat des de array:
```java
String [][][] arrayCombinacions = {
                {{"Atenció al client"},
                {"menys de un any", "un any", "de dos a sis anys", "set o més anys"},
                {"6", "6", "14", "20"}},
                {{"Logística"},
                {"menys de un any", "un any", "de dos a sis anys", "set o més anys"},
                {"7", "7", "15", "22"}},
                {{"Gerència"},
                {"menys de un any", "un any", "de dos a sis anys", "set o més anys"},
                {"10", "10", "20"," 30"}}
                };
        for(int i = 0; i < arrayCombinacions.length; i++){
            for(int j = 0; j < arrayCombinacions[i][1].length; j++){
                if(nomsDepartaments.equals(arrayCombinacions[i][0][0])){
                    if(anys_treballats.equals(arrayCombinacions[i][1][j])){
                        diesVacances = arrayCombinacions[i][2][j];
                    }
                }
            }
        }
```
Ara aquesta manera de fer-no no té sentit ja que tenim dades més limitades.
S'haura de fer un switch o una serie de if statements que comprovin
els anys_treballats que s'enviin per parametres, en cas de una funcio,
o per variable extreta del Frame directament.
Si son 0-1 any, 2-6anys, o més de 7 anys llavors agafarem la posició
[i][1], [i][2] i [i][3]. 
I amb això hem adaptat la llògica perque llegeixi totes les dades desde fitxer.