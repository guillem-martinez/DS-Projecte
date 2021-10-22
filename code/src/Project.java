import java.util.LinkedList;
import java.util.List;

public class Project extends Event{


  private List<Event> sons; //


  public Project(List<Event> list){

    sons = list;
  }

  public void add(Event e){
    sons.add(e);
  }

  public void setProj_name(String name){
    proj_name = name;
  }

  private void delete(Event e){
    if (sons.contains(e)){
          sons.remove(e);
    }
  }

  public void getChildren(){

  }


}
