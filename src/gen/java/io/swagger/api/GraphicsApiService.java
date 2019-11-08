package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import java.util.Date;
import java.io.File;
import io.swagger.model.Graphic;
import io.swagger.model.Magnitude;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2019-11-08T18:16:35.551Z[GMT]")public abstract class GraphicsApiService {
    public abstract Response addGraphic(Graphic body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteGraphicById(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findGraphicByMagnitude( @NotNull Magnitude magnitude,SecurityContext securityContext) throws NotFoundException;
    public abstract Response generate( @NotNull Magnitude magnitude, @NotNull Date startDate, @NotNull Date endDate,SecurityContext securityContext) throws NotFoundException;
    public abstract Response generatePdf(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response generatePng(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getGraphicById(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendEmail(Long id, @NotNull String email,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateGraphic(Graphic body,SecurityContext securityContext) throws NotFoundException;
}
