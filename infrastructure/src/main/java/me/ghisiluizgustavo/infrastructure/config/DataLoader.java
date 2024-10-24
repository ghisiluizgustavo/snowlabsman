package me.ghisiluizgustavo.infrastructure.config;

import lombok.extern.slf4j.Slf4j;
import me.ghisiluizgustavo.infrastructure.book.db.entity.BookEntity;
import me.ghisiluizgustavo.infrastructure.book.db.repository.BookRepository;
import me.ghisiluizgustavo.infrastructure.customer.db.entity.CustomerEntity;
import me.ghisiluizgustavo.infrastructure.customer.db.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(BookRepository bookRepository, CustomerRepository customerRepository) {
        return args -> {
            var id1 = bookRepository.save(new BookEntity(
                    null,
                    "9781234332123",
                    "Clean Code",
                    "Uncle Bob",
                    true,
                    null)).getId();
            var id2 = bookRepository.save(new BookEntity(
                    null,
                    "9781234332124",
                    "Effective Java",
                    "Joshua Bloch",
                    true,
                    null)).getId();
            var idCustomer = customerRepository.save(new CustomerEntity(
                    null,
                    "Luiz",
                    "ghisiluizgustavo+snowmanlabs@gmail.com",
                    null)).getId();

            log.info("BookID="+id1);
            log.info("BookID="+id2);
            log.info("CustomerID="+idCustomer);
        };
    }
}