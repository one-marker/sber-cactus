package scanner3000;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void write_to_json(String fileneame){
        Gson gson = new Gson();
        try(FileWriter writer = new FileWriter(fileneame, false))
        {
            writer.write(gson.toJson(ScanResult.results));
            writer.flush();
        }
        catch(IOException ex){

            System.err.println(ex.getMessage());
        }
        finally {
            System.out.println("Written to file " + fileneame);
        }

    }

}
