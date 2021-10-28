import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Project extends Event{


  private List<Event> events; //


  public Project(String name, Event father){
    super(name, father);
    events = new ArrayList<Event>();
    System.out.println(name+" SUCCESSFUL");
  }

  @Override
  public void calculateDuration() {
    event_duration = Duration.ZERO;
    for(int i=0; i<events.size(); i++){
      event_duration = event_duration.plus(events.get(i).getDuration());
    }
    setDuration(event_duration);

  }
  public Duration getDuration(){
    return event_duration;
  }

  public void addEvent(Event e){
    events.add(e);
  }

  public void setProj_name(String proj_name){
    name = proj_name;
  }

  private void delete(Event e){
    if (events.contains(e)){
          events.remove(e);
    }
  }

  public List<Event> getEvents(){
    return events;
  }

  public void acceptVisitor(Visitor visitor){
    visitor.visitProject(this);
    for(int i=0; i<events.size(); i++){
      events.get(i).acceptVisitor(visitor);
    }
  }


}
