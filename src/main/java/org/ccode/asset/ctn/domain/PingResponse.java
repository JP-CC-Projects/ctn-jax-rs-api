package org.ccode.asset.ctn.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class PingResponse {
    public PingResponse() {
    }
    @JsonProperty
    private String timeStamp = Instant.now().toString();
    @JsonProperty
    private String responseMessage;

    @JsonProperty
    private String serverStatus = "OK";

    @JsonProperty
    private String apiVersion = "1.0";

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

}
