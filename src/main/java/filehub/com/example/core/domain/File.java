package filehub.com.example.core.domain;

import java.util.Objects;
import java.util.UUID;

public class File {

    private final UUID id;
    private final String name;

    public File(UUID id, String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("File name is required");
        }
        this.id = id;
        this.name = name.trim();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof File that)) {
            return false;
        }
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
