package ru.timlad.handler.method;

import ru.timlad.config.Config;
import ru.timlad.domain.HttpRequest;
import ru.timlad.domain.HttpResponse;
import ru.timlad.domain.ResponseCode;
import ru.timlad.handler.Handler;
import ru.timlad.handler.response.creator.ResponseCreator;
import ru.timlad.handler.response.serializer.ResponseSerializer;
import ru.timlad.service.socket.SocketService;

@Handler(order = 2)
public class PutMethodHandler extends MethodHandler{

    private final String nameMethod = "PUT";

    protected PutMethodHandler(SocketService socketService, ResponseCreator responseCreator, ResponseSerializer responseSerializer, Config config) {
        super(socketService, responseCreator, responseSerializer, config);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest httpRequest) {
        return responseCreator.createResponse(ResponseCode.OK, "<h1>Put method handler</h1>");
    }
}
