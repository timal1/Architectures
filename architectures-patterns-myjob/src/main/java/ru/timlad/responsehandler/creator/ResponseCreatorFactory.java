package ru.timlad.responsehandler.creator;

public class ResponseCreatorFactory {

    public static ResponseCreator createResponseCreator() {
        return new ResponseCreatorImpl();
    }

}
