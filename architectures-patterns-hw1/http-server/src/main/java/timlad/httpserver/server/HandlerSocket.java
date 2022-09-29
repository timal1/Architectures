package timlad.httpserver.server;

import timlad.httpserver.requesthandler.HandlerRequest;
import timlad.httpserver.responsehandler.CreateResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HandlerSocket {

    public void handlerSocket(Socket socket) {
        try (BufferedReader input = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter output = new PrintWriter(socket.getOutputStream())
        ) {
            HandlerRequest handlerRequest = new HandlerRequest();
            String partPath = handlerRequest.handlerRequest(input);
            CreateResponse createResponse = new CreateResponse();
            createResponse.createResponse(partPath, output);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
