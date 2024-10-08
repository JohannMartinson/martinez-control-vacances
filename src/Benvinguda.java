import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Aquesta classe representa la finestra de "Benvinguda" on l'usuari pot introduir el seu nom.
public class Benvinguda extends JFrame {
    public static final double AMPLADA_PERCENTATGE = 0.5;  // 50% de l'amplada de la pantalla
    public static final double ALSSADA_PERCENTATGE = 0.8;  // 80% de l'alçada de la pantalla
    public static final int LOGO_WIDTH = 300;
    public static final int LOGO_HEIGHT = 225;
    public static final String TITOL_FINESTRA = "Benvinguda";
    private JLabel jlImatge;            // Etiqueta per mostrar la imatge.
    private JTextField jtfNomUsuari;    // Camp de text on l'usuari escriurà el seu nom.
    private JButton jbEnviar;           // Botó per enviar la informació.
    private JLabel jlEtiquetaNomUsuari; // Etiqueta per mostrar el text que cal entrar al camp.

    public Benvinguda() {
        // Obtenir les dimensions de la pantalla
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        // Calcular la mida de la finestra basada en el percentatge de la mida de la pantalla
        int amplada = (int) (screenSize.width * AMPLADA_PERCENTATGE);
        int alssada = (int) (screenSize.height * ALSSADA_PERCENTATGE);
        double logo_x = (long)Math.floor(amplada /2-LOGO_WIDTH/2);
        int logo_y = 10;
        double etiqueta_nom_usuari_x = Math.floor(amplada /2-LOGO_WIDTH/2);
        double etiqueta_nom_usuari_y =  alssada/2+50;
        double nom_usuari_x = Math.floor(amplada /2-LOGO_WIDTH/2)+200;
        double nom_usuari_y = etiqueta_nom_usuari_y;
        double boto_x = Math.floor(amplada /2-LOGO_WIDTH/2);
        double boto_y = nom_usuari_y+50;

        // Configuració de la finestra (títol, mida, etc.).
        setTitle(TITOL_FINESTRA);
        setSize(amplada, alssada);  // Defineix l'amplada i l'alçada de la finestra relativa a la mida de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Quan es tanca la finestra, es tanca el programa.
        setLocationRelativeTo(null);  // Centra la finestra a la pantalla.

        // Desactivar el layout per defecte i utilitzar null layout
        setLayout(null);

        // Crear els components gràfics (camp de text i botó).
        jlEtiquetaNomUsuari = new JLabel("Introdueix el teu nom:");
        jtfNomUsuari = new JTextField(20);
        jbEnviar = new JButton("Enviar");
        ImageIcon icona = new ImageIcon("src/imatges/nobody_logo.jpg");
        jlImatge = new JLabel(icona);  // Afegeix la imatge a l'etiqueta

        // Establir la posició i mida de cada component manualment amb coordenades
        jlEtiquetaNomUsuari.setBounds((int)etiqueta_nom_usuari_x, (int)etiqueta_nom_usuari_y, 200, 30);
        jtfNomUsuari.setBounds((int)nom_usuari_x, (int)nom_usuari_y, 150, 30);  // (x, y, width, height)
        jbEnviar.setBounds((int)boto_x, (int)boto_y, 100, 30);    // Posició i mida del botó
        jlImatge.setBounds((int)logo_x, logo_y, LOGO_WIDTH, LOGO_HEIGHT);
        // Afegir els components a la finestra
        add(jlEtiquetaNomUsuari);
        add(jtfNomUsuari);
        add(jbEnviar);
        add(jlImatge);

        // Afegir funcionalitat al botó: què passa quan l'usuari fa clic?
        jbEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtenir el text que ha introduït l'usuari al camp de text.
                String entradaNomUsuari = jtfNomUsuari.getText();
                if (!entradaNomUsuari.isEmpty()) {
                    // Si l'usuari ha introduït un nom, obrir la finestra "Resultat" amb aquest nom.
                    new Resultat(entradaNomUsuari);
                } else {
                    // Si el camp de text és buit, mostrar un missatge d'error.
                    JOptionPane.showMessageDialog(Benvinguda.this,
                            "Si us plau, cal que introdueixis una cadena.");
                }
            }
        });

        // Mostrar la finestra.
        setVisible(true);
    }
}
