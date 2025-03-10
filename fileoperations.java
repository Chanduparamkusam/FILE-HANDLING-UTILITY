import java.io.*;
import java.util.Scanner;

public class FileOperations {

    public static void main(String[] args) {
       String filename = "C:\\Users\\chand\\OneDrive\\Desktop\\practice class\\myTextFile.txt";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nFile Operations Menu:");
            System.out.println("1. Write to File");
            System.out.println("2. Read from File");
            System.out.println("3. Modify File (Append)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    writeFile(filename, scanner);
                    break;
                case 2:
                    readFile(filename);
                    break;
                case 3:
                    modifyFile(filename, scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void writeFile(String filename, Scanner scanner) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            System.out.println("Enter text to write to the file (type 'exit' on a new line to finish):");
            String line;
            while (true) {
                line = scanner.nextLine();
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Text written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("Contents of the file:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    public static void modifyFile(String filename, Scanner scanner) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            System.out.println("Enter text to append to the file (type 'exit' on a new line to finish):");
            String line;
            while (true) {
                line = scanner.nextLine();
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Text appended to file successfully.");
        } catch (IOException e) {
            System.err.println("Error modifying file: " + e.getMessage());
        }
    }
}
