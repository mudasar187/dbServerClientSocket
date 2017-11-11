package Client;

import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Client run class.</p>
 *
 * @author Mudasar Ahmad
 * @version 1.0
 *
 * Last modified 10 november 2017
 */
public class ClientRun {
    private JComboBox queriesComboBox;
    private JTextArea textArea;
    private JButton enterButton;
    private JPanel mainGUI;
    private JButton exitButton;
    private JTextField searchField;

    private static ClientSocket clientSocket;


    //Queries combobox
    private String [] comboBox = {"Choose options here", "Lectures", "Subject", "Room", "Program", "Availability"};
    private String selectedItemInComboBox;


    /**
     * Constructor
     */
    public ClientRun() {

        selectedItemInComboBox = comboBox[0]; // Runs first so client get "Welcome" message from server
        textArea.setText(clientSocket.sendMessage(selectedItemInComboBox));
        searchField.setEditable(false);
        enterButton.setEnabled(false);

        configurationGUI();


        /**
         * When user enter exit button, clientSocket send an message to server to exit before close the GUI
         */
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientSocket.sendMessage("exit");
                System.exit(1);
            }
        });

        /**
         * Enter button receive whats in comboBox and when you enter some value in searchField
         */
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String messageGoingToBeSent = selectedItemInComboBox + " " + searchField.getText();
                textArea.setText(clientSocket.sendMessage(messageGoingToBeSent));
            }
        });

        /**
         * Action listener to comboBox
         */
        queriesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchField.setText("");
                selectedItemInComboBox = (String) queriesComboBox.getSelectedItem();
                if (!selectedItemInComboBox.equals("Choose options here")) {
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
     * Set up comboBox
     */
    private void configurationGUI() {
        textArea.setEditable(false);

        for (int i = 0; i < comboBox.length; i++)
        {
            queriesComboBox.addItem(comboBox[i]);
        }
    }


    /**
     * Run jFrame
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
                // If client enter 'x' in GUI, send message to exit before closing GUI
                clientSocket.sendMessage("exit");
                System.exit(1);
            }
        });

    }


    /**
     * Main method to run client
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        clientSocket = new ClientSocket("localhost", 9999);

       setUpGUI();
    }




}
