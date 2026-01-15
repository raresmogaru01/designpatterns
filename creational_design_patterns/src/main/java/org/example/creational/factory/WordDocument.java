package org.example.creational.factory;

public class WordDocument implements Document {
    private final String content;
    public WordDocument(String content) { this.content = content; }

    @Override public void open() { System.out.println("Opening MS Word"); }
    @Override public void save() { System.out.println("Saving as .docx"); }
    @Override public String getContent() { return "Word Content: " + content; }
}