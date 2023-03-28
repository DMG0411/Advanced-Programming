package HomeWork;

import java.util.*;
public class Catalog {
    private final List<Document> documents = new ArrayList<>();

    public void addDocument(Document document){
        documents.add(document);
    }

    public List<Document> getDocuments(){
        return documents;
    }
}
