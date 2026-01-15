package org.example.creational.factory;

public class HtmlDocument implements Document {
    private final String content;
    public HtmlDocument(String content) { this.content = content; }

    @Override public void open() { System.out.println("Opening Web Browser"); }
    @Override public void save() { System.out.println("Saving as .html"); }
    @Override public String getContent() { return "<html><body>" + content + "</body></html>"; }
}