import java.util.LinkedList;
import java.util.List;

public class Project extends Event{


  private LinkedList<Event> elements; //preguntar profe
  public String proj_name;

  public void add(Event e){
    elements.add(e);
  }

  public void setProj_name(String name){
    proj_name = name;
  }

  private void delete(String name){

  }


}
