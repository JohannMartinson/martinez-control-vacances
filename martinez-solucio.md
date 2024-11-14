

# Solució
En el fitxer Benvinguda.java he vaig fer servir una array de tipus string per guardar tots els departaments.
```java
private String [] nomsDepartaments = {"Atenció al client", "Logística", "Gerència"};
```
A sota on s'escriu el contingut del combobox faig servir aquesta array per les tres posicions.

```java
comboBox.addItem(nomsDepartaments[0]);
comboBox.addItem(nomsDepartaments[1]);
comboBox.addItem(nomsDepartaments[2]);
```
# Afegit
En el Resultat.java hi havia una serie de if statements que feien la llògica de quin departament amb quina antiguitat rebien quins dies de vacances.

```java 
 //MANERA MANUAL
        // Comprovació del departament escollit
        if (departament.equals("Atenció al client")) {
            if (anys_treballats.equals("un any") || anys_treballats.equals("menys de un any")) {
                diesVacances = 6;
            } else if (anys_treballats.equals("de dos a sis anys")) {
                diesVacances = 14;
            } else if (anys_treballats.equals("set o més anys")) {
                diesVacances = 20;
            }
        } else if (departament.equals("Logística")) {
            if (anys_treballats.equals("un any") || anys_treballats.equals("menys de un any")) {
                diesVacances = 7;
            } else if (anys_treballats.equals("de dos a sis anys")) {
                diesVacances = 15;
            } else if (anys_treballats.equals("set o més anys")) {
                diesVacances = 22;
            }
        } else if (departament.equals("Gerència")) {
            if (anys_treballats.equals("un any") || anys_treballats.equals("menys de un any")) {
                diesVacances = 10;
            } else if (anys_treballats.equals("de dos a sis anys")) {
                diesVacances = 20;
            } else if (anys_treballats.equals("set o més anys")) {
                diesVacances = 30;
            }
        }
        return "En " + nom_treballador + " " + cognom_treballador + nomsDepartaments + " amb " + anys_treballats + " a l'empresa,  mereix " + diesVacances + " dies de vacances.";
    }
```

# Solució de l'afegit
Al escoltar que ens hauriem d'espavilar per trobar alguna manera de fer-ho més eficient vaig buscar i trobar una manera que es relativament més comode de updatejar:

```java
String diesVacances = "";

        //Intentant fer-ho més procedural
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

Aquí la matriu de tipus String guarda a la primera posició el primer departament, els diferents anys possibles que portes al departament i els anys de vacances que pertoquen.
I a sota fem un bucle for buscant si hi ha coincidencia amb els paràmetres d'entrada.

Cal tenir en compte que, encara que es una matriu tridimensional, només ens calen dos bucles ja que immediatament si el departament coincideix i els anys coinsideixen les vacances son directament les mateixes a la variable 'j'.

