package ru.timlad.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

    private String httpVersion;
    private ResponseCode status;

    private Map<String, String> headers = new HashMap<>();

    private String body;

    public String getHttpVersion() {
        return httpVersion;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public ResponseCode getStatus() {
        return status;
    }

    private HttpResponse() {
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final HttpResponse httpResponse;

        private Builder() {
            this.httpResponse = new HttpResponse();
        }

        public Builder withHttpVersion(String httpVersion) {
            this.httpResponse.httpVersion = httpVersion;
            return this;
        }

        public Builder withStatus(ResponseCode statusCode) {
            this.httpResponse.status= statusCode;
            return this;
        }

        public Builder withHeader(String header, String value) {
            this.httpResponse.headers.put(header, value);
            return this;
        }

        public Builder withHeaders(Map<String, String> headers) {
            this.httpResponse.headers.putAll(headers);
            return this;
        }

        public Builder withBody(String body) {
            this.httpResponse.body = body;
            return this;
        }

        public HttpResponse build() {
            if (this.httpResponse.status == null) {
                throw new IllegalArgumentException("Status is obligatory for Response");
            }
            return this.httpResponse;
        }
    }
}
