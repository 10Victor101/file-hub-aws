package filehub.com.example.infrastructure.provider;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import filehub.com.example.infrastructure.provider.model.FileModel;

public interface FileProviderImpl extends JpaRepository<FileModel, UUID> {
}
