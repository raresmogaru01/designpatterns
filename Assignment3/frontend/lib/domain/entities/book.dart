class Book {
  final int? id; // Nullable for creation, present for retrieval
  final String category;
  final String title;
  final String author;
  final double price;

  const Book({
    this.id,
    required this.category,
    required this.title,
    required this.author,
    required this.price,
  });
}