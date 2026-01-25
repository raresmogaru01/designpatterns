import 'package:riverpod_annotation/riverpod_annotation.dart';
import '../../domain/entities/book.dart';
import '../../data/repositories/library_repository_impl.dart';

part 'book_notifier.g.dart';

// 1. Provider to fetch all books (Auto-refreshable)
@riverpod
Future<List<Book>> books(BooksRef ref) async {
  final repository = ref.watch(libraryRepositoryProvider);
  return repository.getAllBooks();
}

// 2. Provider for special descriptions (Featured)
@riverpod
Future<List<String>> featuredBooks(FeaturedBooksRef ref) async {
  final repository = ref.watch(libraryRepositoryProvider);
  return repository.getFeaturedBookDescriptions();
}

// 3. Controller for CRUD operations (Side effects)
@riverpod
class BookController extends _$BookController {
  @override
  FutureOr<void> build() {
    // Initial state is void (idle)
  }

  Future<void> addBook(Book book) async {
    state = const AsyncValue.loading();
    state = await AsyncValue.guard(() async {
      await ref.read(libraryRepositoryProvider).addBook(book);
      // Invalidate list to trigger refresh
      ref.invalidate(booksProvider);
    });
  }

  Future<void> updateBook(int id, Book book) async {
    state = const AsyncValue.loading();
    state = await AsyncValue.guard(() async {
      await ref.read(libraryRepositoryProvider).updateBook(id, book);
      ref.invalidate(booksProvider);
    });
  }

  Future<void> deleteBook(int id) async {
    state = const AsyncValue.loading();
    state = await AsyncValue.guard(() async {
      await ref.read(libraryRepositoryProvider).deleteBook(id);
      ref.invalidate(booksProvider);
    });
  }
}