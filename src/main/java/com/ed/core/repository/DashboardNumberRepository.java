package com.ed.core.repository;

import com.ed.core.dto.DashboardNumberDto;
import com.ed.core.entity.DashboardNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DashboardNumberRepository extends JpaRepository<DashboardNumber, Integer> {
    DashboardNumberDto findByUsername(String username);
}