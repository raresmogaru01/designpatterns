package org.example.creational.factory;

public class DocumentFactory {

    public static Document createDocument(String type, String content) {
        if (type == null) return null;

        switch (type.toLowerCase()) {
            case "pdf":
                return new PdfDocument(content);
            case "word":
                return new WordDocument(content);
            case "html":
                return new HtmlDocument(content);
            default:
                throw new IllegalArgumentException("Unknown document type: " + type);
        }
    }
}