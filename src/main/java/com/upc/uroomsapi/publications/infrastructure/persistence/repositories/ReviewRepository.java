package com.upc.uroomsapi.publications.infrastructure.persistence.repositories;

import com.upc.uroomsapi.publications.infrastructure.persistence.entities.Post;
import com.upc.uroomsapi.publications.infrastructure.persistence.entities.Review;
import com.upc.uroomsapi.users.infrastructure.persistence.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByStudent(Student student);
    List<Review> findByPost(Post post);
}
