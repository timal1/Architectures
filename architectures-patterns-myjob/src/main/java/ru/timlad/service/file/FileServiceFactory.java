package ru.timlad.service.file;

public class FileServiceFactory {

    public static FileService createFileService() {
        return new FileServiceImpl();
    }
}
