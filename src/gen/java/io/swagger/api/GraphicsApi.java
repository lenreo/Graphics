package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.GraphicsApiService;
import io.swagger.api.factories.GraphicsApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.Date;
import java.io.File;
import io.swagger.model.Graphic;
import io.swagger.model.Magnitude;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;


@Path("/graphics")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2019-11-08T18:16:35.551Z[GMT]")public class GraphicsApi  {
   private final GraphicsApiService delegate;

   public GraphicsApi(@Context ServletConfig servletContext) {
      GraphicsApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("GraphicsApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (GraphicsApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = GraphicsApiServiceFactory.getGraphicsApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json", "application/xml" })
    
    @Operation(summary = "Añadir nueva gráfica", description = "Añadir nueva gráfica", tags={ "graphics" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Operación válida"),
        
        @ApiResponse(responseCode = "405", description = "No se pudo validar"),
        
        @ApiResponse(responseCode = "500", description = "Error Interno") })
    public Response addGraphic(@Parameter(description = "Gráfica" ,required=true) Graphic body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addGraphic(body,securityContext);
    }
    @DELETE
    @Path("/{id}")
    
    
    @Operation(summary = "Elimina una determinada gráfica por ID", description = "Elimina una gráfica", tags={ "graphics" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400", description = "ID proporcionado no valido"),
        
        @ApiResponse(responseCode = "404", description = "Gráfica no encontrada") })
    public Response deleteGraphicById(@Parameter(description = "ID de la gráfica",required=true) @PathParam("id") Long id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteGraphicById(id,securityContext);
    }
    @GET
    @Path("/findByMagnitude")
    
    @Produces({ "application/xml", "application/json" })
    @Operation(summary = "Encuentra gráficas por magnitud", description = "Busca las gráficas que sean de una determinada magnitud", tags={ "graphics" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Operación válida", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Graphic.class)))),
        
        @ApiResponse(responseCode = "405", description = "No se pudo validar") })
    public Response findGraphicByMagnitude(@Parameter(description = "Magnitud de las medidas",required=true) @QueryParam("magnitude") Magnitude magnitude
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findGraphicByMagnitude(magnitude,securityContext);
    }
    @GET
    @Path("/generate")
    
    @Produces({ "application/xml", "application/json" })
    @Operation(summary = "Genera una gráfica", description = "Genera una gráfica dada una magnitud y un rango de fechas", tags={ "graphics" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Operación válida", content = @Content(schema = @Schema(implementation = Graphic.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad request. User ID must be an integer and larger than 0."),
        
        @ApiResponse(responseCode = "405", description = "No se pudo validar") })
    public Response generate(@Parameter(description = "Magnitud de las medidas",required=true) @QueryParam("magnitude") Magnitude magnitude
,@Parameter(description = "Fecha de inicio del rango temporal de las medidas",required=true) @QueryParam("startDate") Date startDate
,@Parameter(description = "Fecha de fin del rango temporal de las medidas",required=true) @QueryParam("endDate") Date endDate
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.generate(magnitude,startDate,endDate,securityContext);
    }
    @GET
    @Path("/{id}/toPdf")
    
    @Produces({ "application/pdf" })
    @Operation(summary = "Devuelve el PDF de una gráfica", description = "Encontrar una determinada gráfica por ID y generar PDF", tags={ "graphics" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Operacion valida", content = @Content(schema = @Schema(implementation = File.class))),
        
        @ApiResponse(responseCode = "400", description = "ID proporcionado no valido"),
        
        @ApiResponse(responseCode = "404", description = "Gráfica no encontrada") })
    public Response generatePdf(@Parameter(description = "ID de la gráfica",required=true) @PathParam("id") Long id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.generatePdf(id,securityContext);
    }
    @GET
    @Path("/{id}/toPng")
    
    @Produces({ "image/png" })
    @Operation(summary = "Devuelve el PNG de una gráfica", description = "Encontrar una determinada gráfica por ID y generar PNG", tags={ "graphics" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Operacion valida", content = @Content(schema = @Schema(implementation = File.class))),
        
        @ApiResponse(responseCode = "400", description = "ID proporcionado no valido"),
        
        @ApiResponse(responseCode = "404", description = "Gráfica no encontrada") })
    public Response generatePng(@Parameter(description = "ID de la gráfica",required=true) @PathParam("id") Long id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.generatePng(id,securityContext);
    }
    @GET
    @Path("/{id}")
    
    @Produces({ "application/xml", "application/json" })
    @Operation(summary = "Encontrar una determinada gráfica por ID", description = "Devuelve una gráfica", tags={ "graphics" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Operación válida", content = @Content(schema = @Schema(implementation = Graphic.class))),
        
        @ApiResponse(responseCode = "400", description = "ID proporcionado no valido"),
        
        @ApiResponse(responseCode = "404", description = "Gráfica no encontrada") })
    public Response getGraphicById(@Parameter(description = "ID de la gráfica",required=true) @PathParam("id") Long id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getGraphicById(id,securityContext);
    }
    @GET
    @Path("/{id}/sendEmail")
    
    
    @Operation(summary = "Envía una gráfica por email", description = "Encontrar una determinada gráfica por ID y enviarla por email", tags={ "graphics" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Operacion válida"),
        
        @ApiResponse(responseCode = "400", description = "Datos de entrada no válidos"),
        
        @ApiResponse(responseCode = "404", description = "Gráfica no encontrada") })
    public Response sendEmail(@Parameter(description = "ID de la gráfica",required=true) @PathParam("id") Long id
,@Parameter(description = "Dirección de correo",required=true) @QueryParam("email") String email
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendEmail(id,email,securityContext);
    }
    @PUT
    
    @Consumes({ "application/json", "application/xml" })
    
    @Operation(summary = "Actualizar una gráfica", description = "Actualizar una gráfica", tags={ "graphics" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Operación válida"),
        
        @ApiResponse(responseCode = "400", description = "ID proporcionado no válida"),
        
        @ApiResponse(responseCode = "404", description = "Gráfica no encontrada"),
        
        @ApiResponse(responseCode = "405", description = "No se pudo validar"),
        
        @ApiResponse(responseCode = "500", description = "Error Interno") })
    public Response updateGraphic(@Parameter(description = "Gráfica" ,required=true) Graphic body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateGraphic(body,securityContext);
    }
}
