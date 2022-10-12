package ru.timlad.requesthandler;

import ru.timlad.domain.HttpRequest;
import ru.timlad.domain.ResponseCode;
import ru.timlad.responsehandler.creator.ResponseCreator;
import ru.timlad.responsehandler.creator.ResponseCreatorFactory;
import ru.timlad.service.file.FileServiceFactory;
import ru.timlad.service.socket.SocketService;
import ru.timlad.config.Config;
import ru.timlad.logger.ConsoleLogger;
import ru.timlad.logger.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Deque;

public class RequestHandler implements Runnable {
    private final Config config;

    private static final Logger logger = ConsoleLogger.createConsoleLogger();

    private final SocketService socketService;
    private final RequestParser requestParser;


    private RequestHandler(SocketService socketService, RequestParser requestParser, Config config) {
        this.socketService = socketService;
        this.requestParser = requestParser;
        this.config = config;
    }

    public static RequestHandler createRequestHandler(SocketService socketService, RequestParser parser, Config config) {
        return new RequestHandler(socketService, parser, config);
    }

    @Override
    public void run() {

        Deque<String> request = socketService.readRequest();

        HttpRequest httpRequest = requestParser.parse(request);
        ResponseCreator responseCreator = ResponseCreatorFactory.createResponseCreator();

        if (httpRequest.getMethod().equals("GET")) {

            Path path = Paths.get(config.getWwwHome(), httpRequest.getUrl());

            if (!Files.exists(path)) {
                String response = responseCreator.createResponse(ResponseCode.NOT_FOUND, "<h1>Файл не найден!</h1>\n");
                socketService.writeResponse(response);
                return;
            }

            StringBuilder sb = FileServiceFactory.createFileService().readFromFile(path);
            String response = responseCreator.createResponse(ResponseCode.OK, sb.toString());
            socketService.writeResponse(response);

        } else {

            String response = responseCreator.createResponse(ResponseCode.METHOD_NOT_ALLOWED, "<h1>Метод не поддерживается!</h1>\n");
            socketService.writeResponse(response);
        }

        try {
            socketService.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        logger.info("Client disconnected!");
    }
}
