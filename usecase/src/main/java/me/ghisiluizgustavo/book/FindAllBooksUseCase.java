package me.ghisiluizgustavo.book;

import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.book.gateway.BookGateway;
import me.ghisiluizgustavo.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAllBooksUseCase {

    private final BookGateway bookGateway;

    public Page<Book> execute(Pageable pageable){
        return bookGateway.findlAllBooks(pageable);
    }

}
