package filehub.com.example.infrastructure.mapper;

import filehub.com.example.core.domain.File;
import filehub.com.example.infrastructure.provider.model.FileModel;

public final class FileMapper {

    private FileMapper() {}

    public static FileModel toModel(File file) {
        FileModel model = new FileModel();
        model.setId(file.getId());
        model.setName(file.getName());
        return model;
    }

    public static File toDomain(FileModel model) {
        return new File(model.getId(), model.getName());
    }
}
