package com.ed.core.service.security;

import com.ed.core.dto.security.ClientUserInfoDTO;
import com.ed.core.entity.SecUser;
import com.ed.core.repository.SecUserRepository;
import com.ed.core.service.base.AppService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ed.core.utils.SecurityUtils.getCurrentUserName;

@Service
@AllArgsConstructor
public class SecUsersService extends AppService {

    private final SecUserRepository secUserRepository;

    public SecUser getUserByName(String username){
        return secUserRepository.findByUserName(username);
    }

    public ClientUserInfoDTO getUserWithRolesAnPermissions(String username){
        SecUser userByName = getUserByName(username);


        ClientUserInfoDTO clientUserInfoDTO = new ClientUserInfoDTO();
        clientUserInfoDTO.setId(userByName.getUserCode());
        clientUserInfoDTO.setName(username);
        clientUserInfoDTO.setEmail(userByName.getEmail());

        List<String> listOfFunctions =
                userByName.getSecUserFunctions().stream().map(secUserFunction -> secUserFunction.getFunctionCode().getFunctionCode()).toList();
        clientUserInfoDTO.getPermissions().addAll(listOfFunctions);

        List<String> listOfRoles = userByName.getSecUserRoles().stream().map(secUserRole -> secUserRole.getRoleCode().getRoleCode()).toList();
        clientUserInfoDTO.getPermissions().addAll(listOfRoles);

        return clientUserInfoDTO;
    }
}
