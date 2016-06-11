package com.satya.springfeatures.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.springfeatures.exceptions.ServiceException;
import com.satya.springfeatures.model.Request;
import com.satya.springfeatures.service.SpringService;
import com.sca.configuration.service.util.Utils;

 

/**
 * @author Satya Vulisetti
 * @version 1.0.0
 * @since 1.0.0
 */

@Path("/v1/spring")
@Service
public class RestSpringService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(SpringService.class);

	/** The spring service. */
	@Autowired
	private SpringService springService;

	/**
	 * The method saves spring information asynchronously to the database
	 * 
	 * 
	 * The method receives the springTrail as parameter which holds the spring
	 * details.
	 * 
	 * 
	 * @param springInfo
	 *            springTrail
	 * @throws WebApplicationException
	 *             in case of any error
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void savespringInfo(@Suspended final AsyncResponse asyncResponse, final Request request) throws WebApplicationException {

		try {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						springService.saveRequestInfo(request);
						final Response response = Response.status(Response.Status.OK).build();
						asyncResponse.resume(response);
					} catch (ServiceException e) {
						logger.error("Error occured when executing springTrailService#savespringInfo method", e);
					}
				}
			}).start();
		} catch (Exception ex) {
			logger.error("Error occured when executing springTrailService#savespringInfo method", ex);

			final Response response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Utils.getStackTraceAsString(ex)).build();

			throw new WebApplicationException(response);
		}
	};

 
}
