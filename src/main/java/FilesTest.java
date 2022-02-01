import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilesTest {

    public static void main(String[] args) {
//        obtemTamanhoArquivo();
//        verificaSeEhDiretorio();
//        leituraArquivoFiles();
        exibirArquivosDoDiretorio();
    }

    private static void obtemTamanhoArquivo() {
        try {
            System.out.println("Tam do arquivo (bytes): " + Files.size(Paths.get(FileIOStreamTest.NOME_ARQUIVO)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void verificaSeEhDiretorio() {
        System.out.println("Eh diretorio? " + Files.isDirectory(Paths.get(FileIOStreamTest.NOME_ARQUIVO)));
        Paths.get(FileIOStreamTest.NOME_ARQUIVO);
    }

    private static void leituraArquivoFiles() {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(FileIOStreamTest.NOME_ARQUIVO));
            System.out.println(allLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void exibirArquivosDoDiretorio() {
        try {
            DirectoryStream<Path> paths = Files.newDirectoryStream(Path.of("."));
            for (Path path : paths) {
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
