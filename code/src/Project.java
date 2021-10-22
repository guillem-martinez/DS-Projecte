import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Project extends Event{


  private List<Event> sons; //


  public Project(String name, Event father){
    super(name, father);
    this.sons = new ArrayList<>();
  }

  public void add(Event e){
    sons.add(e);
  }

  public void setProj_name(String name){
    this.name = name;
  }

  private void delete(Event e){
    if (sons.contains(e)){
          sons.remove(e);
    }
  }

  public List<Event> getChildren(){
    return sons;
  }


}
