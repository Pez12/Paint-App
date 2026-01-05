//Import Packages
import gui.*;
import java.util.HashMap;
import javax.swing.JLabel;

//Define a Main class which will execute the application
public class Main {
    //Define a main method to be executed
    public static void main (String[] args) {
        //Test to see what happens if a key is entered into a hashMap that is already in use
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "1");
        System.out.println(map.get(1));
        map.put(1, "2");
        System.out.println(map.get(1));
    }
}
