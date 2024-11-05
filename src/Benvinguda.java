    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
    import java.util.*;

    // Aquesta classe representa la finestra de "Benvinguda" on l'usuari pot introduir el seu nom.
    public class Benvinguda extends JFrame {
        public static final double AMPLADA_PERCENTATGE = 0.5;  // 50% de l'amplada de la pantalla
        public static final double ALSSADA_PERCENTATGE = 0.8;  // 80% de l'alçada de la pantalla
        public static final int LOGO_WIDTH = 300;
        public static final int LOGO_HEIGHT = 225;
        public static final String TITOL_FINESTRA = "Benvinguda";
        private JLabel jlImatge;            // Etiqueta per mostrar la imatge.
        private JTextField jtfNomUsuari;    // Camp de text on l'usuari escriurà el seu nom.
        private JTextField jtfCognomUsuari;    // Camp de text on l'usuari escriurà el seu cognom.
        private JButton jbEnviar;           // Botó per enviar la informació.
        private JLabel jlEtiquetaNomUsuari; // Etiqueta per mostrar el text que cal entrar al camp.
        private JLabel jlEtiquetaCognomUsuari; // Etiqueta per mostrar el text que cal entrar al camp.
        private JLabel jlEtiquetaDepartament; // Etiqueta per mostrar el text que cal entrar al camp.
        private JLabel jlEtiquetaAnys;
        //Combo box
        private JComboBox<String> comboBox;

        private JRadioButton jRadioButton1;
        private JRadioButton jRadioButton2;
        private JRadioButton jRadioButton3;
        private JRadioButton jRadioAnys1;
        private JRadioButton jRadioAnys2;
        private JRadioButton jRadioAnys3;
        private JRadioButton jRadioAnys4;
        private JRadioButton jRadioAnys5;
        private JLabel jlTitolApp;
        private JLabel jlNomEmpresa;
        private String [] departaments = {"Atenció al client", "Logística", "Gerència"};


        public Benvinguda() {
            // Obtenir les dimensions de la pantalla
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();

            setResizable(false);

            // Calcular la mida de la finestra basada en el percentatge de la mida de la pantalla
            int amplada = (int) (screenSize.width * AMPLADA_PERCENTATGE);
            int alssada = (int) (screenSize.height * ALSSADA_PERCENTATGE);
            double logo_x = (long) Math.floor(amplada / 2 - LOGO_WIDTH / 2);
            int logo_y = 10;
            double etiqueta_nom_usuari_x = Math.floor(amplada / 2 - LOGO_WIDTH / 2);
            double etiqueta_nom_usuari_y = alssada / 2 - 50;
            double nom_usuari_x = Math.floor(amplada / 2 - LOGO_WIDTH / 2) + 200;
            double nom_usuari_y = etiqueta_nom_usuari_y;
            double boto_x = (amplada / 3);
            double boto_y = (alssada - 150);

            // Configuració de la finestra (títol, mida, etc.).
            setTitle(TITOL_FINESTRA);
            setSize(amplada, alssada);  // Defineix l'amplada i l'alçada de la finestra relativa a la mida de la pantalla
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Quan es tanca la finestra, es tanca el programa.
            setLocationRelativeTo(null);  // Centra la finestra a la pantalla.

            // Desactivar el layout per defecte i utilitzar null layout
            setLayout(null);

            // Crear els components gràfics (camp de text i botó).
            jlEtiquetaNomUsuari = new JLabel("Introdueix el teu nom:");
            jlEtiquetaCognomUsuari = new JLabel("Introdueix el teu cognom:");
            jlEtiquetaDepartament = new JLabel("Departament");
            jlEtiquetaAnys = new JLabel("Anys a l'empresa");

            jtfNomUsuari = new JTextField(20);
            jtfCognomUsuari = new JTextField(20);
            jbEnviar = new JButton("Enviar");
            ImageIcon icona = new ImageIcon("src/imatges/nobody_logo.jpg");
            jlImatge = new JLabel(icona);  // Afegeix la imatge a l'etiqueta
            comboBox = new JComboBox<String>();

            //Iniciar els grups on es posen els butons
            ButtonGroup G = new ButtonGroup();
            ButtonGroup G2 = new ButtonGroup();

            // Iniciar els botons per el departament
            jRadioButton1 = new JRadioButton(departaments[0]);
            jRadioButton2 = new JRadioButton(departaments[1]);
            jRadioButton3 = new JRadioButton(departaments[2]);

            // Iniciar els botons per l'any
            jRadioAnys1 = new JRadioButton("Menys de un any");
            jRadioAnys2 = new JRadioButton("Un any");
            jRadioAnys3 = new JRadioButton("Dos anys");
            jRadioAnys4 = new JRadioButton("Tres anys");
            jRadioAnys5 = new JRadioButton("Més de tres anys");

            jlTitolApp = new JLabel("Sistema de Control de Vacances");
            jlNomEmpresa = new JLabel("2024 - Nobody S.A.");

            // Establir la posició i mida de cada component manualment amb coordenades
            jlEtiquetaNomUsuari.setBounds((int) etiqueta_nom_usuari_x, (int) etiqueta_nom_usuari_y, 200, 30);
            jlEtiquetaCognomUsuari.setBounds((int) etiqueta_nom_usuari_x, (int) etiqueta_nom_usuari_y+35, 200, 30);
            jlEtiquetaDepartament.setBounds((int) etiqueta_nom_usuari_x, (int) etiqueta_nom_usuari_y+75, 200, 30);
            jlEtiquetaAnys.setBounds((int) etiqueta_nom_usuari_x+200, (int) etiqueta_nom_usuari_y+75, 200, 30);
            jlNomEmpresa.setBounds((int) amplada-20, (int) alssada-10, 200, 30);
            jlTitolApp.setBounds((int) etiqueta_nom_usuari_x, (int) etiqueta_nom_usuari_y - 50, 200, 30);
            jtfNomUsuari.setBounds((int) nom_usuari_x, (int) nom_usuari_y, 150, 30);  // (x, y, width, height)
            jtfCognomUsuari.setBounds((int) nom_usuari_x, (int) nom_usuari_y+30, 150, 30);  // (x, y, width, height)
            jbEnviar.setBounds((int) boto_x, (int) boto_y, 100, 30);    // Posició i mida del botó
            jlImatge.setBounds((int) logo_x, logo_y, LOGO_WIDTH, LOGO_HEIGHT);
            jRadioButton1.setBounds((int) etiqueta_nom_usuari_x, (int) etiqueta_nom_usuari_y + 100, 200, 30);
            jRadioButton2.setBounds((int) etiqueta_nom_usuari_x, (int) etiqueta_nom_usuari_y + 125, 200, 30);
            jRadioButton3.setBounds((int) etiqueta_nom_usuari_x, (int) etiqueta_nom_usuari_y + 150, 200, 30);
            //jRadioAnys1.setBounds((int) etiqueta_nom_usuari_x+200, (int) etiqueta_nom_usuari_y + 100, 200, 30);
            //jRadioAnys2.setBounds((int) etiqueta_nom_usuari_x+200, (int) etiqueta_nom_usuari_y + 125, 200, 30);
            //jRadioAnys3.setBounds((int) etiqueta_nom_usuari_x+200, (int) etiqueta_nom_usuari_y + 150, 200, 30);
            //jRadioAnys4.setBounds((int) etiqueta_nom_usuari_x+200, (int) etiqueta_nom_usuari_y + 175, 200, 30);
            //jRadioAnys5.setBounds((int) etiqueta_nom_usuari_x+200, (int) etiqueta_nom_usuari_y + 200, 200, 30);
            comboBox.setBounds((int) etiqueta_nom_usuari_x+200, (int) etiqueta_nom_usuari_y+75, 200, 30);

            add(comboBox);

            comboBox.addItem("menys de un any");
            comboBox.addItem("un any");
            comboBox.addItem("de dos a sis anys");
            comboBox.addItem("set o més anys");

            // Afegir els components a la finestra
            add(jlEtiquetaNomUsuari);
            add(jlEtiquetaCognomUsuari);
            add(jlEtiquetaDepartament);
            add(jlEtiquetaAnys);
            add(jlNomEmpresa);
            add(jlTitolApp);
            add(jtfNomUsuari);
            add(jtfCognomUsuari);
            add(jbEnviar);
            add(jlImatge);
            G.add(jRadioButton1);
            G.add(jRadioButton2);
            G.add(jRadioButton3);
            add(jRadioButton1);
            add(jRadioButton2);
            add(jRadioButton3);

            // Afegir funcionalitat al botó: què passa quan l'usuari fa clic?
            jbEnviar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    String entradaDepartament = "";
                    //Obtenir els anys seleccionats en el desplegable
                    String anysTreballats = (String) comboBox.getSelectedItem();
                    //Obtenir el valor introduit en el JFT Nom
                    String nomTreballador = jtfNomUsuari.getText();

                    // Obtenir el text que ha introduït l'usuari al camp de text.
                    if (jRadioButton1.isSelected()) {
                        entradaDepartament = jRadioButton1.getText();
                        //Comprovació per pantalla que la variable es guarda correctmaent
                        //JOptionPane.showMessageDialog(Benvinguda.this,entradaDepartament);
                    } else if (jRadioButton2.isSelected()) {
                        entradaDepartament = jRadioButton2.getText();
                    } else if (jRadioButton3.isSelected()) {
                        entradaDepartament = jRadioButton3.getText();
                    }
                    //Comprovar si totes les dades han estat introduides
                    if (anysTreballats!= null && !entradaDepartament.isEmpty() && !nomTreballador.isEmpty())  {
                        // Si l'usuari ha introduït un nom, obrir la finestra "Resultat" amb aquest nom.
                        new Resultat(nomTreballador, entradaDepartament, anysTreballats);
                    } else {
                        //Mostrant missatge d'error si falta el nom
                        if(nomTreballador.isEmpty()){
                            // Si el camp de text és buit, mostrar un missatge d'error
                            JOptionPane.showMessageDialog(Benvinguda.this,
                                    "Si us plau, cal que introdueixis un nom.");

                        }
                        //Mostrant missatges d'error si falta el departament
                        if(entradaDepartament.isEmpty()){
                            // Si el departament no ha estat triat
                            JOptionPane.showMessageDialog(Benvinguda.this,
                                    "Cal que triïs un departament.");
                        }
                    }
                }
            });

            // Mostrar la finestra.
            setVisible(true);
        }
    }
