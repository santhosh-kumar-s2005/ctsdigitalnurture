package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    @Query(value = "SELECT a FROM Attempt a "
            + "left join fetch a.user u "
            + "left join fetch a.attemptQuestionList aq "
            + "left join fetch aq.question q "
            + "left join fetch q.optionList o "
            + "left join fetch aq.attemptOptionList ao "
            + "WHERE u.id = :userId AND a.id = :attemptId")
    Attempt getAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);
}
