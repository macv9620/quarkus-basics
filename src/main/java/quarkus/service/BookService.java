package quarkus.service;

import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import quarkus.entity.BookEntity;
import quarkus.repository.BookRepository;

import java.util.List;
import java.util.NoSuchElementException;

@ApplicationScoped
public class BookService implements IBookService{
    private final BookRepository bookRepository;

    @Inject
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookEntity> getAll(Integer pagesGreaterThan) {
        if (pagesGreaterThan == null){
            return bookRepository
                    .listAll(Sort.by("numPages", Sort.Direction.Ascending));
        }

        return bookRepository.list("numPages >= ?1", pagesGreaterThan);
    }

    @Override
    public BookEntity create(BookEntity bookEntity) {
        bookRepository.persist(bookEntity);
        return bookEntity;
    }

    @Override
    public BookEntity getById(Long id) {
        return bookRepository
                .findByIdOptional(id)
                .orElseThrow(
                        () -> new NoSuchElementException("Id " + id + " no existe")
                );
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookEntity updateById(Long id, BookEntity bookEntity) {
        BookEntity book = this.getById(id);

        book.setDescription(bookEntity.getDescription());
        book.setTitle(bookEntity.getTitle());
        book.setNumPages(bookEntity.getNumPages());
        book.setPubDate(bookEntity.getPubDate());

        bookRepository.persist(book);

        return book;
    }
}
