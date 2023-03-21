package LabWork;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CatalogUtil {

    public CatalogUtil() {
    }

    public void save(Catalog catalog, String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(path),catalog);
    }

    public void load(String path) throws InvalidCatalogException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readValue(new File(path),Catalog.class);
        } catch (IOException e) {
            throw new InvalidCatalogException(e);
        }
    }
}
