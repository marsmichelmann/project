package com.kiwi.test.boundary;

import com.kiwi.test.entity.Test;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Rest resource for {@link Test}.
 */
@Path("test")
public class TestResource {

    /**
     * Gets a {@link Test}
     *
     * @return the {@link Test}.
     */
    @Path("test")
    @Operation(description = "Gets a Test")
    @APIResponse(description = "the Test", responseCode = "200")
    @Metered
    @GET
    @Produces(MediaType.APPLICATION_JSON)
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
    @Path("getAll")
    @Operation(description = "Gets all Test")
    @APIResponse(description = "the found Test", responseCode = "200")
    @Metered
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Test> getAllTest() {
        return IntStream.range(1, 10)
                .mapToObj(i -> {
                    Test test = new Test();
                    test.setText("test" + i);
                    return test;
                })
                .collect(Collectors.toList());
    }

    /**
     * Creates a new {@link Test}
     *
     * @param entity the {@link Test} to created.
     * @return the created {@link Test}
     */
    @Operation(description = "Creates a new Test")
    @APIResponse(description = "the created Test", responseCode = "200")
    @Metered
    @POST
    @APIResponse(responseCode = "200", description = "the created Test Entity")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Test create(@RequestBody(description = "The Test to create", required = true) Test entity) {
        return entity;
    }
}
