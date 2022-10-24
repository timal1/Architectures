package ru.timlad.handler.method;

import ru.timlad.config.Config;
import ru.timlad.domain.HttpRequest;
import ru.timlad.domain.HttpResponse;
import ru.timlad.domain.ResponseCode;
import ru.timlad.handler.response.creator.ResponseCreator;
import ru.timlad.handler.response.serializer.ResponseSerializer;
import ru.timlad.service.socket.SocketService;

import java.lang.reflect.Field;
import java.util.Iterator;

public abstract class MethodHandler {

    protected final SocketService socketService;

    protected final Config config;

    protected final ResponseCreator responseCreator;

    private final ResponseSerializer responseSerializer;

    protected MethodHandler(SocketService socketService, ResponseCreator responseCreator, ResponseSerializer responseSerializer, Config config) {
        this.socketService = socketService;
        this.config = config;
        this.responseSerializer = responseSerializer;
        this.responseCreator = responseCreator;
    }

    public void handle(HttpRequest httpRequest, Iterator<MethodHandler> iterator) {
        HttpResponse response;
        String nameMethod;
        nameMethod = getNameMethod();

        if (httpRequest.getMethod().equals(nameMethod)) {
                response = handleInternal(httpRequest);
            } else if (iterator.hasNext()){
            iterator.next().handle(httpRequest, iterator);
                return;
        } else {
            response = responseCreator.createResponse(ResponseCode.METHOD_NOT_ALLOWED, "<h1>Метод не поддерживается!</h1>\n");
        }

        String rawResponse = responseSerializer.serialize(response);
        socketService.writeResponse(rawResponse);
    }

    private String getNameMethod() {
        String nameMethod;
        try {
            Field fNameMethod = this.getClass().getDeclaredField("nameMethod");
            fNameMethod.setAccessible(true);
            nameMethod = (String) fNameMethod.get(this);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return nameMethod;
    }

    protected abstract HttpResponse handleInternal(HttpRequest httpRequest);
}
