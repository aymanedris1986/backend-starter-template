package com.ed.core.service;

import com.ed.core.dto.RegionDto;
import com.ed.core.entity.Region;
import com.ed.core.repository.RegionRepository;
import com.ed.core.service.base.AuditCrudService;
import com.ed.core.service.base.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegionService extends AuditCrudService<Region,Long, RegionDto> {

    private final RegionRepository regionRepository;

    @Override
    protected JpaRepository<Region, Long> getRepository() {
        return regionRepository;
    }

    @Override
    protected Class<Region> getModelClassType() {
        return Region.class;
    }

    @Override
    protected Class<RegionDto> getDtoClassType() {
        return RegionDto.class;
    }

    @Override
    protected Long getDtoId(RegionDto dto) {
        return dto.getId();
    }

    @Override
    protected Region getNewModelObject() {
        return new Region();
    }

    @Override
    protected void mapLovs(RegionDto src, Region dest) {

    }
}
