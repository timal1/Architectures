package ru.timlad.handler.request;

import ru.timlad.domain.HttpRequest;
import ru.timlad.handler.method.MethodHandler;
import ru.timlad.handler.method.MethodHandlerFactory;
import ru.timlad.service.socket.SocketService;
import ru.timlad.logger.ConsoleLogger;
import ru.timlad.logger.Logger;

import java.io.*;
import java.util.Deque;
import java.util.Iterator;

public class RequestHandler implements Runnable {

    private static final Logger logger = ConsoleLogger.createConsoleLogger();

    private final SocketService socketService;
    private final RequestParser requestParser;
    private final MethodHandler methodHandler;

    private RequestHandler(SocketService socketService,
                           RequestParser requestParser,
                           MethodHandler methodHandler) {
        this.socketService = socketService;
        this.requestParser = requestParser;
        this.methodHandler = methodHandler;
    }

    public static RequestHandler createRequestHandler(SocketService socketService, RequestParser parser, MethodHandler methodHandler) {
        return new RequestHandler(socketService, parser, methodHandler);
    }

    @Override
    public void run() {

        Deque<String> request = socketService.readRequest();
        HttpRequest httpRequest = requestParser.parse(request);
        Iterator<MethodHandler> iterator = MethodHandlerFactory.getMethodHandlers().iterator();
        methodHandler.handle(httpRequest, iterator);

        try {
            socketService.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        logger.info("Client disconnected!");
    }
}
