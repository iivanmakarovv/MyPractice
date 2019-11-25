package iivanmakarovvarraylisthome.arraylisthomemain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    private static ArrayList<String> getStringsFromFile(String fileDirectory, String fileName) throws FileNotFoundException {
        File input = new File(fileDirectory, fileName);

        try (Scanner scanner = new Scanner(new FileInputStream(input))) {
            ArrayList<String> fileStrings = new ArrayList<>();

            while (scanner.hasNextLine()) {
                fileStrings.add(scanner.nextLine());
            }

            return fileStrings;
        }
    }

    private static void deleteAllEvenNumbers(ArrayList<Integer> numbersList) {
        for (int i = 0; i < numbersList.size(); ++i) {
            if (numbersList.get(i) % 2 == 0) {
                numbersList.remove(i);
                --i;
            }
        }
    }

    private static ArrayList<Integer> getListWithoutRepeatingNumbers(ArrayList<Integer> listWithRepeating) {
        ArrayList<Integer> listWithoutRepeating = new ArrayList<>();

        for (int i = 0; i < listWithRepeating.size(); ++i) {
            if (i == 0) {
                listWithoutRepeating.add(i, listWithRepeating.get(i));
            } else if (!listWithoutRepeating.contains(listWithRepeating.get(i))) {
                listWithoutRepeating.add(listWithRepeating.get(i));
            }
        }

        return listWithoutRepeating;
    }

    public static void main(String[] args) {
        try {
            String fileDirectory = "C:/Users/Ivan/Desktop";
            String fileName = "arraylisthome.txt";
            System.out.println(getStringsFromFile(fileDirectory, fileName));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        deleteAllEvenNumbers(numbersList);
        System.out.println(numbersList);

        ArrayList<Integer> listWithRepeating = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 1, 5, 6, 3, 7, 8, 2, 9, 10));
        System.out.println(getListWithoutRepeatingNumbers(listWithRepeating));
    }
}