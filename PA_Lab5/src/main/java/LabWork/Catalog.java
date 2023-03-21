package LabWork;

import java.util.*;

public class Catalog {

    private List<Document> documents;

    public Catalog() {
        documents = new ArrayList<>();
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void add(Document doc) {
        documents.add(doc);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Catalog:\n");
        for (Document doc : documents) {
            sb.append(doc.toString()).append("\n");
        }
        return sb.toString();
    }
}
