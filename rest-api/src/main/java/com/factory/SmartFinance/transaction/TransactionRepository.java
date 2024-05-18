package com.factory.SmartFinance.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "transactions", path = "/api/transaction")
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
