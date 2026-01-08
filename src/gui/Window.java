package gui;

//Import libraries
import javax.swing.*;
import java.util.HashMap;
import java.awt.Component;
import java.awt.event.ActionListener;
/*
Define an abstract class that outlines how windows can be created within the framework of the application
This is to simplify how the Java Swing library is used within the application
 */
public abstract class Window{
    /*DEFINE ATTRIBUTES*/

    //These hashMaps will be used to link String identifiers to components in the window
    private final JFrame frame = new JFrame();
    private final HashMap<String, JLabel> labels = new HashMap<>();
    private final HashMap<String, JButton> textButtons = new HashMap<>();
    private final HashMap<String, JButton> imageButtons = new HashMap<>();
    private final HashMap<String, JLabel> images = new HashMap<>();

    //Above are common components and below is a general hashMap for components not covered above
    private final HashMap<String, Component> components = new HashMap<>();


    /*DEFINE METHODS*/
    //Define constructor method for the window

    public Window(String title, int x_size, int y_size, String icon_path) {
        frame.setSize(x_size, y_size);

        /*Had help from https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html#setIconImage-java.awt.Image-
        and https://learn-it-university.com/changing-jframe-icon-step-by-step-guide/
        for java images*/
        ImageIcon iconImage = new ImageIcon(icon_path);
        frame.setIconImage(iconImage.getImage());

        frame.setVisible(true);
    }


    //Define a method that adds a label to the frame
    public void addLabel(String identifier, String text, int pos_x, int pos_y, int size_x, int size_y) {
        //Check if that identifier is already in use or not
        if (labels.containsKey(identifier)) {
            //If the identifier is already in use then throw an exception
            throw new IdentifierAlreadyExistsError(identifier, "labels");
        } else {
            //Create the label to the parameters specified if the identifier wasn't already being used
            JLabel label = new JLabel(text);
            label.setBounds(pos_x, pos_y, size_x, size_y);

            //Add the new label to the frame and save it in the frame's Window object
            labels.put(identifier, label);
            frame.add(label);
        }
    }

    //Define a method to get the text displayed by a label
    public String getLabelText(String identifier) {
        //Get the label and return its text
        JLabel label = getLabel(identifier);
        return label.getText();
    }

    //Define a method to change the text displayed by a label
    public void updateLabelText(String identifier, String text) {
        //Get the label and set its text to the new input
        JLabel label = getLabel(identifier);
        label.setText(text);
    }

    //Define a method to add an image to the window
    public void addImage(String identifier, String image_path, int pos_x, int pos_y, int size_x, int size_y) {
        //Check if the identifier is already in use or not
        if (images.containsKey(identifier)) {
            //If the identifier is already in use then throw an exception
            throw new IdentifierAlreadyExistsError(identifier, "images");
        } else {
            //Create the label to the parameters specified if the identifier wasn't already being used
            ImageIcon imageIcon = new ImageIcon(image_path);
            JLabel image = new JLabel(imageIcon);
            image.setBounds(pos_x, pos_y, size_x, size_y);

            //Add the new image to the frame and save it in the frame's Window object
            images.put(identifier, image);
            frame.add(image);
        }
    }

    //Define a method to change an image displayed
    public void changeImage(String identifier, String image_path) {
        //Get the image object
        JLabel image = getImage(identifier);
        //Change the image displayed
        ImageIcon imageIcon = new ImageIcon(image_path);
        image.setIcon(imageIcon);
    }

    //Define a method to create a button with a text label
    public void addTextButton(String identifier, String text, String command, ActionListener listener,
                              int pos_x, int pos_y, int size_x, int size_y) {
        //Check if the identifier is already in use (in both imageButtons and textButtons) - if it is, throw an exception
        if (textButtons.containsKey(identifier)) {
            throw new IdentifierAlreadyExistsError(identifier, "textButtons");
        } else if (imageButtons.containsKey(identifier)) {
            throw new IdentifierAlreadyExistsError(identifier, "imageButtons");
        } else {
            //If the identifier was not in use, create the new image button to the parameters specified
            JButton button = new JButton();
            button.setText(text);
            button.setActionCommand(command);
            button.addActionListener(listener);
            button.setBounds(pos_x, pos_y, size_x, size_y);

            //Add the new button to the frame and save it in the frame's Window object
            frame.add(button);
            textButtons.put(identifier, button);
        }
    }

    //Define a method to create a button with an icon instead of a label
    public void addImageButton(String identifier, String imagePath, String toolTipText, String command, ActionListener listener,
                              int pos_x, int pos_y, int size_x, int size_y) {

        //Check if the identifier is already in use (in both imageButtons and textButtons) - if it is, throw an exception
        if (textButtons.containsKey(identifier)) {
            throw new IdentifierAlreadyExistsError(identifier, "textButtons");
        } else if (imageButtons.containsKey(identifier)) {
            throw new IdentifierAlreadyExistsError(identifier, "imageButtons");
        } else {
            //If the identifier was not in use, create the new image button to the parameters specified
            JButton button = new JButton();
            button.setIcon(new ImageIcon(imagePath));
            button.setToolTipText(toolTipText);
            button.setActionCommand(command);
            button.addActionListener(listener);
            button.setBounds(pos_x, pos_y, size_x, size_y);

            //Add the new button to the frame and save it in the frame's Window object
            frame.add(button);
            imageButtons.put(identifier, button);
        }
    }

    //Define a method to add listeners to a button
    public void addListener(String identifier, ActionListener listener) {
        //Get the button and add the specified listener to it
        JButton button = getButton(identifier);
        button.addActionListener(listener);
    }



    /*DEFINE GETTER METHODS FOR ALL THE FRAME'S COMPONENTS*/
    public JLabel getLabel(String identifier) {
        if (labels.containsKey(identifier)) {
            return labels.get(identifier);
        } else {
            throw new ComponentNotFoundError(identifier, "labels");
        }
    }

    public JLabel getImage(String identifier) {
        if (labels.containsKey(identifier)) {
            return labels.get(identifier);
        } else {
            throw new ComponentNotFoundError(identifier, "labels");
        }
    }

    public JButton getButton(String identifier) {
        //Check to see which hashMap the identifier is in (if it exists)
        boolean textButtonExists = textButtons.containsKey(identifier);
        boolean imageButtonExists = imageButtons.containsKey(identifier);
        if ((!textButtonExists && imageButtonExists) || (textButtonExists && !imageButtonExists)) {
            //If the identifier exists, get the value from the relevant HashMap and add return it
            JButton button;
            if (textButtonExists) {
                button = textButtons.get(identifier);
            } else {
                button = imageButtons.get(identifier);
            }
            return button;
        } else {
            //If the identifier is not in either HashMap, throw an exception
            throw new ComponentNotFoundError(identifier, "textButtons or imageButtons");
        }
    }
}
