package org.eu.rubensa.sample;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Path("/sample/{name}/objects/{key:.*}/func")
public class SampleResource {

  @GET
  @Produces({ "application/json" })
  public Response runFunc(@PathParam("name") String name, @PathParam("key") String key) {
    if (name == null || name.isEmpty()) {
      return Response.status(Status.BAD_REQUEST).build();
    }
    if (key == null || key.isEmpty()) {
      return Response.status(Status.BAD_REQUEST).build();
    }
    return Response.ok(String.format("name: '%s', key: '%s'", name, key)).build();
  }

}
