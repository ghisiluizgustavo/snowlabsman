package me.ghisiluizgustavo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ghisiluizgustavo.book.db.entity.BookEntity;
import me.ghisiluizgustavo.book.db.repository.BookRepository;
import me.ghisiluizgustavo.customer.db.entity.CustomerEntity;
import me.ghisiluizgustavo.customer.db.repository.CustomerRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class Main {

    private final BookRepository bookRepository;
    private final CustomerRepository customerRepository;

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
            BookEntity bookEntity = bookRepository.save(book);
            log.info("BookID: " + bookEntity.getId());

            var customer = new CustomerEntity();
            customer.setName("Luiz Gustavo");
            customer.setEmail("ghisiluizgustavo+snowmanlabs@mail.com");
            CustomerEntity customerEntity = customerRepository.save(customer);
            log.info("CustomerID: " + customerEntity.getId());
        };
    }
}