package com.ed.core.service.base;

import com.ed.core.entity.base.AuditEntity;

import java.time.Instant;

public abstract class AuditCrudService<O extends AuditEntity, I, D> extends CrudService<O, I, D>{
    @Override
    protected O preInsert(O model, D dto) {
        insertAudit(model);
        return super.preInsert(model, dto);
    }

    public void insertAudit(AuditEntity model) {
        Instant now = Instant.now();
        model.setCreatedAt(now);
        model.setCreatedBy(getUserName());
        model.setUpdatedAt(now);
        model.setUpdatedBy(getUserName());
    }

    @Override
    protected O preUpdate(O model, D dto) {
        updateAudit(model);
        return super.preUpdate(model, dto);
    }

    public void updateAudit(AuditEntity model) {
        Instant now = Instant.now();
        model.setUpdatedAt(now);
        model.setUpdatedBy(getUserName());
    }
}
