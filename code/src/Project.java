import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Project extends Event{


  private List<Event> children; //


  public Project(String name, Event father){
    super(name, father);
    this.children = new ArrayList<>();
  }

  @Override
  public Duration calculateDuration() {
    return null;
  }

  public void add(Event e){
    children.add(e);
  }

  public void setProj_name(String proj_name){
    name = proj_name;
  }

  private void delete(Event e){
    if (children.contains(e)){
          children.remove(e);
    }
  }

  public List<Event> getChildren(){
    return children;
  }


}
