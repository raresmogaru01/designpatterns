import 'package:dio/dio.dart';
import 'package:riverpod_annotation/riverpod_annotation.dart';
import '../../core/constants/api_constants.dart';
import '../../core/errors/failure.dart';
import '../../core/network/dio_provider.dart';
import '../../domain/entities/book.dart';
import '../../domain/repositories/i_library_repository.dart';
import '../models/book_model.dart';

part 'library_repository_impl.g.dart';

class LibraryRepositoryImpl implements ILibraryRepository {
  final Dio _dio;

  LibraryRepositoryImpl(this._dio);

  @override
  Future<List<Book>> getAllBooks() async {
    try {
      // CHANGED: Removed the '/' inside get(). Use empty string '' instead.
      final response = await _dio.get('');
      final List data = response.data;
      return data.map((json) => BookModel.fromJson(json).toEntity()).toList();
    } on DioException catch (e) {
      throw Failure(e.message ?? 'Failed to fetch books', statusCode: e.response?.statusCode);
    }
  }

  @override
  Future<Book> getBookById(int id) async {
    try {
      final response = await _dio.get('/$id');
      return BookModel.fromJson(response.data).toEntity();
    } on DioException catch (e) {
      throw Failure('Failed to fetch book $id', statusCode: e.response?.statusCode);
    }
  }

  @override
  Future<Book> addBook(Book book) async {
    try {
      final model = BookModel.fromEntity(book);
      // CHANGED: Removed the '/' inside post(). Use empty string '' instead.
      final response = await _dio.post('', data: model.toJson());
      return BookModel.fromJson(response.data).toEntity();
    } on DioException catch (e) {
      throw Failure('Failed to add book', statusCode: e.response?.statusCode);
    }
  }

  @override
  Future<Book> updateBook(int id, Book book) async {
    try {
      final model = BookModel.fromEntity(book);
      final response = await _dio.put('/$id', data: model.toJson());
      return BookModel.fromJson(response.data).toEntity();
    } on DioException catch (e) {
      throw Failure('Failed to update book', statusCode: e.response?.statusCode);
    }
  }

  @override
  Future<void> deleteBook(int id) async {
    try {
      await _dio.delete('/$id');
    } on DioException catch (e) {
      throw Failure('Failed to delete book', statusCode: e.response?.statusCode);
    }
  }

  @override
  Future<List<Book>> getBooksByCategory(String category) async {
    try {
      final response = await _dio.get('${ApiConstants.categoryEndpoint}/$category');
      final List data = response.data;
      return data.map((json) => BookModel.fromJson(json).toEntity()).toList();
    } on DioException catch (e) {
      throw Failure('Failed to fetch category $category', statusCode: e.response?.statusCode);
    }
  }

  @override
  Future<List<String>> getFeaturedBookDescriptions() async {
    try {
      final response = await _dio.get(ApiConstants.featuredEndpoint);
      return List<String>.from(response.data);
    } on DioException catch (e) {
      throw Failure('Failed to fetch featured books', statusCode: e.response?.statusCode);
    }
  }

  @override
  Future<List<String>> getBestsellerBookDescriptions() async {
    try {
      final response = await _dio.get(ApiConstants.bestsellersEndpoint);
      return List<String>.from(response.data);
    } on DioException catch (e) {
      throw Failure('Failed to fetch bestsellers', statusCode: e.response?.statusCode);
    }
  }
}

@riverpod
ILibraryRepository libraryRepository(LibraryRepositoryRef ref) {
  final dio = ref.watch(dioProvider);
  return LibraryRepositoryImpl(dio);
}