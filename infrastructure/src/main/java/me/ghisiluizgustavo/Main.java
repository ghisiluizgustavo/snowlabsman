package me.ghisiluizgustavo;

import me.ghisiluizgustavo.book.db.entity.BookEntity;
import me.ghisiluizgustavo.book.db.repository.BookRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            var book = new BookEntity();
            book.setName("Clean Code");
            book.setAuthor("Uncle Bob");
            book.setIsbn("9780132350884");
            book.setAvailable(true);
            bookRepository.save(book);
        };
    }
}