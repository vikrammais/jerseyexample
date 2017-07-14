package org.chaiboy.webapp.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.http.HttpStatus;

/**
 * Created by laxman.muttineni on 15/11/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse {

    private static final String SUCCESS = "SUCCESS";

    private String token;

    private int statusCode;

    private String message;

    public BaseResponse() {
        statusCode = HttpStatus.SC_OK;
        message = SUCCESS;
    }

    public BaseResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
