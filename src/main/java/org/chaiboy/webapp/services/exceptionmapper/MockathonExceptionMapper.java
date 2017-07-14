package org.chaiboy.webapp.services.exceptionmapper;

import com.google.common.collect.Maps;
import org.chaiboy.webapp.entity.exception.ExceptionResponse;
import org.chaiboy.webapp.entity.exception.MockathonException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.Map;

/**
 * Created by laxman.muttineni on 10/07/17.
 */
public class MockathonExceptionMapper implements ExceptionMapper<MockathonException> {

    @Override
    public Response toResponse(MockathonException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage(),
                getMessageProperty(e.getMessage(), StringUtils.EMPTY, e.getDtName()),
                getMessageProperty(e.getMessage(), TYPE_IDENTIFIER, e.getDtName()),
                getMessageProperty(e.getMessage(), MESSAGE_IDENTIFIER, e.getDtName())
        );

        Map<String, Object> tempMap = Maps.newHashMap();
        tempMap.put("exception_response", exceptionResponse);

        MockathonException response = new MockathonException(
                MDC.get("uid"),
                tempMap,
                e.getNextNodeId(),
                false,
                MDC.get("id")
        );

        return Response.status(e.getCode()).entity(response).build();
    }
}
