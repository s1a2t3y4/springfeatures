 
package com.satya.springfeatures.service;

import com.satya.springfeatures.exceptions.ServiceException;
import com.satya.springfeatures.model.Request;
import com.satya.springfeatures.model.Response;
 
public interface SpringService {
 
	Response saveRequestInfo(Request request) throws ServiceException;
 
}
