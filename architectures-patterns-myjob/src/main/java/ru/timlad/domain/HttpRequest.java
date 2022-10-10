package ru.timlad.domain;

import java.util.Map;

public class HttpRequest {

    private String method;

    private String url;

    private Map<String, String> headers;

    private String body;


    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }


    public Map<String, String> getHeaders() {
        return headers;
    }


    public String getBody() {
        return body;
    }

    private HttpRequest() {
    }


    public static class Builder {

        private final HttpRequest httpRequest;

        public Builder() {
            this.httpRequest = new HttpRequest();
        }

        public Builder withPath(String url) {
            this.httpRequest.url = url;
            return this;
        }

        public Builder withMethod(String method) {
            this.httpRequest.method = method;
            return this;
        }

        public Builder withHeaders(Map<String, String> headers) {
            this.httpRequest.headers = headers;
            return this;
        }

        public Builder withBody(String body) {
            this.httpRequest.body = body;
            return this;
        }

        public HttpRequest build() {
            return this.httpRequest;
        }

    }
}
