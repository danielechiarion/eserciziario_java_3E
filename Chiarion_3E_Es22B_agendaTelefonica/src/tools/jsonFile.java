package tools;

import org.json.*;
import java.io.*;
import java.nio.file.*;

/* classe per gestire file json  */
public class jsonFile {
    /**
     * Method to rewrite all data in JSON in case
     * of changes in the middle of the file.
     * It avoids write again the same things
     *
     * @param path
     * @param object
     */
    public static void rewriteFileJSON(String path, Object object)
    {
        try {
            FileWriter file = new FileWriter(path); //search file to write on
            file.write(object.toString()); //upload element to file
            file.flush();
            file.close(); //close file
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to convert all data in JSON into an array.
     *
     * @param path
     */
    public static JSONArray readDataJSON(String path)
    {
        /* variable declaration
         * out of try-catch */
        String content;
        /* array creation */
        JSONArray vet = new JSONArray();

        /* using a string to catch all datas from JSON */
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* trasforming string into an array */
        vet = new JSONArray(content);
        return vet;
    }
}
