import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;

/**
 * This program reads data from an input file (Unit2-02-input.txt),
 * processes each line by extracting integers, and calculates their sum.
 *
 * If a value is not an integer, an error message is displayed.
 * If a line contains no valid integers, a different error message is shown.
 * The results are printed to the console and saved in an output
 * file (Unit2-02-output.txt).
 *
 * @author Santiago Hewett
 * @version 1.0
 * @since 2025/03/21
 */
final class FileIO {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private FileIO() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Main method that reads from a file, processes its contents,
     * and writes the results to an output file.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(final String[] args) throws Exception {

        // String to store the output that will be written to the file
        String outputStr = "";

        // Initialize sum variable
        int sum = 0;

        // Create a FileWriter to write to the output file
        FileWriter myWriter = new FileWriter("./Unit2-02-output.txt");

        // Create a File object to read from the input file
        File file = new File("./Unit2-02-input.txt");

        // Create a Scanner object to read the file line by line
        Scanner scanner = new Scanner(file);

        // Process each line of the input file
        while (scanner.hasNextLine()) {

            // Reset sum for each line
            sum = 0;

            // Counter for valid integers on the line
            int numValidInt = 0;

            // Read the current line
            String line = scanner.nextLine();

            // Display the line in the console
            System.out.println(line);

            // Split the line into individual words/numbers
            String[] arrayNumString = line.split(" ");

            // Process each word in the line
            for (String numAsString : arrayNumString) {
                try {
                    // Attempt to convert the string to an integer
                    int numAsInt = Integer.parseInt(numAsString);

                    // Add the valid integer to the sum
                    sum += numAsInt;

                    // Increment the valid integer count
                    numValidInt++;
                } catch (Exception exception) {
                    // If conversion fails, note that it's not a valid integer
                    outputStr += (numAsString + " is not a valid integer.\n");
                }
            }

            // Check if there were any valid integers on the line
            if (numValidInt == 0) {
                outputStr += "Error: No integers found on this line.\n\n";
            } else {
                outputStr += "The sum of the valid numbers is " + sum + "\n\n";
            }
        }

        // Write the processed output to the output file
        myWriter.write(outputStr);

        // Print a success message
        System.out.println("\nSuccessfully wrote to the output file.");

        // Close the file writer and scanner
        myWriter.close();
        scanner.close();
    }
}
