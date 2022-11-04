package quotes;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;


public class Ron {
    String quotes;

    static Gson gson = new Gson();

    public Ron(String quotes) {
        this.quotes = quotes;
    }

    public static HttpURLConnection makeConnection(String api) throws MalformedURLException, IOException {
        URL ronURL = new URL(api);
        HttpURLConnection ronURLConnection = (HttpURLConnection) ronURL.openConnection();
        ronURLConnection.setRequestMethod("GET");
        return ronURLConnection;
    }



    public static Quotes readFromConnection(HttpURLConnection connection) throws IOException{

        InputStreamReader ronInputStreamReader = new InputStreamReader(connection.getInputStream());
        BufferedReader ronBufferedReader = new BufferedReader(ronInputStreamReader);
        Quotes ronQuote = gson.fromJson(ronBufferedReader, Quotes.class);
        return ronQuote;
    }

    public static Quotes ronParseData(JsonObject ronData) throws IOException{
        Quotes ron = gson.fromJson(ronData, Quotes.class);
        return ron;
    }

    public static void writeFile(Quotes ronSays) throws IOException{
        File ronQuotes = new File("./app/src/main/resources/RonQuote.json");
        try(FileWriter ronFileWriter = new FileWriter(ronQuotes)){
            gson.toJson(ronSays, ronFileWriter);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
