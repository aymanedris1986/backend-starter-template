package com.ed.core.service;

import com.ed.core.dto.LOVDTO;
import com.ed.core.repository.LookupRepository;
import com.ed.core.service.base.AppService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LOVService extends AppService {

    private final LookupRepository lookupRepository;

    public List<LOVDTO> getLovByType(String lovType){
        return toLovDto(lookupRepository.findByLookupType(lovType));
    }
}
