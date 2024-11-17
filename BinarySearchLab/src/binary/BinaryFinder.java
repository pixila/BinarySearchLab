package binary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BinaryFinder {

    public static void main(String[] args) {
        // Declare a filename of type String and assign it to the path of lab3.txt
        String fileName = "D:\\lab3.txt";

        // Declare an array numbers of type double assuming a max of 100 numbers in the input file
        double[] numbers = new double[100];

        int count = 0; // counter for the number of numbers found

        try {
            // Uses a Scanner object scanner to read in the input file
            Scanner scanner = new Scanner(new File(fileName));

            // Checks each token using the hasNext() method
            while (scanner.hasNext()) {
                // If the token is a number using the hasNextDouble() method, then
                // it is added to the numbers array, and the count variable is incremented.
                if (scanner.hasNextDouble()) {
                    numbers[count] = scanner.nextDouble();
                    count++;
                } else {
                    scanner.next(); // skip non-integer token
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }

        // If no numbers were found, inform the user
        if (count == 0) {
            System.out.println("No numbers were found in the file.");
            return; // exit the program as there's nothing to process
        }

        System.out.println("Numbers found:");
        // Print the numbers found using a for loop
        for (int i = 0; i < count; i++) {
            System.out.println(numbers[i]);
        }

        // Sort the numbers array to perform binary search
        Arrays.sort(numbers, 0, count);

        // Since the array is sorted, the smallest number will always be at index 0
        double smallestNumber = numbers[0];

        // Perform binary search for the smallest number
        int index = Arrays.binarySearch(numbers, 0, count, smallestNumber);

        // Output the smallest number and its index
        System.out.println("The smallest number is: " + smallestNumber);
        System.out.println("Found at index: " + index);
    }
}
