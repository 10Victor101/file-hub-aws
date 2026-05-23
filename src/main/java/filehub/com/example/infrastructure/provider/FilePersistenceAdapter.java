package filehub.com.example.infrastructure.provider;

import org.springframework.stereotype.Repository;
import filehub.com.example.core.domain.File;
import filehub.com.example.core.provider.FileProvider;
import filehub.com.example.infrastructure.mapper.FileMapper;

@Repository
public class FilePersistenceAdapter implements FileProvider {

    private final FileProviderImpl repository;

    public FilePersistenceAdapter(FileProviderImpl repository) {
        this.repository = repository;
    }

    @Override
    public File save(File file) {
        return FileMapper.toDomain(repository.save(FileMapper.toModel(file)));
    }
}
