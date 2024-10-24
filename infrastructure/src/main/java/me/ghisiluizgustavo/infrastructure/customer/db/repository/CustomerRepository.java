package me.ghisiluizgustavo.infrastructure.customer.db.repository;

import me.ghisiluizgustavo.infrastructure.customer.db.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}
