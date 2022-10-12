package ru.timlad.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

    private String method;

    private String url;

    private Map<String, String> headers = new HashMap<>();

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

    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder {

        private final HttpRequest httpRequest;

        private Builder() {
            this.httpRequest = new HttpRequest();
        }

        public Builder withUrl(String url) {
            this.httpRequest.url = url;
            return this;
        }

        public Builder withMethod(String method) {
            this.httpRequest.method = method;
            return this;
        }

        public Builder withHeader(String header, String value) {
            this.httpRequest.headers.put(header, value);
            return this;
        }

        public Builder withHeaders(Map<String, String> headers) {
            this.httpRequest.headers.putAll(headers);
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

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + "\'" +
                ", url='" + url + "\'" +
                ", headers=" + headers +
                ", body='" + body + "\'" +
                '}';
    }
}
