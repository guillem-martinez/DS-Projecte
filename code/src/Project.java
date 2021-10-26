import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Project extends Event{


  private List<Event> children; //


  public Project(String name, Event father){
    super(name, father);
    children = new ArrayList<Event>();
  }

  @Override
  public void calculateDuration() {
    event_duration = Duration.ZERO;
    for(int i=0; i<children.size(); i++){
      event_duration = event_duration.plus(children.get(i).getDuration());
    }
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
