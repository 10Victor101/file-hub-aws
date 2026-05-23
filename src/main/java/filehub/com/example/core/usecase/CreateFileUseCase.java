package filehub.com.example.core.usecase;

import filehub.com.example.core.domain.File;
import filehub.com.example.core.provider.FileProvider;
import org.springframework.stereotype.Service;

@Service
public class CreateFileUseCase {

    private final FileProvider fileProvider;

    public CreateFileUseCase(FileProvider fileProvider) {
        this.fileProvider = fileProvider;
    }

    public File execute(String name) {
        File file = new File(null, name);
        return fileProvider.save(file);
    }
}
