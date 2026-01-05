package gui;

//Learnt about custom exceptions from: https://www.geeksforgeeks.org/java/user-defined-custom-exception-in-java/

//Define a custom exception for if a container is not found
public class ComponentNotFoundError extends RuntimeException {
    public ComponentNotFoundError(String identifier, String mapName) {
        super("Error, Identifier '" + identifier + "' was not found in " + mapName);
    }
}
