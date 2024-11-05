import javax.swing.*;

// Aquesta classe representa la finestra que mostra la salutació personalitzada.
public class Resultat extends JFrame {

    public Resultat(String nom_treballador, String departament, String anys_treballats) {
        // Configuració de la finestra
        setTitle("Resultat");
        setSize(700, 200);  // Defineix l'amplada i l'alçada de la finestra.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Tanca només aquesta finestra, no tot el programa.
        setLocationRelativeTo(null);  // Centra la finestra a la pantalla.

        // Inicialitzar la variable per guardar la frase del resultat
        String frase_resultat = calcularDiesVacances(nom_treballador, departament, anys_treballats);

        // Crear el missatge amb la salutació correcta i el nom de l'usuari.
        JLabel label = new JLabel(frase_resultat, SwingConstants.CENTER);  // Col·locar el text centrat.

        // Per afegir el missatge a la finestra.
        add(label);

        // Mostrar la finestra.
        setVisible(true);
    }

    private String calcularDiesVacances(String nom_treballador, String departament, String anys_treballats) {
        int diesVacances = 0;

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
        return "En " + nom_treballador + " de " + departament + " amb " + anys_treballats + " a l'empresa,  mereix " + diesVacances + " dies de vacances.";
    }
}
