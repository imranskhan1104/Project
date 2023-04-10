package com.imran.demo.repositories;

import com.imran.demo.entities.Store;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Repository
public interface StoreRepo extends JpaRepository<Store, Integer> {

    @Query(value = "SELECT status, COUNT(status) as count FROM store GROUP BY status",nativeQuery = true)
    List<Object[]> countByStatus();
}
