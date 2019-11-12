package iivanmakarovvarraylisthome.arraylisthomemain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    private static ArrayList<String> addToListStringsFromFile(ArrayList<String> list, String fileName) throws FileNotFoundException {
        File input = new File("C:/Users/Ivan/Desktop", fileName);

        try (Scanner scanner = new Scanner(new FileInputStream(input))) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        }

        return list;
    }

    private static ArrayList<Integer> deleteAllEvenNumbers(ArrayList<Integer> list) {
        //list.removeIf(element -> element % 2 == 0); (Сначала сделал таким образом)

        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                --i;
            }
        }

        return list;
    }

    private static ArrayList<Integer> addToNewListNotRepeatingNumbers(ArrayList<Integer> list) {
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(0, list.get(0));

        for (int i = 1; i < list.size(); ++i) {
            boolean isRepeating = false;
            for (Integer element : list2) {
                if (list.get(i).equals(element)) {
                    isRepeating = true;
                }
            }

            if (!isRepeating) {
                list2.add(list.get(i));
            }
        }

        return list2;
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        String fileName = "arraylisthome.txt";
        System.out.println(addToListStringsFromFile(list, fileName));

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(deleteAllEvenNumbers(list2));

        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 1, 5, 6, 3, 7, 8, 2, 9, 10));
        System.out.println(addToNewListNotRepeatingNumbers(list3));
    }
}