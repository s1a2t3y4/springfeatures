 
package com.satya.springfeatures.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.satya.springfeatures.model.Request;
import com.satya.springfeatures.model.Response;

/**
 *
 * @author Satya Vulisetti
 * @version 1.0.0
 * @since 1.0.0
 */

@Path("/v1/spring")
public interface SpringResource {
 
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	void saveRequestInfo(Request request) throws Exception;
 
	 

}
