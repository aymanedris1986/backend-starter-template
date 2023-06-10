package com.ed.core.entity.base;

import java.time.Instant;

public interface AuditEntity {
    void setCreatedAt(Instant date);
    Instant getCreatedAt();
    void setUpdatedAt(Instant date);
    Instant getUpdatedAt();
    void setCreatedBy(String user);
    String getCreatedBy();
    void setUpdatedBy(String user);
    String getUpdatedBy();
}
