package entidade;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Arquivo {
    private final List<Oscar> oscar;

    public Arquivo(String filename) {
        this.oscar = lerArquivo(filename);
    }

    private List<Oscar> lerArquivo(String filename) {
        try (Stream<String> fileLines = Files.lines(Paths.get(filename))) {
            return fileLines
                    .skip(1)
                    .map(Oscar::of)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<Oscar> getOscarList() {
        return oscar;
    }
}
