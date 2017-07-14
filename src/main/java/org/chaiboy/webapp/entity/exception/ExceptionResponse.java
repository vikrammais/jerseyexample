package org.chaiboy.webapp.entity.exception;


/**
 * Created by laxman.muttineni on 10/07/17.
 */
public class ExceptionResponse {

    @JsonProperty("response_code")
    private String responseCode;

    @JsonProperty("message")
    private String message;

    @JsonProperty("type")
    private String messageType = "ERROR";

    @JsonProperty("recommended_message")
    private String recommendedMessage;

}
