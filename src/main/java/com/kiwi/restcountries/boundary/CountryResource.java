package com.kiwi.restcountries.boundary;

import com.kiwi.restcountries.control.CountryClient;
import com.kiwi.restcountries.entity.Country;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;

/**
 * Rest resource for {@link Country}.
 */
@Path("country")
public class CountryResource {

    @Inject
    @RestClient
    CountryClient client;

    /**
     * Get information about a {@link Country} using {@link CountryClient}.
     *
     * @param name Name of {@link Country}.
     * @return the requested information about a {@link Country}.
     */
    @Operation(description = "Get information about a country")
    @APIResponse(description = "the requested information about a country", responseCode = "200")
    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Country> name(@PathParam("name") @Parameter(description = "Name of requested country", example = "germany") String name) {
        return client.getCountryByName(name);
    }
}
