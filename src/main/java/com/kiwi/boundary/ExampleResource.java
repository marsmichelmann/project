package com.kiwi.boundary;

import com.kiwi.entity.TestEntity;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Schema(description = "Example Resource")
@Path("example")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
public class ExampleResource {

    @Inject
    @ConfigProperty(name= "version")
    String version;


    @Path("hello")
    @Metered
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @Path("test")
    @Metered
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject test() {
        return Json.createObjectBuilder()
                .add("key1", "value1")
                .add("key2", "value2")
                .build();
    }

    @Path("bla")
    @Metered
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TestEntity bla() {
        TestEntity entity = new TestEntity();
        entity.setText("bla");
        return entity;
    }

    @Schema(description = "Creates a TestEntity")
    @Path("bla")
    @Metered
    @POST
    @APIResponse(responseCode = "200", description = "the created Test Entity")
    @Produces(MediaType.APPLICATION_JSON)
    public TestEntity create(@RequestBody(description = "A brief description of the request body",
            required = true) TestEntity entity) {
        return entity;
    }

    @Path("version")
    @Metered
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String version() {
        return version;
    }
}