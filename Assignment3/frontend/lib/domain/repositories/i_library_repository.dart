import '../entities/book.dart';

abstract class ILibraryRepository {
  Future<List<Book>> getAllBooks();
  Future<Book> getBookById(int id);
  Future<Book> addBook(Book book);
  Future<Book> updateBook(int id, Book book);
  Future<void> deleteBook(int id);
  Future<List<Book>> getBooksByCategory(String category);

  // Specific decorated endpoints returning descriptions
  Future<List<String>> getFeaturedBookDescriptions();
  Future<List<String>> getBestsellerBookDescriptions();
}