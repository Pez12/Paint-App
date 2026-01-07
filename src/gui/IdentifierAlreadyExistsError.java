package gui;

public class IdentifierAlreadyExistsError extends RuntimeException {
    public IdentifierAlreadyExistsError(String identifier, String mapName) {
        super("Error, Identifier '" + identifier + "' already exists in " + mapName);
    }
}
