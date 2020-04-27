package com.kiwi.test.boundary;

import com.kiwi.test.entity.Test;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

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

    @Path("bla")
    @Metered
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Test bla() {
        Test entity = new Test();
        entity.setText("bla");
        return entity;
    }

    @Schema(description = "Creates a TestEntity")
    @Path("bla")
    @Metered
    @POST
    @APIResponse(responseCode = "200", description = "the created Test Entity")
    @Produces(MediaType.APPLICATION_JSON)
    public Test create(@RequestBody(description = "A brief description of the request body",
            required = true) Test entity) {
        return entity;
    }
}
