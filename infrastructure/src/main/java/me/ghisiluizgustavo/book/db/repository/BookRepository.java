package me.ghisiluizgustavo.book.db.repository;

import me.ghisiluizgustavo.book.db.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {
}
