// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'book_notifier.dart';

// **************************************************************************
// RiverpodGenerator
// **************************************************************************

String _$booksHash() => r'ec040e73be65afd800358ccb8508e5561b8bc336';

/// See also [books].
@ProviderFor(books)
final booksProvider = AutoDisposeFutureProvider<List<Book>>.internal(
  books,
  name: r'booksProvider',
  debugGetCreateSourceHash:
      const bool.fromEnvironment('dart.vm.product') ? null : _$booksHash,
  dependencies: null,
  allTransitiveDependencies: null,
);

@Deprecated('Will be removed in 3.0. Use Ref instead')
// ignore: unused_element
typedef BooksRef = AutoDisposeFutureProviderRef<List<Book>>;
String _$featuredBooksHash() => r'549c22def462e703584b0c058e0eb8620bd9dfd0';

/// See also [featuredBooks].
@ProviderFor(featuredBooks)
final featuredBooksProvider = AutoDisposeFutureProvider<List<String>>.internal(
  featuredBooks,
  name: r'featuredBooksProvider',
  debugGetCreateSourceHash: const bool.fromEnvironment('dart.vm.product')
      ? null
      : _$featuredBooksHash,
  dependencies: null,
  allTransitiveDependencies: null,
);

@Deprecated('Will be removed in 3.0. Use Ref instead')
// ignore: unused_element
typedef FeaturedBooksRef = AutoDisposeFutureProviderRef<List<String>>;
String _$bookControllerHash() => r'9aa387b6bcf73718d73fb4aa1351d949668ca7bb';

/// See also [BookController].
@ProviderFor(BookController)
final bookControllerProvider =
    AutoDisposeAsyncNotifierProvider<BookController, void>.internal(
  BookController.new,
  name: r'bookControllerProvider',
  debugGetCreateSourceHash: const bool.fromEnvironment('dart.vm.product')
      ? null
      : _$bookControllerHash,
  dependencies: null,
  allTransitiveDependencies: null,
);

typedef _$BookController = AutoDisposeAsyncNotifier<void>;
// ignore_for_file: type=lint
// ignore_for_file: subtype_of_sealed_class, invalid_use_of_internal_member, invalid_use_of_visible_for_testing_member, deprecated_member_use_from_same_package
