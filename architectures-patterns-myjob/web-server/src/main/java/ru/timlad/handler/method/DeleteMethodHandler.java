package ru.timlad.handler.method;

import ru.timlad.config.Config;
import ru.timlad.domain.HttpRequest;
import ru.timlad.domain.HttpResponse;
import ru.timlad.domain.ResponseCode;
import ru.timlad.handler.Handler;
import ru.timlad.handler.response.creator.ResponseCreator;
import ru.timlad.handler.response.serializer.ResponseSerializer;
import ru.timlad.service.socket.SocketService;

@Handler(order = 3)
public class DeleteMethodHandler extends MethodHandler {

    private final String nameMethod = "DELETE";

    protected DeleteMethodHandler(SocketService socketService, ResponseCreator responseCreator, ResponseSerializer responseSerializer, Config config) {
        super(socketService, responseCreator, responseSerializer, config);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest httpRequest) {
        return responseCreator.createResponse(ResponseCode.OK, "<h1>Delete method handler</h1>");
    }
}
