package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.logger.ConsoleLogger;
import ru.geekbrains.logger.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RequestHandler implements Runnable {

    private String WWW = "C:\\GeekBrains\\My_jobs\\webinar_Architectures_and_patterns_Java\\lesson_2\\geek-architecture-123\\geek-architecture-123\\www";


    private static final Logger logger = new ConsoleLogger();

    private final SocketService socketService;

    public RequestHandler(SocketService socketService) {
        this.socketService = socketService;
    }

    @Override
    public void run() {

        List<String> request = socketService.readRequest();

        RequestParser requestParser = new RequestParserImpl();
        HttpRequest httpRequest = requestParser.parse(request);
        Path path = Paths.get(WWW, httpRequest.getPath());


        if (!Files.exists(path)) {
            HttpResponse httpResponse = new HttpResponse( 404, "NOT_FOUND", "HTTP/1.1",
                    "Content-Type: text/html;", "charset=utf-8");
            ResponseSerializer responseSerializer = new ResponseSerializerImpl();
            String response = responseSerializer.serialize(httpResponse);
            socketService.writeResponse(response,
                   new StringReader("<h1>Файл не найден!</h1>\n")
            );
            return;
        }

        try {
            HttpResponse httpResponse = new HttpResponse( 200, "OK", "HTTP/1.1",
                    "Content-Type: text/html;", "charset=utf-8");
            ResponseSerializer responseSerializer = new ResponseSerializerImpl();
            String response = responseSerializer.serialize(httpResponse);
            socketService.writeResponse(response,
                    Files.newBufferedReader(path));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logger.info("Client disconnected!");
    }
}
