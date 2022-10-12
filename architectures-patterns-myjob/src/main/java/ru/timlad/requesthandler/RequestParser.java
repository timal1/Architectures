package ru.timlad.requesthandler;

import ru.timlad.domain.HttpRequest;

import java.util.Deque;
import java.util.List;

public interface RequestParser {

    HttpRequest parse(Deque<String> rawRequest);
}
