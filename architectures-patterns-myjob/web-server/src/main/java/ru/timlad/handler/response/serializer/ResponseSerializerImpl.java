package ru.timlad.handler.response.serializer;

import ru.timlad.domain.HttpResponse;


class ResponseSerializerImpl implements ResponseSerializer{

    @Override
    public String serialize(HttpResponse httpResponse) {
        StringBuilder sb = new StringBuilder();
        sb.append(httpResponse.getHttpVersion() + " "
                + httpResponse.getStatus().getStatus() + " "
                + httpResponse.getStatus().getName() + "\n");
        httpResponse.getHeaders().forEach((header, value) -> {
            sb.append(header + ": " + value + "\n");
        });
            sb.append("\n");
        sb.append(httpResponse.getBody());
        return sb.toString();
    }
}
