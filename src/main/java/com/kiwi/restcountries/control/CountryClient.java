package com.kiwi.restcountries.control;

import com.kiwi.restcountries.entity.Country;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;

/**
 * REST client for 'restcountries.eu'.
 */
@Path("v2")
@RegisterRestClient(configKey = "country-api")
public interface CountryClient {

    /**
     * Gets information about a {@link Country} referenced by the given {@code name}.
     *
     * @param name Name of {@link Country}.
     * @return the requested information about a {@link Country}.
     */
    @GET
    @Path("name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    Set<Country> getCountryByName(@PathParam("name") String name);
}
