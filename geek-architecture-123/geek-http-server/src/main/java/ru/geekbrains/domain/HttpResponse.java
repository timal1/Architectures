package ru.geekbrains.domain;

public class HttpResponse {

    private int statusCode;

    private String httpStatus;

    private String httpVersion;

    private String contentType;

    private String charset;


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public HttpResponse(int statusCode, String httpStatus, String httpVersion, String contentType, String charset) {
        this.statusCode = statusCode;
        this.httpStatus = httpStatus;
        this.httpVersion = httpVersion;
        this.contentType = contentType;
        this.charset = charset;
    }
}
