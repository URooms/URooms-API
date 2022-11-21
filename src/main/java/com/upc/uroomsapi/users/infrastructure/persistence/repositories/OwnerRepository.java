package com.upc.uroomsapi.users.infrastructure.persistence.repositories;

import com.upc.uroomsapi.users.infrastructure.persistence.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
