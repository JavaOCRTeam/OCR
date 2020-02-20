package OCR;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class App 
{
    private static final Path PATH = FileSystems.getDefault().getPath("").toAbsolutePath();

    public static void main( String[] args )
    {
        String fileName = args[0];

    }

    private static List<List<String>> readFile(String fileName) {
        List<List<String>> listOfList = new ArrayList<>();
        String s1;
        String s2;
        String s3;
        String s4;

        try (FileReader reader = new FileReader(PATH.resolve(fileName).toFile());
                BufferedReader br = new BufferedReader(reader)) {

            do {
                s1 = br.readLine();
                s2 = br.readLine();
                s3 = br.readLine();
                s4 = br.readLine();
                if (s4 != null) {
                    listOfList.add(Arrays.asList(s1, s2, s3, s4));
                }
            } while (s4 != null);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfList;
    }
}
