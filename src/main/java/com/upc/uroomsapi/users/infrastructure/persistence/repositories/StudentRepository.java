package com.upc.uroomsapi.users.infrastructure.persistence.repositories;

import com.upc.uroomsapi.users.infrastructure.persistence.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
