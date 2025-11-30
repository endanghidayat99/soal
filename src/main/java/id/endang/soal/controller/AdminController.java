package id.endang.soal.controller;

import id.endang.soal.entity.Question;
import id.endang.soal.entity.Subject;
import id.endang.soal.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final QuizService quizService;
    
    @GetMapping
    public String admin(Model model) {
        model.addAttribute("subjects", quizService.getAllSubjects());
        return "admin";
    }
    
    @PostMapping("/subjects")
    public String addSubject(@ModelAttribute Subject subject) {
        quizService.saveSubject(subject);
        return "redirect:/admin";
    }
    
    @PostMapping("/questions")
    public String addQuestion(@ModelAttribute Question question, @RequestParam String subjectCode) {
        Subject subject = quizService.getSubjectByCode(subjectCode);
        question.setSubject(subject);
        quizService.saveQuestion(question);
        return "redirect:/admin";
    }
    
    @PostMapping("/subjects/{id}/delete")
    public String deleteSubject(@PathVariable Long id) {
        quizService.deleteSubject(id);
        return "redirect:/admin";
    }
    
    @PostMapping("/questions/{id}/delete")
    public String deleteQuestion(@PathVariable Long id) {
        quizService.deleteQuestion(id);
        return "redirect:/admin";
    }
}