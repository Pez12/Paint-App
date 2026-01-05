package gui;

//Import libraries
import javax.swing.*;
import java.util.HashMap;
import java.awt.Component;
/*
Define an abstract class that outlines how windows can be created within the framework of the application
This is to simplify how the Java Swing library is used within the application
 */
public abstract class Window{
    /*DEFINE ATTRIBUTES*/

    //These hashMaps will be used to link String identifiers to components in the window
    private final JFrame frame = new JFrame();
    private final HashMap<String, JLabel> labels = new HashMap<>();
    private final HashMap<String, JButton> buttons = new HashMap<>();
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
        JLabel label = new JLabel(text);
        label.setBounds(pos_x, pos_y, size_x, size_y);

        labels.put(identifier, label);
        frame.add(label);
    }

    //Define a method to get the text displayed by a label
    public String getLabelText(String identifier) {
        try {
            return labels.get(identifier).getText();
        } catch (NullPointerException e) {
            throw new ComponentNotFoundError(identifier, "labels");
        }
    }

    //Define a method to change the text displayed by a label
    public void updateLabelText(String identifier, String text) {
        try {
            labels.get(identifier).setText(text);
        } catch (NullPointerException e) {
            throw new ComponentNotFoundError(identifier, "labels");
        }
    }

    //Define a method to add an image to the window
    public void addImage(String identifier, String image_path, int pos_x, int pos_y, int size_x, int size_y) {
        ImageIcon image = new ImageIcon(image_path);
        JLabel imageLabel = new JLabel(image);

        imageLabel.setBounds(pos_x, pos_y, size_x, size_y);
        images.put(identifier, imageLabel);
        frame.add(imageLabel);
    }



}
