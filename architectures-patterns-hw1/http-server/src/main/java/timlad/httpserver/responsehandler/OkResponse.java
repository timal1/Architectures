package timlad.httpserver.responsehandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class OkResponse {
    public void okResponse(Path path, PrintWriter output) throws IOException {
        output.println("HTTP/1.1 200 OK");
        output.println("Content-Type: text/html; charset=utf-8");
        output.println();

        Files.newBufferedReader(path).transferTo(output);
        System.out.println("Client disconnected!");
    }
}
