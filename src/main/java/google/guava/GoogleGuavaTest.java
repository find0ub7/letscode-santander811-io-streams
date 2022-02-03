package google.guava;

import com.google.common.io.CharSource;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class GoogleGuavaTest {

    public static void main(String[] args) {
        CharSource charSource = Files.asCharSource(new File("arquivo.txt"), StandardCharsets.UTF_8);
        try {
            charSource.readLines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
