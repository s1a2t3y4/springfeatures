package com.satya.springfeatures.service.impl;

import org.springframework.stereotype.Component;

import com.satya.springfeatures.exceptions.ServiceException;
import com.satya.springfeatures.model.Request;
import com.satya.springfeatures.model.Response;
import com.satya.springfeatures.service.SpringService;

/**
 *
 * @author Satya Vulisetti
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class SpringServiceImpl implements SpringService {

 

	 
	@Override
	public Response saveRequestInfo(Request request) throws ServiceException {
  
		try {
			Response res=new Response();
			res.setResponse("hello dude");
			return res;
		} catch (Exception e) {
			throw new ServiceException("error while saving spring info", e);
		}

	}

	 

	 
}
