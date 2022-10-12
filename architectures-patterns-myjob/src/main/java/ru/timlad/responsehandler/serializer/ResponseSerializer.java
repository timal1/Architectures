package ru.timlad.responsehandler.serializer;

import ru.timlad.domain.HttpResponse;

public interface ResponseSerializer {

    String serialize(HttpResponse httpResponse);
}
