package timlad.httpserver.responsehandler;

import java.io.PrintWriter;

public class BadResponse {

    public void badResponse(PrintWriter output) {
        output.println("HTTP/1.1 404 NOT_FOUND");
        output.println("Content-Type: text/html; charset=utf-8");
        output.println();
        output.println("<h1>Файл не найден!</h1>");
        output.flush();
    }
}
