package ru.timlad.handler.response.creator;

public class ResponseCreatorFactory {

    public static ResponseCreator createResponseCreator() {
        return new ResponseCreatorImpl();
    }

}
