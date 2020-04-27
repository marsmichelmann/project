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
