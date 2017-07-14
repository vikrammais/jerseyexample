package org.chaiboy.webapp.services.interceptors;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import org.chaiboy.webapp.services.annotations.Secured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;


/**
 * Created by laxman.muttineni on 10/07/17.
 */
@Provider
@Secured
public class RequestFilter implements ContainerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestFilter.class);

    @Override
    public ContainerRequest filter(ContainerRequest containerRequest) {

        return null;
    }

    private void setUidForRequest(ContainerRequest containerRequest) {

        String transId = containerRequest.getHeaderValue("X-Request-ID");
        //MDC.put("id", transId);
        logger.info("Request Id from client : " + transId);
        MultivaluedMap<String, String> requestHeaders = containerRequest.getRequestHeaders();
        logger.info("Request headers : ");

        for(MultivaluedMap.Entry entry : requestHeaders.entrySet())
            logger.info(entry.getKey() + " : " + entry.getValue());

        String clientIp = "NOT_AVAILABLE";

        if (requestHeaders.containsKey("FK-CLIENT-IP")) {
            clientIp = requestHeaders.get("FK-CLIENT-IP").get(0);
            MDC.put("FK-CLIENT-IP", clientIp);

        }
        logger.info("Method : " + containerRequest.getMethod() + "  Request url :" + containerRequest.getRequestUri().toString() + " IP Address : " + clientIp);
    }
}
