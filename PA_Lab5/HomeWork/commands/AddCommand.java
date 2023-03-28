package HomeWork.commands;

import HomeWork.Catalog;
import HomeWork.Document;
import HomeWork.InvalidDataException;

public class AddCommand implements Command {
    private final Catalog catalog;
    private int id;
    private String name;
    private String path;

    public AddCommand(Catalog catalog, int id, String name, String path) {
        this.catalog = catalog;
        this.id = id;
        this.name = name;
        this.path = path;
    }

    @Override
    public void execute() throws InvalidDataException {
        if(id <= 0 || name.isEmpty() || path.isEmpty()){
            throw new InvalidDataException("Invalid document data.");
        }
        Document doc = new Document(id,name,path);
        catalog.addDocument(doc);
    }
}
