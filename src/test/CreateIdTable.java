package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CreateIdTable {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/ashish.unhale/IdeaProjects/Codes/src/resources/UsersData";

        // Creating an instance of Inputstream
        InputStream is = new FileInputStream(path);

        // Try block to check for exceptions
        try (Scanner sc = new Scanner(
                is, StandardCharsets.UTF_8.name())) {

            // It holds true till there is single element
            // left in the object with usage of hasNext()
            // method
            while (sc.hasNextLine()) {

                // Printing the content of file
                String entry = sc.nextLine();
                String [] arr = entry.split(" ");
                //System.out.println("@Column(name=" +  arr[2] + ")");
                System.out.println("@JsonProperty(\"" +arr[2] + "\"" +")");
                //System.out.println("private String " +entry +";");
                System.out.println(entry +";");
            }
        }
    }
}
