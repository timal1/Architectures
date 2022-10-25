package ru.timlad.handler.response.creator;

import ru.timlad.domain.HttpResponse;
import ru.timlad.domain.ResponseCode;

class ResponseCreatorImpl implements ResponseCreator{

    @Override
    public HttpResponse createResponse(ResponseCode responseCode, String body) {
        return HttpResponse.createBuilder()
                .withHttpVersion("HTTP/1.1")
                .withStatus(responseCode)
                .withHeader("ContentType", "text/html; charset=utf-8")
                .withBody(body)
                .build();
    }
}
