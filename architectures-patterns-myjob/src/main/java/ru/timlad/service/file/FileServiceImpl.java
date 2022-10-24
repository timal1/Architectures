package ru.timlad.service.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FileServiceImpl implements FileService{

    @Override
    public StringBuilder readFromFile(Path path) {
        StringBuilder sb = new StringBuilder();
        try {
            Files.readAllLines(path).forEach(sb::append);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return sb;
    }
}
