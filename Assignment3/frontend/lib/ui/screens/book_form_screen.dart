import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../../domain/entities/book.dart';
import '../../logic/book_notifier.dart';

class BookFormScreen extends ConsumerStatefulWidget {
  final Book? bookToEdit;

  const BookFormScreen({super.key, this.bookToEdit});

  @override
  ConsumerState<BookFormScreen> createState() => _BookFormScreenState();
}

class _BookFormScreenState extends ConsumerState<BookFormScreen> {
  final _formKey = GlobalKey<FormState>();

  late TextEditingController _titleCtrl;
  late TextEditingController _authorCtrl;
  late TextEditingController _categoryCtrl;
  late TextEditingController _priceCtrl;

  @override
  void initState() {
    super.initState();
    final b = widget.bookToEdit;
    _titleCtrl = TextEditingController(text: b?.title ?? '');
    _authorCtrl = TextEditingController(text: b?.author ?? '');
    _categoryCtrl = TextEditingController(text: b?.category ?? '');
    _priceCtrl = TextEditingController(text: b?.price.toString() ?? '');
  }

  @override
  void dispose() {
    _titleCtrl.dispose();
    _authorCtrl.dispose();
    _categoryCtrl.dispose();
    _priceCtrl.dispose();
    super.dispose();
  }

  void _submit() async {
    if (_formKey.currentState!.validate()) {
      final newBook = Book(
        id: widget.bookToEdit?.id, // Keep ID if editing
        title: _titleCtrl.text,
        author: _authorCtrl.text,
        category: _categoryCtrl.text,
        price: double.parse(_priceCtrl.text),
      );

      final controller = ref.read(bookControllerProvider.notifier);

      if (widget.bookToEdit == null) {
        await controller.addBook(newBook);
      } else {
        await controller.updateBook(widget.bookToEdit!.id!, newBook);
      }

      if (mounted) Navigator.pop(context);
    }
  }

  @override
  Widget build(BuildContext context) {
    final state = ref.watch(bookControllerProvider);
    final isLoading = state.isLoading;

    return Scaffold(
      appBar: AppBar(title: Text(widget.bookToEdit == null ? 'Add Book' : 'Edit Book')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: ListView(
            children: [
              TextFormField(
                controller: _titleCtrl,
                decoration: const InputDecoration(labelText: 'Title'),
                validator: (v) => v!.isEmpty ? 'Required' : null,
              ),
              TextFormField(
                controller: _authorCtrl,
                decoration: const InputDecoration(labelText: 'Author'),
                validator: (v) => v!.isEmpty ? 'Required' : null,
              ),
              TextFormField(
                controller: _categoryCtrl,
                decoration: const InputDecoration(labelText: 'Category'),
                validator: (v) => v!.isEmpty ? 'Required' : null,
              ),
              TextFormField(
                controller: _priceCtrl,
                decoration: const InputDecoration(labelText: 'Price'),
                keyboardType: TextInputType.number,
                validator: (v) {
                  if (v == null || v.isEmpty) return 'Required';
                  if (double.tryParse(v) == null) return 'Invalid number';
                  return null;
                },
              ),
              const SizedBox(height: 20),
              ElevatedButton(
                onPressed: isLoading ? null : _submit,
                child: isLoading
                    ? const CircularProgressIndicator()
                    : const Text('Save'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}