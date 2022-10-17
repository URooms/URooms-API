package com.upc.uroomsapi.repository;

import com.upc.uroomsapi.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de métodos CRUD y otros adicionales para la entidad Workspace con ID de tipo Long
 * No hace falta implementar porque Spring Data JPA generará el código necesario en tiempo de ejecución
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
