package ru.timlad.httpserver;

import ru.timlad.config.Config;
import ru.timlad.handler.method.MethodHandlerFactory;
import ru.timlad.handler.response.creator.ResponseCreator;
import ru.timlad.handler.response.creator.ResponseCreatorFactory;
import ru.timlad.handler.response.serializer.ResponseSerializer;
import ru.timlad.handler.response.serializer.ResponseSerializerFactory;
import ru.timlad.logger.ConsoleLogger;
import ru.timlad.logger.Logger;
import ru.timlad.handler.request.RequestHandler;
import ru.timlad.handler.request.RequestParserFactory;
import ru.timlad.service.socket.SocketService;
import ru.timlad.service.socket.SocketServiceFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Connection {

    private static final Logger logger = ConsoleLogger.createConsoleLogger();
    public void getConnection(ServerSocket serverSocket, Config config) throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            logger.info("New client connected!");

            SocketService socketService = SocketServiceFactory.createSocketService(socket);
            ResponseSerializer responseSerializer = ResponseSerializerFactory.createResponseSerializer();
            ResponseCreator responseCreator = ResponseCreatorFactory.createResponseCreator();

            new Thread(RequestHandler.createRequestHandler(
                    socketService,
                    RequestParserFactory.createRequestParser(),
                    MethodHandlerFactory.create(socketService, responseCreator, responseSerializer, config)))
                    .start();
        }
    }
}
