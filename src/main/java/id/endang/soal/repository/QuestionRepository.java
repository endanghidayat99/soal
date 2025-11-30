package id.endang.soal.repository;

import id.endang.soal.entity.Question;
import id.endang.soal.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findBySubject(Subject subject);
    List<Question> findBySubjectCode(String subjectCode);
}