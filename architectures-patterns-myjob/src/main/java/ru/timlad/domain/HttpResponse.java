package ru.timlad.domain;

public class HttpResponse {

    private int statusCode;

    private String httpStatus;

    private String httpVersion;

    private String contentType;

    private String charset;

    public int getStatusCode() {
        return statusCode;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public String getContentType() {
        return contentType;
    }

    public String getCharset() {
        return charset;
    }

    private HttpResponse() {
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final HttpResponse httpResponse;

        public Builder() {
            this.httpResponse = new HttpResponse();
        }

        public Builder withStatusCode(int statusCode) {
            this.httpResponse.statusCode = statusCode;
            return this;
        }

        public Builder withHttpStatus(String httpStatus) {
            this.httpResponse.httpStatus = httpStatus;
            return this;
        }

        public Builder withHttpVersion(String httpVersion) {
            this.httpResponse.httpVersion = httpVersion;
            return this;
        }

        public Builder withHttpContentType(String contentType) {
            this.httpResponse.contentType = contentType;
            return this;
        }

        public Builder withCharset(String charset) {
            this.httpResponse.charset = charset;
            return this;
        }

        public HttpResponse build() {
            return this.httpResponse;
        }
    }
}
