package me.ghisiluizgustavo.book.gateway;

import me.ghisiluizgustavo.book.db.entity.BookEntity;
import me.ghisiluizgustavo.book.db.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.book.exception.BookNotFoundException;
import me.ghisiluizgustavo.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookDatabaseGateway implements BookGateway {

    private final BookRepository bookRepository;

    @Override
    public Book create(Book book){
        return bookRepository.save(new BookEntity(book)).toBook();
    }

    @Override
    public Book findById(String id) {
        return bookRepository
                .findById(id)
                .map(BookEntity::toBook)
                .orElseThrow(() -> new BookNotFoundException("Book with id: " + id + " was not found"));
    }

    @Override
    public Page<Book> findlAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable).map(BookEntity::toBook);
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book updateBook(String id, Book book) {
        return bookRepository.findById(id).map(bookEntity -> {
            bookEntity.setIsbn(book.isbn().value());
            bookEntity.setName(book.name());
            bookEntity.setAuthor(book.author());
            return bookRepository.save(bookEntity).toBook();
        }).orElseThrow(() -> new BookNotFoundException("Book with id: " + id + " was not found"));
    }


}