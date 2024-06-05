package quarkus.service;

import quarkus.entity.BookEntity;

import java.util.List;

public interface IBookService {
    List<BookEntity> getAll(Integer pagesGreaterThan);

    BookEntity create(BookEntity bookEntity);

    BookEntity getById(Long id);

    void deleteById(Long id);

    BookEntity updateById (Long id, BookEntity bookEntity);
}
