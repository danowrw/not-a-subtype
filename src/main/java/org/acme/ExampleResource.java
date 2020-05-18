package org.acme;

import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

@Path("")
public class ExampleResource {
    @Inject
    @RestClient
    protected GithubApi githubApi;

    ForkJoinPool customThreadPool;

    void onStart(@Observes StartupEvent ev) {
        customThreadPool = new ForkJoinPool(4);
    }

    @GET
    @Path("not_working")
    @Produces(MediaType.TEXT_PLAIN)
    public String notWorkingOnJava11Adopt() {
        Stream<String> stream = Stream.of("geoand", "aloubyansky", "stuartwdouglas", "FroMage").parallel();
        try {
            customThreadPool.submit(() ->{
                stream.map(this::getGithubOrgs).forEach(this::log);
            }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return "hello";
    }

    @GET
    @Path("working")
    @Produces(MediaType.TEXT_PLAIN)
    public String works() {
        Stream<String> stream = Stream.of("geoand", "aloubyansky", "stuartwdouglas", "FroMage").parallel();

        stream.map(this::getGithubOrgs).forEach(this::log);

        return "hello";
    }

    private void log(Organisation[] organisations) {
        for (Organisation org: organisations) {
            System.out.println(org);
        }
    }

    private Organisation[] getGithubOrgs(String user) {
        return githubApi.getOrgs(user);
    }
}