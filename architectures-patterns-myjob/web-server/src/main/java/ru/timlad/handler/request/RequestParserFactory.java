package ru.timlad.handler.request;

public class RequestParserFactory {

    public static RequestParser createRequestParser() {
        return new RequestParserImpl();
    }
}
