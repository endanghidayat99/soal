package id.endang.soal.config;

import id.endang.soal.entity.Question;
import id.endang.soal.entity.Subject;
import id.endang.soal.repository.QuestionRepository;
import id.endang.soal.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final SubjectRepository subjectRepository;
    private final QuestionRepository questionRepository;

    @Override
    public void run(String... args) {
        if (subjectRepository.count() == 0) {
            initializeData();
        }
    }

    private void initializeData() {
        // Bahasa Indonesia
        Subject bahasaIndonesia = createSubject("bahasa_indonesia", "Bahasa Indonesia", "Latihan membaca, menulis, dan memahami kalimat sederhana.");
        addQuestion(bahasaIndonesia, "Huruf pertama dari kata 'Buku' adalah ...", "A", "B", "C", "D", 1);
        addQuestion(bahasaIndonesia, "Kalimat yang benar adalah ...", "saya suka makan.", "Saya suka makan", "Saya suka makan.", "saya Suka makan.", 2);
        addQuestion(bahasaIndonesia, "Benda yang digunakan untuk menulis di papan tulis adalah ...", "Pensil", "Spidol", "Penghapus", "Krayon", 1);

        // Matematika
        Subject matematika = createSubject("matematika", "Matematika", "Operasi hitung bilangan sampai perkalian 3 untuk kelas 2 SD.");
        addQuestion(matematika, "3 + 4 = ...", "5", "6", "7", "8", 2);
        addQuestion(matematika, "10 - 6 = ...", "3", "4", "5", "6", 1);
        addQuestion(matematika, "Hasil dari 2 × 3 adalah ...", "4", "5", "6", "7", 2);

        // Agama Islam
        Subject agamaIslam = createSubject("agama_islam", "Agama Islam", "Mengenal dasar-dasar ajaran Islam untuk anak kelas 2 SD.");
        addQuestion(agamaIslam, "Kitab suci umat Islam adalah ...", "Injil", "Al-Qur'an", "Taurat", "Weda", 1);
        addQuestion(agamaIslam, "Nabi terakhir dalam Islam adalah Nabi ...", "Musa", "Isa", "Muhammad", "Ibrahim", 2);
    }

    private Subject createSubject(String code, String name, String description) {
        Subject subject = new Subject();
        subject.setCode(code);
        subject.setName(name);
        subject.setDescription(description);
        return subjectRepository.save(subject);
    }

    private void addQuestion(Subject subject, String questionText, String optA, String optB, String optC, String optD, int correctAnswer) {
        Question question = new Question();
        question.setQuestion(questionText);
        question.setOptionA(optA);
        question.setOptionB(optB);
        question.setOptionC(optC);
        question.setOptionD(optD);
        question.setCorrectAnswer(correctAnswer);
        question.setSubject(subject);
        questionRepository.save(question);
    }
}