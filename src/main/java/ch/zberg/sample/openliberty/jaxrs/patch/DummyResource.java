package ch.zberg.sample.openliberty.jaxrs.patch;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.enterprise.context.RequestScoped;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/dummy")
public class DummyResource {

   @GET
   @Produces(MediaType.TEXT_PLAIN)
   public Response dummy(@Context HttpHeaders headers) throws NoSuchAlgorithmException, KeyManagementException {
      final Client jaxRsClient = ClientBuilder.newBuilder()
         .build();
      final Response response = jaxRsClient.target("https://localhost:9443/java17/api/dummy/patch")
         .request(MediaType.APPLICATION_JSON_TYPE)
         .accept(MediaType.TEXT_PLAIN)
         .method("PATCH", Entity.entity("{}", MediaType.APPLICATION_JSON_TYPE));
      final String useMethod = response.readEntity(String.class);
      return Response.ok(useMethod).build();
   }

   @PATCH
   @Path("patch")
   @Produces(MediaType.TEXT_PLAIN)
   public Response patch(@Context HttpHeaders headers) {
      return Response.ok("patch", MediaType.TEXT_PLAIN_TYPE).build();
   }

   @POST
   @Path("patch")
   @Produces(MediaType.TEXT_PLAIN)
   public Response patchPost(@Context HttpHeaders headers) {
      return Response.ok("post", MediaType.TEXT_PLAIN_TYPE).build();
   }

   @GET
   @Path("patch")
   @Produces(MediaType.TEXT_PLAIN)
   public Response patchGet(@Context HttpHeaders headers) {
      return Response.ok("get", MediaType.TEXT_PLAIN_TYPE).build();
   }
}
