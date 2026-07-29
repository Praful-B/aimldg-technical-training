package jar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.model.Student;
import jar.repo.StudentRepo;

@RestController
@RequestMapping("/api/v1")
public class St {

    @GetMapping()
    Map<Object, Object> m1() {
        Map<Object, Object> res = new HashMap<>();
        res.put("msg", "welcome to get api");
        res.put("status", 200);
        return res;
    }

    @Autowired
    StudentRepo db;

    @PostMapping()
    Map<Object, Object> m2(@RequestBody Student d) {
        Map<Object, Object> res = new HashMap<>();
        res.put("msg", "welcome to Post api");
        res.put("status", 201);
        // String name = d.getName();
        // String email = d.getEmail();
        // String ip = d.getIp();

        // Student s = new Student();
        // s.setName(name);
        // s.setEmail(email);
        // s.setIp(ip);

        System.out.println("\n\t check 1 : "+d.getName());
        System.out.println("\n\t check 1 : "+d.getEmail());
        System.out.println("\n\t check 1 : "+d.getIp());

        // db.save(s);

        return res;
    }
}
