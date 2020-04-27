package com.kiwi.example.boundary;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Rest resource for examples.
 */
@Path("example")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
public class ExampleResource {

    @Inject
    @ConfigProperty(name = "version")
    String version;

    /**
     * Gets a 'Hello World'.
     *
     * @return the 'Hello World'.
     */
    @Operation(description = "Gets a 'Hello world'")
    @APIResponse(description = "the 'Hello World'", responseCode = "200")
    @Path("hello")
    @Metered
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello, World!";
    }

    /**
     * Creates a simple {@link JsonObject}.
     *
     * @return the created {@link JsonObject}.
     */
    @Operation(description = "Creates a simple Json Object")
    @APIResponse(description = "the created Json Object", responseCode = "200")
    @Path("create")
    @Metered
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject create() {
        return Json.createObjectBuilder()
                .add("key1", "value1")
                .add("key2", "value2")
                .build();
    }

    /**
     * Gets the current version of example.
     *
     * @return the current version of example.
     */
    @Operation(description = "Gets the current version of Example")
    @APIResponse(description = "the current version", responseCode = "200")
    @Path("version")
    @Metered
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String version() {
        return version;
    }
}