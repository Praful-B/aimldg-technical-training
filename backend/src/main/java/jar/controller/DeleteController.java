package jar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.repo.StudentRepo;

@RestController
@RequestMapping("/api")
public class DeleteController {
    private final StudentRepo studentRepo;

    public DeleteController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable long id) {
        if (!studentRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        studentRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    
}
