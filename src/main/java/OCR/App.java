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

    public static List<String> parseList(List<String> list) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < list.get(0).length(); i += 3) {
            result.add(list.get(0).substring(i, i+3) +
                       list.get(1).substring(i, i+3) +
                       list.get(2).substring(i, i+3));
        }

        return result;
    }

    public static List<List<String>> parseListList(List<List<String>> listOfList) {
        List<List<String>> result = new ArrayList<>();

        for (List<String> list : listOfList) {
            result.add(parseList(list));
        }
        return result;
    }

    public static List<List<String>> readFile(String fileName) {
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
                    listOfList.add(Arrays.asList(s1, s2, s3));
                }
            } while (s4 != null);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfList;
    }

    public static Integer parseNumeralString(String s) {
        switch(s) {
            case "     |  |":
                return 1;
            case " _  _||_ ":
                return 2;
            case " _  _| _|":
                return 3;
            case "   |_|  |":
                return 4;
            case " _ |_  _|":
                return 5;
            case " _ |_ |_|":
                return 6;
            case " _   |  |":
                return 7;
            case " _ |_||_|":
                return 8;
            case " _ |_| _|":
                return 9;
            case " _ | ||_|":
                return 0;
            default:
                return -1;
        }
    }

    public static List<Integer> numberStringsToInts(List<String> list) {
        List<Integer> resultList = new ArrayList<>();
        for(String s : list) {
            resultList.add(parseNumeralString(s));
        }
        return resultList;
    }

    public static List<List<Integer>> numberStringListsToIntLists(List<List<String>> listlist) {
        List<List<Integer>> resultListList = new ArrayList<>();
        for(List<String> list : listlist) {
            resultListList.add(numberStringsToInts(list));
        }
        return resultListList;
    }
}
