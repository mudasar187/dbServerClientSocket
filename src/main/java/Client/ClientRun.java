package Client;

import javax.swing.*;
import java.awt.event.*;

/**
 * <p>ClientRun class.</p>
 *
 * @author mudasar
 * @version $Id: $Id
 */
public class ClientRun {
    private JComboBox queriesComboBox;
    private JTextArea textArea;
    private JButton enterButton;
    private JPanel mainGUI;
    private JButton exitButton;
    private JTextField searchField;

    private static ClientSocket clientSocket;


    //Quieries combobox
    private String [] comboBox = {"", "Lectures", "Subject", "Room", "Program", "Availability"};
    private String selectedItemInComboBox;


    /**
     * Denne kjøres når jg setter opp jframe
     */
    public ClientRun() {

        // Dette er den første som kjøres slik at "Velkommen" vises av server
        selectedItemInComboBox = comboBox[0];
        textArea.setText(clientSocket.sendMessage(selectedItemInComboBox));
        searchField.setEditable(false);
        enterButton.setEnabled(false);
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
                String messageGoingToBeSent = selectedItemInComboBox + " " + searchField.getText();
                textArea.setText(clientSocket.sendMessage(messageGoingToBeSent));
            }
        });

        /**
         * Dette er action listener til combobox
         */
        queriesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchField.setText("");
                selectedItemInComboBox = (String) queriesComboBox.getSelectedItem();
                if (!selectedItemInComboBox.equals("")) {
                    if (selectedItemInComboBox.equals("Availability")) {
                        searchField.setEditable(false);
                        enterButton.setEnabled(false);
                    } else {
                        searchField.setEditable(true);
                        enterButton.setEnabled(true);
                        searchField.setText(selectedItemInComboBox + ": ");
                    }
                } else {
                    searchField.setEditable(false);
                    enterButton.setEnabled(false);
                }
                textArea.setText(clientSocket.sendMessage(selectedItemInComboBox));
            }
        });

        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (searchField.getText().equals(selectedItemInComboBox + ": ")) {
                    searchField.setText("");
                }
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
        JFrame jFrame = new JFrame("Westerdals Database");
        jFrame.setContentPane(new ClientRun().mainGUI);
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jFrame.setSize(700,500);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
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
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        clientSocket = new ClientSocket("localhost", 9999);

       setUpGUI();
    }




}
