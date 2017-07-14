package org.chaiboy.webapp.entity.exception;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by laxman.muttineni on 10/07/17.
 */
public class MockathonException extends Exception {

    private String executionId;

    private int code;

    private static final Logger logger = LoggerFactory.getLogger(MockathonException.class);

    public MockathonException(int code,
                              String message) {
        super(message);
        this.code = code;
        this.executionId = context.getExecutionId();
    }

    public MockathonException(int code,
                              String message,
                              Throwable throwable) {
        super(message, throwable);
        this.code = code;
        this.executionId = context.getExecutionId();
    }

    public static MockathonException createFromReflectiveOperationException(int code,
                                                                            ReflectiveOperationException e) {
        Map<String, Object> returnMsg = new HashMap<String, Object>();
        returnMsg.put("Status code", code);
        returnMsg.put("Message", e.getCause().getMessage());
        StackTraceElement[] stackTraceElements = e.getCause().getStackTrace();
        List<StackTraceElement> stackTraceElementList = Arrays.asList(stackTraceElements);
        returnMsg.put("Cause Stack", stackTraceElementList.subList(0, stackTraceElementList.size() > 5 ? 5 : stackTraceElementList.size()));
        logger.info("Exception Dump and Cause Stack" + returnMsg.toString());
        logger.error(e.getCause().getMessage(), e.getMessage(), e.getCause());
        return new MockathonException(code, e.getCause().getMessage(), e);
    }

}
