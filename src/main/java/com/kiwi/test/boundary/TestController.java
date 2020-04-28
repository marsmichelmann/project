package com.kiwi.test.boundary;

import com.kiwi.test.entity.Test;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Rest controller for {@link Test}.
 */
@RestController
@RequestMapping("/spring")
public class TestController {

    /**
     * Gets a {@link Test}
     *
     * @return the {@link Test}.
     */
    @Operation(description = "Gets a Test")
    @APIResponse(description = "the Test", responseCode = "200")
    @Metered
    @GetMapping(path = "/test/{id}", produces = "text/plain")
    public Test getTest() {
        Test entity = new Test();
        entity.setText("text123");
        return entity;
    }

    /**
     * Gets all {@link Test}
     *
     * @return the found {@link Test}.
     */
    @Operation(description = "Get all Test")
    @APIResponse(description = "the found Test", responseCode = "200")
    @Metered
    @GetMapping(path = "/test/getAll", produces = "application/json")
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
