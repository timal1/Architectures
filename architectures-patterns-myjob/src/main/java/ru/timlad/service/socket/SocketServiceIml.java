package ru.timlad.service.socket;

import ru.timlad.logger.ConsoleLogger;
import ru.timlad.logger.Logger;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Deque;
import java.util.LinkedList;

class SocketServiceIml implements SocketService {

    private static final Logger logger = ConsoleLogger.createConsoleLogger();

    private final Socket socket;

   SocketServiceIml(Socket socket) {
        this.socket = socket;
    }

    @Override
    public Deque<String> readRequest() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream(), StandardCharsets.UTF_8));

            while (!input.ready());

            Deque<String> request = new LinkedList<>();
            while (input.ready()) {
                String line = input.readLine();
                logger.info(line);
                request.add(line);
            }
            return request;
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }

    @Override
    public void writeResponse(String headers) {
        try {
            PrintWriter output = new PrintWriter(socket.getOutputStream());
            output.print(headers);
            output.flush();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }

    @Override
    public void close() throws IOException {
        if (!socket.isClosed()) {
            socket.close();
        }
    }
}
