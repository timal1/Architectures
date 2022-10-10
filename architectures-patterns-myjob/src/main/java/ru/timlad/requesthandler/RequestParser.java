package ru.timlad.requesthandler;

import ru.timlad.domain.HttpRequest;

import java.util.List;

public interface RequestParser {

    HttpRequest parse(List<String> rawRequest);
}
