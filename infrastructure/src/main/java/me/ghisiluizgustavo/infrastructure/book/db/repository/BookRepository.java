package me.ghisiluizgustavo.infrastructure.book.db.repository;

import me.ghisiluizgustavo.infrastructure.book.db.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {
}
