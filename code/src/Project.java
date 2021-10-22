import java.util.LinkedList;
import java.util.List;

public class Project extends Event{


  private List<Event> elements; //preguntar profe
  public String proj_name;

  public Project(String name, LinkedList<Event> list){
    proj_name = name;
    elements = list;
  }

  public void add(Event e){
    elements.add(e);
  }

  public void setProj_name(String name){
    proj_name = name;
  }

  private void delete(Event e){
    if (elements.contains(e)){

    }
  }

  public void getChildren(){
    elements.
  }


}
