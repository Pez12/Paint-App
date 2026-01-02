package gui;

//Import packages

import javax.swing.*;
import java.awt.event.*;


//Define a class that displays a test window (used for prototyping the GUI and getting familiar with the swing and awt libraries)

//Had help from this tutorial: https://www.geeksforgeeks.org/java/introduction-to-java-swing/
//Learnt about Jbuttons from: https://docs.oracle.com/javase/tutorial/uiswing/components/button.html


public class TestWindow implements ActionListener {

    private JButton[] buttons = new JButton[2];

    //Define Constructor Method
    public TestWindow() {
        //Set up the frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.setSize(500, 500);
        frame.setVisible(true);

        //Add a Hello World label
        JLabel label = new JLabel("Hello, World!");
        label.setBounds(100, 100, 100, 100);
        frame.add(label);

        //Add a test button
        buttons[0] = new JButton("Enable");
        buttons[0].setBounds(100, 200, 100, 100);
        buttons[0].setToolTipText("Enable");
        buttons[0].setActionCommand("EnableButton2");
        buttons[0].addActionListener(this);
        frame.add(buttons[0]);

        //Add a second test button
        buttons[1] = new JButton("Disable");
        buttons[1].setBounds(200, 200, 100, 100);
        buttons[1].setToolTipText("Disable");
        buttons[1].setActionCommand("DisableButton2");
        frame.add(buttons[1]);
        buttons[1].setEnabled(false);
        buttons[1].addActionListener(this);

    }

    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("EnableButton2")) {
            System.out.println("Enable Button 2");
            buttons[1].setEnabled(true);
        } else {
            System.out.println("Disable Button 2");
            buttons[1].setEnabled(false);
        }
    }

}
