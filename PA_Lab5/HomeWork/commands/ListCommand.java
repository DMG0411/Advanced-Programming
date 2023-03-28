package HomeWork.commands;

import HomeWork.Catalog;
import HomeWork.Document;

public class ListCommand implements Command{
    private Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute(){
        System.out.println("List of documents:");
        for(Document document: catalog.getDocuments()){
            System.out.println(document.getId() + "\t" + document.getName() + "\t" + document.getPath());
        }
    }
}
