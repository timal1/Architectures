package ru.timlad.requesthandler;

public class RequestParserFactory {

    public static RequestParser createRequestParser() {
        return new RequestParserImpl();
    }
}
