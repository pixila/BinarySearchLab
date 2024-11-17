package binary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class NumberFinder {
    public static void main(String[] args) {

        // Specify the path of the input file 'BinarySearch.txt'
        String fileName = "D:\\BinarySearch.txt";

        // Declare an array 'numbers' of type double to hold up to 100 numbers from the input file
        double[] numbers = new double[100];

        int count = 0; // Counter to keep track of how many numbers are found

        try {
            // Initialize a Scanner object to read from the specified input file
            Scanner scanner = new Scanner(new File(fileName));

            // Iterate through the tokens in the file
            while (scanner.hasNext()) {
                // If the token is a valid number, add it to the 'numbers' array and increment the counter
                if (scanner.hasNextDouble()) {
                    numbers[count] = scanner.nextDouble();
                    count++;
                } else {
                    // If the token is not a number, skip it
                    scanner.next();
                }
            }

            // Close the Scanner after reading all tokens
            scanner.close();

        } catch (FileNotFoundException e) {
            // Handle the case where the file is not found
            System.out.println("File not found: " + fileName);
        }

        // Print all the numbers found in the input file (before sorting)
        System.out.println("Numbers found in the file (before sorting):");
        for (int i = 0; i < count; i++) {
            System.out.println(numbers[i]);
        }

        // Sort the 'numbers' array to find the smallest number
        Arrays.sort(numbers, 0, count);

        // Print the sorted numbers
        System.out.println("Numbers after sorting:");
        for (int i = 0; i < count; i++) {
            System.out.println(numbers[i]);
        }

        // The smallest number will be the first element in the sorted array
        double smallestNumber = numbers[0];

        // Perform a binary search for the smallest number to find its index
        int index = Arrays.binarySearch(numbers, 0, count, smallestNumber);

        // Output the smallest number and its index in the sorted array
        System.out.println("The smallest number is: " + smallestNumber);
        System.out.println("Found at index: " + index);
    }
}
