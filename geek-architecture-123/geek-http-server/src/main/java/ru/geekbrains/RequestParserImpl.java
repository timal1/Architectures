package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RequestParserImpl implements RequestParser{
    @Override
    public HttpRequest parse(List<String> rawRequest) {
        String[] parts = rawRequest.get(0).split(" ");

        String path = parts[1];
        HttpRequest httpRequest = new HttpRequest(path);

        return httpRequest;
    }
}
