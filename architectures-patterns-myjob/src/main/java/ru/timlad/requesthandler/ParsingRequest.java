package ru.timlad.requesthandler;

import java.io.BufferedReader;
import java.io.IOException;

public class ParsingRequest {

    public String parsingRequest(BufferedReader input) throws IOException {
        String firstLine = input.readLine();
        String[] parts = firstLine.split(" ");

        while (input.ready()) {
            System.out.println(input.readLine());
        }
        return parts[1];
    }
}
