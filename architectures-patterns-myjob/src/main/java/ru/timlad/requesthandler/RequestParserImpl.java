package ru.timlad.requesthandler;

import ru.timlad.domain.HttpRequest;

import java.util.List;

public class RequestParserImpl implements RequestParser{

    public static RequestParserImpl createRequestParser() {
        return new RequestParserImpl();
    }
    @Override
    public HttpRequest parse(List<String> rawRequest) {
        String[] parts = rawRequest.get(0).split(" ");

        HttpRequest httpRequest = new HttpRequest.Builder()
                .withPath(parts[1])
                .build();

        return httpRequest;
    }
}
