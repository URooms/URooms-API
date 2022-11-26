package com.upc.uroomsapi.publications.application.handlers.queries;

import com.upc.uroomsapi.publications.application.dtos.response.ReviewResponseV1;
import com.upc.uroomsapi.publications.application.messages.queries.GetReviewsByStudentId;
import com.upc.uroomsapi.publications.infrastructure.persistence.repositories.ReviewRepository;
import com.upc.uroomsapi.users.infrastructure.persistence.entities.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetReviewsByStudentIdHandler {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ReviewRepository reviewRepository;

    public List<ReviewResponseV1> execute(GetReviewsByStudentId query) {
        //set student id
        Student student = new Student();
        student.setUserId(query.getStudentId());

        var reviewList = reviewRepository.findByStudent(student);

        return reviewList.stream()
                .map(review -> modelMapper.map(review, ReviewResponseV1.class)) //lambda que mapea cada item al dto (response)
                .collect(Collectors.toList());
    }
}
