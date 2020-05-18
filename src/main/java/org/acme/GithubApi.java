package org.acme;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RegisterRestClient
public interface GithubApi {

    @GET
    @Path("/users/{user}/orgs")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    //below annotation cause execution on custom ForkJoinPool fails
    @Retry
    //This also fails for
    //@Timed
    //@Counted
    public Organisation[] getOrgs(@PathParam("user") String user);
}
