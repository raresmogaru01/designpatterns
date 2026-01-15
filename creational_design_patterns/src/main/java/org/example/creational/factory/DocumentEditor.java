package org.example.creational.factory;

import java.util.Scanner;

public class DocumentEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter document type (pdf, word, html): ");
        String type = scanner.nextLine();

        System.out.print("Enter document content: ");
        String content = scanner.nextLine();

        try {
            // factory pattern in action
            Document doc = DocumentFactory.createDocument(type, content);

            doc.open();
            System.out.println(doc.getContent());
            doc.save();

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}