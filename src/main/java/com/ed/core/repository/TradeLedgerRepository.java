package com.ed.core.repository;

import com.ed.core.entity.TradeLedger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeLedgerRepository extends JpaRepository<TradeLedger, Long> {
}