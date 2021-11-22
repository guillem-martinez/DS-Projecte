import java.time.Duration;
import java.util.ArrayList;
import java.util.List;



//Composite element of Composite pattern that extends functionality of Event
public class Project extends Event{


  private List<Event> events; //


  public Project(String name, Event father, List<String> tags){
    super(name, father, tags);
    events = new ArrayList<Event>();
    logger.debug(name+" created successfully");
  }

  //Getters
  public List<Event> getEvents(){
    return events;
  }

  //Calculates the duration of all his childs (Task/Projects with more childs or not) and Adds all the durations.
  @Override
  protected void calculateDuration() {
    eventDuration = Duration.ZERO;
    for(int i=0; i<events.size(); i++){
      eventDuration = eventDuration.plus(events.get(i).getDuration());
    }
    setDuration(eventDuration.plusSeconds(delay));
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
