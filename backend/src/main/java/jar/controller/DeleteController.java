package jar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jar.repo.StudentRepo;

@RestController
@RequestMapping("/api")
public class DeleteController {
    
    public final StudentRepo studentRepo;

    DeleteController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @DeleteMapping("/delete/{id}")  
    public void deleteEntry(@RequestParam long id){
        studentRepo.deleteById(id);
    }

    
}
