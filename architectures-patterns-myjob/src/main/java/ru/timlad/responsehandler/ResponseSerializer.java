package ru.timlad.responsehandler;

import ru.timlad.domain.HttpResponse;

public interface ResponseSerializer {

    String serialize(HttpResponse httpResponse);
}
