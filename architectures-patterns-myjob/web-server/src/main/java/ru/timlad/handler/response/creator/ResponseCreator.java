package ru.timlad.handler.response.creator;

import ru.timlad.domain.HttpResponse;
import ru.timlad.domain.ResponseCode;

public interface ResponseCreator {

    HttpResponse createResponse(ResponseCode responseCode, String body);
}
