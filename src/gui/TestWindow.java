package gui;

//Import packages

import javax.swing.*;
import java.awt.event.*;


//Define a class that displays a test window (used for prototyping the GUI and getting familiar with the swing and awt libraries)

//Had help from this tutorial: https://www.geeksforgeeks.org/java/introduction-to-java-swing/
//Learnt about Jbuttons from: https://docs.oracle.com/javase/tutorial/uiswing/components/button.html


public class TestWindow extends Window implements ActionListener {

    //Define Constructor Method
    public TestWindow() {
        super("Test Window", 500, 500, "test-image.png");

    }

    public void actionPerformed(ActionEvent event) {

    }

}
