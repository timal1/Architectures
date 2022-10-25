package ru.timlad.handler.method;

import ru.timlad.config.Config;
import ru.timlad.domain.HttpRequest;
import ru.timlad.domain.HttpResponse;
import ru.timlad.domain.ResponseCode;
import ru.timlad.handler.Handler;
import ru.timlad.handler.response.creator.ResponseCreator;
import ru.timlad.handler.response.serializer.ResponseSerializer;
import ru.timlad.service.file.FileServiceFactory;
import ru.timlad.service.socket.SocketService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Handler(order = 0)
public class GetMethodHandler extends MethodHandler{

    private final String nameMethod = "GET";

    protected GetMethodHandler(SocketService socketService, ResponseCreator responseCreator, ResponseSerializer responseSerializer, Config config) {
        super(socketService, responseCreator, responseSerializer, config);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest httpRequest) {
        Path path = Paths.get(config.getWwwHome(), httpRequest.getUrl());

        if (!Files.exists(path)) {
           return responseCreator.createResponse(ResponseCode.NOT_FOUND, "<h1>Файл не найден!</h1>\n");

        }
        StringBuilder sb = FileServiceFactory.createFileService().readFromFile(path);
        return responseCreator.createResponse(ResponseCode.OK, sb.toString());
    }
}
