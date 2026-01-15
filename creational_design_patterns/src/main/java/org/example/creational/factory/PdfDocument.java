package org.example.creational.factory;

public class PdfDocument implements Document {
    private final String content;
    public PdfDocument(String content) { this.content = content; }

    @Override public void open() { System.out.println("Opening PDF Viewer"); }
    @Override public void save() { System.out.println("Saving as .pdf"); }
    @Override public String getContent() { return "PDF Content: " + content; }
}