package LabWork;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Document {

    private String title;
    private String author;
    private String path;

    public Document(String title, String author, String path) {
        this.title = title;
        this.author = author;
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Path: " + path;
    }
}
