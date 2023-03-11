package com.consultation.consultation.repository;

import com.consultation.consultation.dto.queryDto.GetAllRatingConsultant;
import com.consultation.consultation.entity.Comment;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = """
            SELECT * FROM comment WHERE consultant_id = :id AND type_comment = :typeComment
            """
            ,nativeQuery = true)
    List<Comment> findAllWithConsultantIdAndTypeComment(Long id, String typeComment);

    @Query(
            value = """
                    SELECT consultant_id as consultantId, ROUND(CAST(AVG(rating) as numeric),2) as ratings FROM comment WHERE type_comment = 'USERTOCONS'
                    GROUP BY consultant_id
                    """
            ,nativeQuery = true)
    List<Tuple> getAllConsultantRatings();


}
