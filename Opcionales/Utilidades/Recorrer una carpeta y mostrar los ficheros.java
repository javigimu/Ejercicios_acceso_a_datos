import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {
    public static void extractPngFiles(String path) throws IOException {

        List<Path> result;
        try (Stream<Path> walk = Files.walk(Paths.get(path), 1)) {
            result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        }
        result.forEach(f -> System.out.println(f.getFileName()));

    }
}
