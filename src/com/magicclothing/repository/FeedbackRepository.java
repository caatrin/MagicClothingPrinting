package com.magicclothing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.magicclothing.domain.Feedback;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
	
	@Query("SELECT f FROM Feedback f")
	public List<Feedback> getAllFeedbacks();

}
