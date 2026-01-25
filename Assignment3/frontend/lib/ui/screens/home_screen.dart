import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../../domain/entities/book.dart';
import '../../logic/book_notifier.dart';
import 'book_form_screen.dart';

class HomeScreen extends ConsumerWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final booksAsync = ref.watch(booksProvider);
    final featuredAsync = ref.watch(featuredBooksProvider);

    // Listen for side-effect errors (like delete failure)
    ref.listen(bookControllerProvider, (previous, next) {
      if (next.hasError) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('Error: ${next.error}')),
        );
      }
    });

    return Scaffold(
      appBar: AppBar(title: const Text('Library Manager')),
      body: CustomScrollView(
        slivers: [
          // Featured Section
          SliverToBoxAdapter(
            child: featuredAsync.when(
              data: (list) => _FeaturedList(descriptions: list),
              loading: () => const LinearProgressIndicator(),
              error: (e, _) => SizedBox.shrink(), // Silent error for featured
            ),
          ),

          // Main Book List
          booksAsync.when(
            data: (books) => SliverList(
              delegate: SliverChildBuilderDelegate(
                    (context, index) {
                  final book = books[index];
                  return _BookTile(book: book);
                },
                childCount: books.length,
              ),
            ),
            loading: () => const SliverFillRemaining(
              child: Center(child: CircularProgressIndicator()),
            ),
            error: (error, stack) => SliverFillRemaining(
              child: Center(child: Text('Error: $error')),
            ),
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () => Navigator.push(
          context,
          MaterialPageRoute(builder: (_) => const BookFormScreen()),
        ),
        child: const Icon(Icons.add),
      ),
    );
  }
}

class _FeaturedList extends StatelessWidget {
  final List<String> descriptions;
  const _FeaturedList({required this.descriptions});

  @override
  Widget build(BuildContext context) {
    if (descriptions.isEmpty) return const SizedBox.shrink();
    return Container(
      padding: const EdgeInsets.all(8),
      color: Colors.amber.withOpacity(0.1),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text('Featured & Bestsellers', style: Theme.of(context).textTheme.titleMedium),
          ...descriptions.map((d) => Text('• $d')),
        ],
      ),
    );
  }
}

class _BookTile extends ConsumerWidget {
  final Book book;
  const _BookTile({required this.book});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return ListTile(
      title: Text(book.title),
      subtitle: Text('${book.author} | \$${book.price}'),
      leading: CircleAvatar(child: Text(book.category[0])),
      trailing: IconButton(
        icon: const Icon(Icons.delete, color: Colors.red),
        onPressed: () => ref.read(bookControllerProvider.notifier).deleteBook(book.id!),
      ),
      onTap: () {
        Navigator.push(
          context,
          MaterialPageRoute(builder: (_) => BookFormScreen(bookToEdit: book)),
        );
      },
    );
  }
}