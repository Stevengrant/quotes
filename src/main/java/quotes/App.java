/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }
    public static Object sayQuote(){
        try {

            File file = new File("src/main/resources/recentquotes.json");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            Gson gson = new Gson();
            String fromFileStream;
            String stringAccumulator = "";
            //https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
            while ((fromFileStream = reader.readLine()) != null){
                stringAccumulator += fromFileStream;
            }
            ArrayList<Object> parsedJson = gson.fromJson(stringAccumulator, (Type) Object.class);
//            Object parsedQuotes = gson.toJson(reader.readLine());
            int randomIndex = (int) Math.floor(Math.random() * parsedJson.size()) +1;
//            System.out.println("Parsed Quote: " +parsedQuotes.toString());
            System.out.println(parsedJson.get(randomIndex));
            return parsedJson.get(randomIndex);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
      return null;
    }
    public static void main(String[] args) {
        sayQuote();
        System.out.println(new App().getGreeting());
//        BufferedReader reader = new BufferedReader();
//        String json = reader.lines()

    }

}
