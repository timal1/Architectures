package ru.timlad.handler.request;

import ru.timlad.domain.HttpRequest;

import java.util.Deque;

public interface RequestParser {

    HttpRequest parse(Deque<String> rawRequest);
}
