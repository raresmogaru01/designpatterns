import 'package:freezed_annotation/freezed_annotation.dart';
import '../../domain/entities/book.dart';

part 'book_model.freezed.dart';
part 'book_model.g.dart';

@freezed
class BookModel with _$BookModel {
  const BookModel._(); // Allow adding methods and extending

  const factory BookModel({
    int? id,
    required String category,
    required String title,
    required String author,
    required double price,
  }) = _BookModel;

  factory BookModel.fromJson(Map<String, dynamic> json) =>
      _$BookModelFromJson(json);

  // Mapper to Domain Entity
  Book toEntity() {
    return Book(
      id: id,
      category: category,
      title: title,
      author: author,
      price: price,
    );
  }

  // Mapper from Domain Entity
  factory BookModel.fromEntity(Book book) {
    return BookModel(
      id: book.id,
      category: book.category,
      title: book.title,
      author: book.author,
      price: book.price,
    );
  }
}