package com.letscode.io;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileIOStreamTest {

    public static final String NOME_ARQUIVO = "fileIOStream.txt";
    public static final String NOME_DIR = "diretorioNovo/subdiretorio";

    public static void main(String[] args) throws Exception {
//        criacaoArquivoSimples();
//        escreveArquivoNovoFileOutputStream();
//        escreveArquivoComPrintWriter();
//        criarDiretorio("novoDir");
//        criarDiretorio("novoDir/subDir");
//        escreveArquivoExistenteFileOutputStream();
//        leituraArquivoFileInputStream();
//        leituraArquivoScanner();
        leituraArquivoBufferedReader();
    }

    private static void escreveArquivoComPrintWriter() {
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(NOME_ARQUIVO))){
            printWriter.print("alguma coisa escrita com printWriter");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void criarDiretorio(String novoDir) {
        if (new File(novoDir).mkdir()) {
//        if (new File(novoDir).mkdirs()) {
            System.out.println("Criou dir");
        }
    }

    private static void criacaoArquivoSimples() {
        File file = new File(NOME_ARQUIVO);
        try {
            if (file.createNewFile()) {
                System.out.println("criou arquivo");
            } else {
                System.out.println("nao criou arquivo");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void escreveArquivoNovoFileOutputStream() {
        //try-with-resources
        try (FileOutputStream fileOutputStream = new FileOutputStream(NOME_ARQUIVO)) {
            fileOutputStream.write("sobrescreve?".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void escreveArquivoExistenteFileOutputStream() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(NOME_ARQUIVO, true)) {
            fileOutputStream.write("\nnovo conteudo em arquivo existente".getBytes(UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leituraArquivoFileInputStream() {
        try (FileInputStream fileInputStream = new FileInputStream(NOME_ARQUIVO)) {
            int c;
            while ((c = fileInputStream.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leituraArquivoScanner() {
        try (Scanner scanner = new Scanner(Path.of(NOME_ARQUIVO))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leituraArquivoBufferedReader() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(NOME_ARQUIVO, UTF_8))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
