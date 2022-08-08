package com.moleo;

import java.awt.*;
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in); //scanner object to read the file
        ArrayList<Integer> list = new ArrayList<>(); // list to store ints from the file

        //get data from the file
        try {
            System.out.println("Enter the path of the file : ");
            Scanner scanner = new Scanner(new File(read.nextLine()));
            while (scanner.hasNextInt())
                list.add(scanner.nextInt());
            System.out.println(Arrays.toString(list.toArray()));
        } catch (FileNotFoundException e) {
            System.out.println("File not found sir!");
        }
        //convert Arraylist into an array
        int[] arr = list.stream().filter(t -> t != null).mapToInt(t -> t).toArray();


        //Hashset to get time taken for each algorithm
        Map<String, Long> timeTaken = new HashMap<>();


        int op;
        boolean b = false;
        System.out.println("---------------------------------------------------------");
        while (!b) {
            System.out.println("Choose an Algorithm to sort your data\nQuick Sort[1] Bubble sort[2] Merge sort[3] Selection sort[4]");
            op = read.nextInt();
            long start = System.currentTimeMillis();
            long time;
            switch (op) {
                case 1:
                    Algorithms.quickSort(arr);
                    time = start - System.currentTimeMillis();
                    System.out.println(Arrays.toString(arr));
                    timeTaken.put("Quick sort", time);
                    System.out.println("Time taken: " + time);
                    break;
                case 2:
                    Algorithms.bubbleSort(arr);
                    time = start - System.currentTimeMillis();
                    System.out.println(Arrays.toString(arr));
                    timeTaken.put("Bubble sort", time);
                    System.out.println("Time taken: " + time);
                    break;
                case 3:
                    Algorithms.mergeSort(arr);
                    time = start - System.currentTimeMillis();
                    System.out.println(Arrays.toString(arr));
                    timeTaken.put("Merge sort", time);
                    System.out.println("Time taken: " + time);
                    break;
                case 4:
                    Algorithms.selectionSort(arr);
                    time = start - System.currentTimeMillis();
                    System.out.println(Arrays.toString(arr));
                    timeTaken.put("Selection sort", time);
                    System.out.println("Time taken: " + time);
                    break;
                default:
                    System.out.println("Please enter valid response");
            }


            for (Map.Entry<String, Long> entry : timeTaken.entrySet()) {
                String algorithm = entry.getKey();
                Long t = entry.getValue();
                System.out.println("Time taken for " + algorithm + " : " + t);
            }

            System.out.println("Would you like to continue ? [y]");
            char ch = read.next().charAt(0);
            if (ch == 'y')
                b = false;
            else
                b = true;
        }
    }
}


