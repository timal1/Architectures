package ru.timlad.service.file;

import java.nio.file.Path;

public interface FileService {

    StringBuilder readFromFile(Path path);
}
