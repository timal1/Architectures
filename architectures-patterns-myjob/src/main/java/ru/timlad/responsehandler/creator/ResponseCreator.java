package ru.timlad.responsehandler.creator;

import ru.timlad.domain.ResponseCode;

public interface ResponseCreator {

    String createResponse(ResponseCode responseCode, String body);
}
