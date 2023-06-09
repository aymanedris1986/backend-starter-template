package com.ed.core.repository;

import com.ed.core.entity.Lookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface LookupRepository extends JpaRepository<Lookup, Long> {
    List<Lookup> findByLookupType(@NonNull String lookupType);
}