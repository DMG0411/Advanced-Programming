package HomeWork.commands;

import HomeWork.Catalog;
import HomeWork.Document;
import HomeWork.InvalidDataException;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {
    private final int id;
    private final Catalog catalog;

    public ViewCommand(Catalog catalog, int id) {
        this.id = id;
        this.catalog = catalog;
    }

    public Document findDocById(int id){
        for(Document doc : catalog.getDocuments()){
            if(doc.getId() == id){
                return doc;
            }
        }
        return null;
    }

    @Override
    public void execute() throws InvalidDataException, IOException {
        Document doc = findDocById(id);
        if(doc == null){
            throw new InvalidDataException("Document couldn't be found!");
        }
        Desktop.getDesktop().open(new File(doc.getPath()));
    }
}
