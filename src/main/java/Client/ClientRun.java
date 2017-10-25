package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientRun {
    private JComboBox queriesComboBox;
    private JTextArea textArea;
    private JButton clearButton;
    private JButton enterButton;
    private JPanel mainGUI;
    private JButton exitButton;
    private JTextField searchField;

    private static ClientSocket clientSocket;


    //Quieries combobox
    private String [] comboBox = {"Choose your table", "Lectures"};
    private String selectedItemInComboBox;


    /**
     * Denne kjøres når jg setter opp jframe
     */
    public ClientRun() {

        // Dette er den første som kjøres slik at "Velkommen" vises av server
        selectedItemInComboBox = comboBox[0];
        textArea.setText(clientSocket.sendMessage(selectedItemInComboBox));

        JOptionPane.showMessageDialog(null, "Hei!");


        /**
         * Setter opp config for gui
         */
        configurationGUI();


        /**
         * Når trykker exit, avsluttes etter at connection avsluttes, og programmet lukkes
         */
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientSocket.sendMessage("exit");
                System.exit(1);
            }
        });

        /**
         * Enter button tar imot det som står i combobox og generelt når du skriver inn søke ord
         */
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(selectedItemInComboBox);
                String beskjedSomSkalBliSendt = selectedItemInComboBox + " " + searchField.getText();
                System.out.println("Det jeg ønsker å sende: " + beskjedSomSkalBliSendt);
                textArea.setText(clientSocket.sendMessage(beskjedSomSkalBliSendt));
            }
        });

        /**
         * Dette er action listener til combobox
         */
        queriesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedItemInComboBox = (String) queriesComboBox.getSelectedItem();
                textArea.setText(clientSocket.sendMessage(selectedItemInComboBox));
            }
        });

    }


    /**
     * Setter opp combo box
     */
    private void configurationGUI() {
        textArea.setEditable(false);

        for (int i = 0; i < comboBox.length; i++)
        {
            queriesComboBox.addItem(comboBox[i]);
        }
    }


    /**
     * Kjører jframen
     */
    private static void setUpGUI() {
        JFrame jFrame = new JFrame("Database");
        jFrame.setContentPane(new ClientRun().mainGUI);
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jFrame.setSize(700,500);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                super.windowClosed(e);
                clientSocket.sendMessage("exit");
                System.exit(1);
            }
        });

    }


    /**
     * Main som kjøres
     * @param args
     */
    public static void main(String[] args) {
        clientSocket = new ClientSocket("localhost", 9999);

       setUpGUI();
    }




}