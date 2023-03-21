package LabWork;

import java.io.IOException;

public class Main {
        public static void main(String[] args) {
                Document document = new Document("Title of a book","Nimeni","catalog.txt");
                Catalog catalog = new Catalog();
                catalog.add(document);
                CatalogUtil util = new CatalogUtil();
                try {
                        System.out.println("Saving catalog...");
                        util.save(catalog,"catalog.json");
                        System.out.println("Load the catalog...");
                        util.load("catalog.json");
                } catch (IOException e) {
                        System.out.println("Something wrong happened on saving");
                } catch (InvalidCatalogException e) {
                        System.out.println("Something wrong happened on loading:" +e);
                }
        }
}