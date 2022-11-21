package com.upc.uroomsapi.publications.infrastructure.persistence.repositories;

import com.upc.uroomsapi.publications.infrastructure.persistence.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositorio de métodos CRUD y otros adicionales para la entidad Workspace con ID de tipo Long
 * No hace falta implementar porque Spring Data JPA generará el código necesario en tiempo de ejecución
 */
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByOwner(long ownerId);
}
