package me.ghisiluizgustavo.book.gateway;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ghisiluizgustavo.book.event.model.BookEvent;
import me.ghisiluizgustavo.book.event.model.StatusEventBook;
import me.ghisiluizgustavo.book.model.Book;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageQueueingPersistenceGateway implements BookNotificationGateway {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void notifyCreatedBook(Book book) {
        BookEvent bookEvent = new BookEvent(this, book, StatusEventBook.CREATED);

        log.info("Sending event to message queue" +
                " bookName=" + book.name() +
                " bookAuthor=" + book.author() +
                " bookStatus=" + StatusEventBook.CREATED
        );

        eventPublisher.publishEvent(bookEvent);
    }

    @Override
    public void notifyUpdatedBook(Book book) {
        BookEvent bookEvent = new BookEvent(this, book, StatusEventBook.UPDATED);

        log.info("Sending event to message queue" +
                " bookName=" + book.name() +
                " bookAuthor=" + book.author() +
                " bookStatus=" + StatusEventBook.UPDATED
        );

        eventPublisher.publishEvent(bookEvent);
    }

    @Override
    public void notifyDeletedBook(String id) {
        BookEvent bookEvent = new BookEvent(this, null, StatusEventBook.DELETED);

        log.info("Sending event to message queue" +
                " bookId=" + id +
                " bookStatus=" + StatusEventBook.DELETED
        );

        eventPublisher.publishEvent(bookEvent);
    }

}
