package ru.timlad.requesthandler;

import ru.timlad.responsehandler.ResponseSerializerImpl;
import ru.timlad.httpserver.SocketService;
import ru.timlad.config.Config;
import ru.timlad.domain.HttpRequest;
import ru.timlad.domain.HttpResponse;
import ru.timlad.logger.ConsoleLogger;
import ru.timlad.logger.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RequestHandler implements Runnable {
    private final Config config;

    private static final Logger logger = ConsoleLogger.createConsoleLogger();

    private final SocketService socketService;

    private RequestHandler(SocketService socketService, Config config) {
        this.socketService = socketService;
        this.config = config;
    }

    public static RequestHandler createRequestHandler(SocketService socketService, Config config) {
        return new RequestHandler(socketService, config);
    }

    @Override
    public void run() {

        List<String> request = socketService.readRequest();

        HttpRequest httpRequest = RequestParserImpl.createRequestParser().parse(request);
        Path path = Paths.get(config.getWwwHome(), httpRequest.getUrl());


        if (!Files.exists(path)) {

            HttpResponse httpResponse = HttpResponse.createBuilder()
                    .withStatusCode(404)
                    .withHttpStatus("NOT_FOUND")
                    .withHttpVersion("HTTP/1.1")
                    .withHttpContentType("Content-Type: text/html;")
                    .withCharset("charset=utf-8")
                    .build();

            String response = ResponseSerializerImpl.createResponseSerializer().serialize(httpResponse);
            socketService.writeResponse(response, new StringReader("<h1>Файл не найден!</h1>\n")
            );
            return;
        }

        try {

            HttpResponse httpResponse = HttpResponse.createBuilder()
                    .withStatusCode(200)
                    .withHttpStatus("OK")
                    .withHttpVersion("HTTP/1.1")
                    .withHttpContentType("Content-Type: text/html;")
                    .withCharset("charset=utf-8")
                    .build();

            String response = ResponseSerializerImpl.createResponseSerializer().serialize(httpResponse);
            socketService.writeResponse(response, Files.newBufferedReader(path));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logger.info("Client disconnected!");
    }
}
