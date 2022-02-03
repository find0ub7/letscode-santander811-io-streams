package apache.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static com.letscode.io.FileIOStreamTest.NOME_ARQUIVO;

public class ApacheCommonsIOTest {

    public static void main(String[] args) {
        fileUtils();
    }

    private static void fileUtils() {
        System.out.println(FileUtils.getTempDirectory());
        System.out.println(FileUtils.getUserDirectory());

        copyFile();
        readFile();
        writeFile();

    }

    private static void copyFile() {
//        File file = Path.of(NOME_ARQUIVO).toFile();
        File file = FileUtils.getFile(NOME_ARQUIVO);

        try {
            FileUtils.copyFile(file, new File("copia.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile() {
//        FileUtils.readLines()
    }

    private static void writeFile() {
//        FileUtils.writeLines();
    }
}
