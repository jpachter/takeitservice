package com.takeit.resources;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/add")
public class MainResource {
	
    @GET
	@Produces(MediaType.APPLICATION_JSON)
    public ServiceResponse add(@QueryParam("arg01") Integer arg01, @QueryParam("arg02") Integer arg02) {
        return new ServiceResponse(true, arg01 + arg02);
    }
    
    static class ServiceResponse {
        private final Boolean status;
        private final Object data;

        public ServiceResponse(Boolean status, Object data) {
            this.status = status;
            this.data = data;
        }

        public Boolean getStatus() {
            return status;
        }

        public Object getData() {
            return data;
        }

    }
}