// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'book_model.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$BookModelImpl _$$BookModelImplFromJson(Map<String, dynamic> json) =>
    _$BookModelImpl(
      id: (json['id'] as num?)?.toInt(),
      category: json['category'] as String,
      title: json['title'] as String,
      author: json['author'] as String,
      price: (json['price'] as num).toDouble(),
    );

Map<String, dynamic> _$$BookModelImplToJson(_$BookModelImpl instance) =>
    <String, dynamic>{
      'id': instance.id,
      'category': instance.category,
      'title': instance.title,
      'author': instance.author,
      'price': instance.price,
    };
