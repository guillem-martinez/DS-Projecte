import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



//Composite element of Composite pattern that extends functionality of Event
public class Project extends Event{


  private List<Event> events; //


  public Project(String name, Event father){
    super(name, father);
    events = new ArrayList<Event>();
    System.out.println(name+" SUCCESSFUL");
  }

  //Getters
  public List<Event> getEvents(){
    return events;
  }

  //Calculates the duration of all his childs (Task/Projects with more childs or not) and Adds all the durations.
  @Override
  protected void calculateDuration() {
    event_duration = Duration.ZERO;
    for(int i=0; i<events.size(); i++){
      event_duration = event_duration.plus(events.get(i).getDuration());
    }
    setDuration(event_duration);
  }

  protected void addEvent(Event e){
    events.add(e);
  }

  public void acceptVisitor(Visitor visitor){
    visitor.visitProject(this);
    for(int i=0; i<events.size(); i++){
      events.get(i).acceptVisitor(visitor);
    }
  }


}
