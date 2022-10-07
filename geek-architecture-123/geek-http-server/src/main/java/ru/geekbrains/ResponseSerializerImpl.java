package ru.geekbrains;

import ru.geekbrains.domain.HttpResponse;


public class ResponseSerializerImpl implements ResponseSerializer{
    @Override
    public String serialize(HttpResponse httpResponse) {

        return httpResponse.getHttpVersion() + " " + httpResponse.getStatusCode() + " " + httpResponse.getHttpStatus() + "\n" +
                httpResponse.getContentType() + " " + httpResponse.getCharset() + "\n\n";
    }
}
