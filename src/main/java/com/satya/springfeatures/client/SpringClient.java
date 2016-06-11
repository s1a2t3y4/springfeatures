 
package com.satya.springfeatures.client;

/**
 * Injectable client for the spring Trail Service.
 *
 * @author Satya Vulisetti
 * @version 1.0.0
 * @since 1.0.0
 */
import java.lang.reflect.AnnotatedElement;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.satya.springfeatures.model.Request;
import com.satya.springfeatures.model.Response;

/**
 * Public class for the spring client which is part of the spring Trail Service.
 *
 * @author Satya Vulisetti
 * @version 1.0.0
 * @since 1.0.0
 */

@Component
public class SpringClient implements SpringResource {

	/** The endpoint url. */
	@Value("${service.endpoint.url:}")
	private String endpointUrl;
 

	 

	/** The spring resource. */
	private SpringResource SpringResource = null;

	/**
	 * Constructor
	 *
	 */
	public SpringClient() {
		super();
	}

	/**
	 * Constructor
	 *
	 * @param endpointUrl
	 *            the endpoint url
	 */
	public SpringClient(String endpointUrl) {
		this.endpointUrl = endpointUrl;
	}

	/**
	 * Set the endpoint url.
	 *
	 * @param endpointUrl
	 *            the new endpoint
	 */
	public void setEndpointUrl(String endpointUrl) {
		this.endpointUrl = endpointUrl;
	}

	/**
	 * Lazy initializes and returns spring resource.
	 *
	 * @return the spring resource
	 */
	public synchronized SpringResource getSpringResource() {
		if (SpringResource == null) {
			SpringResource = WebResourceFactory.newResource(SpringResource.class, ClientBuilder.newBuilder().build().target(endpointUrl));
		}

		return SpringResource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sca.spring.client.SpringResource#savespringInfo(com.sca.spring
	 * .model.spring)
	 */
	public void saveRequestInfo(Request request) throws Exception {
 
		WebTarget target = addPathFromAnnotation(SpringResource.class, ClientBuilder.newBuilder().build().target(endpointUrl));

		final AsyncInvoker asyncInvoker = target.request().async();
		asyncInvoker.post(Entity.entity(request, MediaType.APPLICATION_JSON), SpringResource.class);

	}

	 

	private static WebTarget addPathFromAnnotation(final AnnotatedElement ae, WebTarget target) {
		final Path p = ae.getAnnotation(Path.class);
		if (p != null) {
			target = target.path(p.value());
		}
		return target;
	}

 

}