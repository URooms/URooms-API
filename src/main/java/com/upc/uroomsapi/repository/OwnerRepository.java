package com.upc.uroomsapi.repository;

import com.upc.uroomsapi.model.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
