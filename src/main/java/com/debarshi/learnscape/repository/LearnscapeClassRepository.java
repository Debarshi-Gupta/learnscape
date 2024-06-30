package com.debarshi.learnscape.repository;

import com.debarshi.learnscape.model.LearnscapeClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnscapeClassRepository extends JpaRepository<LearnscapeClass, Integer> {

}
