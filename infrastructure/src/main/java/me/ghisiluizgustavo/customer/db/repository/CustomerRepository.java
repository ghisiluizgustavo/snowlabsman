package me.ghisiluizgustavo.customer.db.repository;

import me.ghisiluizgustavo.customer.db.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}
