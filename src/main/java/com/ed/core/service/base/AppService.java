package com.ed.core.service.base;

import com.ed.core.dto.LOVDTO;
import jakarta.persistence.EntityManager;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


import static com.ed.core.utils.SecurityUtils.getCurrentUserName;

@Service
@Slf4j
@Data
public abstract class AppService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ModelMapper modelMapper;

    public <T> T getReference(String id, Class<T> c) {
        if(id == null || "".equals(id)){
            return null;
        }
        return entityManager.getReference(c, id);
    }

    public <T> T getReference(Long id, Class<T> c) {
        if(id == null || "".equals(id)){
            return null;
        }
        return entityManager.getReference(c, id);
    }

    public List<LOVDTO> toLovDto(List<?> objects){
        return objects.stream()
                .map(obj -> getModelMapper().map(obj, LOVDTO.class))
                .collect(Collectors.toList());
    }

    public String getUserName(){
        return getCurrentUserName();
    }

    public boolean isValueUpdated(Object src, Object dist) {
        // Check if both source and destination are null
        if (src == null && dist == null) {
            return false;
        }
        // Check if either source or destination is null
        if (src == null || dist == null) {
            return true;
        }
        // Compare the non-null source and destination values
        return !src.equals(dist);
    }

}
