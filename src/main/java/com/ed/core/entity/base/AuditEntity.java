package com.ed.core.entity.base;

import java.time.LocalDate;

public interface AuditEntity {
    void setCreatedAt(LocalDate date);
    LocalDate getCreatedAt();
    void setUpdatedAt(LocalDate date);
    LocalDate getUpdatedAt();
    void setCreatedBy(String user);
    String getCreatedBy();
    void setUpdatedBy(String user);
    String getUpdatedBy();
}
