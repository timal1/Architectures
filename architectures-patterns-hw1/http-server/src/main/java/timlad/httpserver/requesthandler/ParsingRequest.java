package timlad.httpserver.requesthandler;

import java.io.BufferedReader;
import java.io.IOException;

public class ParsingRequest {

    public String parsingRequest(BufferedReader input) throws IOException {
        String firstLine = input.readLine();
        String[] parts = firstLine.split(" ");
        System.out.println(firstLine);

        while (input.ready()) {
            System.out.println(input.readLine());
        }
        return parts[1];
    }
}
