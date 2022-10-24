package ru.timlad.handler.response.serializer;

import ru.timlad.domain.HttpResponse;

public interface ResponseSerializer {

    String serialize(HttpResponse httpResponse);
}
