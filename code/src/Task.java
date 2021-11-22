import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


//Leaf element of Composite pattern that extends functionality of Event
public class Task extends Event {

  public ArrayList<Interval> taskIntervals;
//Related problems estan al MAIN
  public Task(String name, Event father, List<String> tags) {
    super(name, father, tags);
    taskIntervals = new ArrayList<Interval>();
    System.out.println(name + " SUCCESSFUL");
  }

  //getters
  public ArrayList<Interval> getTaskIntervals() {
    return taskIntervals;
  }

  protected void startTask() {
    taskIntervals.add(new Interval(this));
  }

  @Override
  protected void addEvent(Event event){}

  //Calculates the durations of all his childs(Intervals)
  @Override
  protected void calculateDuration() {
    eventDuration = Duration.ZERO;
    for (int i = 0; i < taskIntervals.size(); i++) {

      eventDuration = eventDuration.plus(taskIntervals.get(i).getDuration());
    }
    setDuration(eventDuration.plusSeconds(delay));
  }

  protected void stopTask() {
    Interval last = taskIntervals != null && !taskIntervals.isEmpty()
        ? taskIntervals.get(taskIntervals.size() - 1) : null;
    assert last != null;
    last.endInterval();
    this.setEndTime(last.getEndTime());
    this.setDuration(last.getDuration());
    logger.debug("Task finalized");
  }

  public void acceptVisitor(Visitor visitor) {
    visitor.visitTask(this);
    for (int i = 0; i < taskIntervals.size(); i++) {
      taskIntervals.get(i).acceptVisitor(visitor);
    }
  }



}
