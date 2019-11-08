package io.swagger.api.factories;

import io.swagger.api.GraphicsApiService;
import io.swagger.api.impl.GraphicsApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2019-11-08T18:16:35.551Z[GMT]")public class GraphicsApiServiceFactory {
    private final static GraphicsApiService service = new GraphicsApiServiceImpl();

    public static GraphicsApiService getGraphicsApi() {
        return service;
    }
}
