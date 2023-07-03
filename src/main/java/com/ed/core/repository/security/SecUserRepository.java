package com.ed.core.repository.security;

import com.ed.core.entity.SecUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface SecUserRepository extends JpaRepository<SecUser, String> {
    @Query("select s from SecUser s where upper(s.userName) = upper(?1)")
    SecUser findByUserName(@NonNull String userName);
}