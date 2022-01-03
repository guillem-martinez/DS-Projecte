package firstmilestone;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;



//Composite element of Composite pattern that extends functionality of Event
public class Project extends Event {


  private List<Event> events; //


  public Project(int id, String name, Event father, List<String> tags) {
    super(id, name, father, tags);

    //Preconditions
    assert this.events == null : "Event list (Children) must be null";

    events = new ArrayList<Event>();


    //PostConditions

    assert this.events != null   : "Event list (Children) can not be null";
    assert this.events.isEmpty() : "Event list (Children) must be empty";


    if (this.getFather() == null) {
      logger.warn("The project " + this.name +  " does not have a father");
    }

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

  //Calculates the duration of all his childs(Projects or Tasks)
  @Override
  protected void calculateDuration() {

    //Preconditions
    assert !this.events.isEmpty() : "Events list (Children) can not be empty";

    eventDuration = Duration.ZERO;
    //Duration is the sum of all its childs durations.
    for (int i = 0; i < events.size(); i++) {
      eventDuration = eventDuration.plus(events.get(i).getDuration());
    }

    assert invariant();
    //Delay(2s) added as it's specified in the project conditions
    setDuration(eventDuration.plusSeconds(delay));

    //PostConditions
    assert eventDuration.getSeconds() > 0 : "The durations calculated must be greater than 0";
  }

  protected void addEvent(Event e) {

    //Precondition

    assert e != null : "Event given by parameter can not be null";

    int sizeBeforeAdd = events.size();

    events.add(e);

    assert invariant();

    int sizeAfterAdd = events.size();

    //PostConditions

    assert sizeBeforeAdd + 1 == sizeAfterAdd  : "Size of Event list has to grow by 1";



  }

  public void acceptVisitor(Visitor visitor) {

    //Preconditions

    assert visitor != null : "Visitor given by parameter can not be null";

    assert invariant();

    visitor.visitProject(this);
    //Visiting all its childs(Projects or Tasks)
    for (int i = 0; i < events.size(); i++) {
      events.get(i).acceptVisitor(visitor);
    }
  }


}
