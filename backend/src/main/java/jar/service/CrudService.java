package jar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jar.repo.StudentRepo;

@Service
public class CrudService {
    private final StudentRepo studentRepo;
    
    CrudService(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }
    
}
