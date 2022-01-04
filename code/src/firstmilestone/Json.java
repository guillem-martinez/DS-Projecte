package firstmilestone;
import org.json.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Json {

  public void storeInfo(Event e, String file) throws IOException {
    JsonVisitor jsonVisitor = new JsonVisitor();
    e.acceptVisitor(jsonVisitor);

    FileWriter jsonFile = new FileWriter("./"+file,false);
    jsonFile.write(e.getJson().toString());
    jsonFile.close();
  }

  public void loadInfo(String file) throws IOException{
    FileReader jsonFile = new FileReader(file);
    JSONTokener reader = new JSONTokener(jsonFile);
    JSONObject obj = new JSONObject(reader);
    jsonFile.close();

  }

  public void generateTree(){

  }
}
