package id.endang.soal.controller;

import id.endang.soal.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("subjects", quizService.getAllSubjects());
        return "quiz";
    }
    
    @GetMapping("/api/subjects")
    @ResponseBody
    public Object getSubjects() {
        return quizService.getAllSubjects().stream()
            .collect(java.util.stream.Collectors.toMap(
                s -> s.getCode(),
                s -> java.util.Map.of(
                    "name", s.getName(),
                    "description", s.getDescription(),
                    "questions", quizService.getQuestionsBySubject(s.getCode()).stream()
                        .map(q -> java.util.Map.of(
                            "question", q.getQuestion(),
                            "options", java.util.List.of(q.getOptionA(), q.getOptionB(), q.getOptionC(), q.getOptionD()),
                            "answer", q.getCorrectAnswer()
                        )).toList()
                )
            ));
    }
}