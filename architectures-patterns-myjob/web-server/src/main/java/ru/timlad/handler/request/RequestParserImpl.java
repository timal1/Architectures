package ru.timlad.handler.request;

import ru.timlad.domain.HttpRequest;

import java.util.Deque;

class RequestParserImpl implements RequestParser{

    @Override
    public HttpRequest parse(Deque<String> rawRequest) {
        String[] parts = rawRequest.pollFirst().split(" ");

        HttpRequest.Builder builder = HttpRequest.createBuilder();
        builder.withMethod(parts[0]);
        builder.withUrl(parts[1]);

        while (!rawRequest.isEmpty()) {
            String line = rawRequest.pollFirst();
            if ((line.isBlank())) {
                break;
            }
            String[] header = line.split(": ");
            builder.withHeader(header[0], header[1]);
        }
        StringBuilder body = new StringBuilder();
        while (!rawRequest.isEmpty()) {
            body.append(rawRequest.pollFirst());
        }
        builder.withBody(body.toString());
        return builder.build();
    }
}
