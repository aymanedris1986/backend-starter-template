package com.ed.core.service;

import com.ed.core.dto.SecUserProfileDto;
import com.ed.core.entity.SecUser;
import com.ed.core.repository.security.SecUserRepository;
import com.ed.core.service.base.AuditCrudService;
import com.ed.core.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecUserProfileService extends AuditCrudService<SecUser,String, SecUserProfileDto> {
    private final SecUserRepository secUserRepository;
    @Override
    protected JpaRepository<SecUser, String> getRepository() {
        return secUserRepository;
    }

    @Override
    protected Class<SecUser> getModelClassType() {
        return SecUser.class;
    }

    @Override
    protected Class<SecUserProfileDto> getDtoClassType() {
        return SecUserProfileDto.class;
    }

    @Override
    protected String getDtoId(SecUserProfileDto dto) {
        return dto.getUserCode();
    }

    @Override
    protected SecUser getNewModelObject() {
        return new SecUser();
    }

    @Override
    protected void mapLovs(SecUserProfileDto src, SecUser dest) {

    }

    @Override
    protected SecUserProfileDto mapFromModelToDto(SecUser o) {
        SecUserProfileDto secUserProfileDto = super.mapFromModelToDto(o);
        secUserProfileDto.setId(o.getUserCode());
        return secUserProfileDto;
    }

    @Override
    protected void mapFromDtoToModel(SecUserProfileDto dto, SecUser model) {
        super.mapFromDtoToModel(dto, model);
        if(Utils.isNullOrEmpty(model.getUserCode()) && !("".equals(dto.getId()+"")) ){
            model.setUserCode(dto.getId());
        }
    }
}
