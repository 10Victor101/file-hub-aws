package filehub.com.example.infrastructure.controller;

import java.net.URI;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import filehub.com.example.core.domain.File;
import filehub.com.example.core.usecase.CreateFileUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/file")
public class FileController {

    private final CreateFileUseCase createFileUseCase;

    public FileController(CreateFileUseCase createFileUseCase) {
        this.createFileUseCase = createFileUseCase;
    }

    @PostMapping
    public ResponseEntity<FileResponse> create(@Valid @RequestBody FileRequest request) {
        File file = createFileUseCase.execute(request.name());
        URI location = URI.create("/file/" + file.getId());

        return ResponseEntity.created(location)
                .body(new FileResponse(file.getId(), file.getName()));
    }

    public record FileRequest(@NotBlank String name) {
    }

    public record FileResponse(UUID id, String name) {
    }
}
