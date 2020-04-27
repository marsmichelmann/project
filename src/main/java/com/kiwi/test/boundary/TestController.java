package com.kiwi.test.boundary;

import com.kiwi.test.entity.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping(path = "/greet/{id}", produces = "text/plain")
    public String greetPerson(@PathVariable(name = "id") long id) {
        String name = "";
        // ...
        return name;
    }

    @GetMapping(produces = "application/json")
    public List<Test> findAll() {
        List<Test> entities = new ArrayList<>();
        Test t1 = new Test();
        t1.setText("t1");
        Test t2 = new Test();
        t2.setText("t2");
        entities.add(t1);
        entities.add(t2);

        return entities;
    }
}
