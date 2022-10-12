package ru.timlad.responsehandler.creator;

import ru.timlad.domain.HttpResponse;
import ru.timlad.domain.ResponseCode;
import ru.timlad.responsehandler.serializer.ResponseSerializerFactory;

class ResponseCreatorImpl implements ResponseCreator{

    @Override
    public String createResponse(ResponseCode responseCode, String body) {
        HttpResponse httpResponse = HttpResponse.createBuilder()
                .withHttpVersion("HTTP/1.1")
                .withStatus(responseCode)
                .withHeader("ContentType", "text/html; charset=utf-8")
                .withBody(body)
                .build();

        String response = ResponseSerializerFactory.createResponseSerializer().serialize(httpResponse);
        return response;
    }
}
