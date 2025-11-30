package id.endang.soal.service;

import id.endang.soal.entity.Question;
import id.endang.soal.entity.Subject;
import id.endang.soal.repository.QuestionRepository;
import id.endang.soal.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final SubjectRepository subjectRepository;
    private final QuestionRepository questionRepository;
    
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
    
    public Subject getSubjectByCode(String code) {
        return subjectRepository.findByCode(code);
    }
    
    public List<Question> getQuestionsBySubject(String subjectCode) {
        return questionRepository.findBySubjectCode(subjectCode);
    }
    
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
    
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }
    
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
    
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}