package firstmilestone;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;



//Composite element of Composite pattern that extends functionality of Fita1.Event
public class Project extends Event {


  private List<Event> events; //


  public Project(String name, Event father, List<String> tags) {
    super(name, father, tags);
    events = new ArrayList<Event>();
    logger.debug("Project: " + name + " created successfully");
    logger.debug("Project: " + name + " has this events " + events);
  }

  @Override
  protected boolean invariant() {
    super.invariant();
    return (this.events != null);

  }

  //Getters
  public List<Event> getEvents() {
    return events;
  }

  //Calculates the duration of all his childs
  @Override
  protected void calculateDuration() {
    eventDuration = Duration.ZERO;
    for (int i = 0; i < events.size(); i++) {
      eventDuration = eventDuration.plus(events.get(i).getDuration());
    }
    setDuration(eventDuration.plusSeconds(delay));
  }

  protected void addEvent(Event e) {
    events.add(e);
  }

  public void acceptVisitor(Visitor visitor) {

    assert invariant();

    visitor.visitProject(this);
    for (int i = 0; i < events.size(); i++) {
      events.get(i).acceptVisitor(visitor);
    }
  }


}
