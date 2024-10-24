package me.ghisiluizgustavo.infrastructure.rental.db.repository;

import me.ghisiluizgustavo.infrastructure.rental.db.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<RentalEntity, String> {
}
