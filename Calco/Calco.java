
/*                  IMPORTATIONS                 */
import java.awt.Font;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*                  DEFINITIONS DE LA CLASSE ET DE SES ATTRIBUTS */
public class Calco implements ActionListener {
    JFrame frame;
    JTextField textfield;

    JButton tableau_number[] = new JButton[10];// pour stoquer tous nos nombres
    JButton tableau_operateur[] = new JButton[9]; // pour stoquer les caracteres

    JButton addButton, SubButton, mulButton, divButton, decButton, equButton, delButton, ClrButton,
            negButton = new JButton();// je cree mes bouton d'operations
    JPanel panel;

    /* font family */
    Font myFont = new Font("ink free", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    /* DEFINITIONS DU CONSTRUCTEUR */

    public Calco() {

        /* PARAMETRE GENERAUX DE LA FENETRE */
        frame = new JFrame("Creat a java calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        /* PARAMETRES DU TEXTFIELD */
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);// si le texte doit prend tout l'espace de la fieldliste ou non

        /* INSTANTIACION DES BOUTONS A LA FENETRE */
        /* BOUTONS DES CARACTERES */
        addButton = new JButton("+");
        SubButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        ClrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        /* BOUTONS DES CARACTERES */
        tableau_operateur[0] = addButton;
        tableau_operateur[1] = SubButton;
        tableau_operateur[2] = mulButton;
        tableau_operateur[3] = divButton;
        tableau_operateur[4] = decButton;
        tableau_operateur[5] = equButton;
        tableau_operateur[6] = delButton;
        tableau_operateur[7] = ClrButton;
        tableau_operateur[8] = negButton;

        for (int i = 0; i < 9; i++) {
            tableau_operateur[i].addActionListener(this);// pour specifier ses objet(caracteres)
            tableau_operateur[i].setFont(myFont);// changer la police de mes caracteres
            tableau_operateur[i].setFocusable(false);// lorque on clique sur ca
        }

        for (int i = 0; i < 10; i++) {
            tableau_number[i] = new JButton(String.valueOf(i));
            tableau_number[i].addActionListener(this);
            tableau_number[i].setFocusable(false);
        }

        /* MODIFIATION DE CERTAINS BOUTONS */
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        ClrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));// espace entre les boutons

        /* AJOUT DES BOUTONS SUR LA FENETRE EN ODRE */
        panel.add(tableau_number[1]);
        panel.add(tableau_number[2]);
        panel.add(tableau_number[3]);
        panel.add(addButton);
        panel.add(tableau_number[4]);
        panel.add(tableau_number[5]);
        panel.add(tableau_number[6]);
        panel.add(SubButton);
        panel.add(tableau_number[7]);
        panel.add(tableau_number[8]);
        panel.add(tableau_number[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(tableau_number[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);// on ajoute tous les boutons a la panel
        frame.add(negButton);
        frame.add(delButton);
        frame.add(ClrButton);
        frame.add(textfield);
        frame.setVisible(true);

    }

    /* DEFINITIONS DES METHODES DE CALCUL */

    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == tableau_number[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());// valeur entrer par l'utilisateur
            operator = '+';
            textfield.setText("");
        }

        if (e.getSource() == SubButton) {
            num1 = Double.parseDouble(textfield.getText());// valeur entrer par l'utilisateur
            operator = '-';
            textfield.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
            }

            textfield.setText(String.valueOf(result));
            num1 = result;

        }

        if (e.getSource() == ClrButton) {
            textfield.setText("");
        }

        if (e.getSource() == delButton) {
            String str = textfield.getText();
            textfield.setText("");

            for (int i = 0; i < str.length() - 1; i++) {

                textfield.setText(textfield.getText() + str.charAt(i));
            }
        }

        if (e.getSource() == negButton) {
            double temps = Double.parseDouble(textfield.getText());
            temps *= -1;
            textfield.setText(String.valueOf(temps));
        }

    }
}
