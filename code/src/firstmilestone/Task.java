package firstmilestone;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


//Leaf element of Composite pattern that extends functionality of Fita1.Event
public class Task extends Event {

  public ArrayList<Interval> taskIntervals;

  public Task(int id, String name, Event father, List<String> tags) {
    super(id, name, father, tags);

    //Preconditions

    assert taskIntervals == null : "taskIntervals list must be null";

    taskIntervals = new ArrayList<Interval>();
    logger.info("Task: " + name + " created successfully");

    if (this.getFather() == null) {
      logger.warn("The Task " + this.name +  " does not have a father");
    }


    //PostConditions

    assert this.taskIntervals != null   : "taskIntervals list can not be null";
    assert this.taskIntervals.isEmpty() : "taskIntervals list must be empty";


  }

  @Override
  protected boolean invariant() {
    super.invariant();
    return (this.taskIntervals != null && this.getFather() != null);

  }

  //getters
  public ArrayList<Interval> getTaskIntervals() {
    return taskIntervals;
  }

  protected void startTask() {

    //Preconditions

    final int sizeBeforeAdd = taskIntervals.size();

    taskIntervals.add(new Interval(this));

    int sizeAfterAdd = taskIntervals.size();

    assert invariant();

    logger.debug("Task started. First interval assigned to the task");

    //Postconditions

    assert sizeAfterAdd == sizeBeforeAdd + 1 : "Size of taskIntervals list has to grow by 1";


  }

  @Override
  protected void addEvent(Event event){}

  //Calculates the durations of all his childs(Intervals)
  @Override
  protected void calculateDuration() {

    //Preconditions
    assert !this.taskIntervals.isEmpty() : "taskIntervals list can not be empty";

    eventDuration = Duration.ZERO;
    for (int i = 0; i < taskIntervals.size(); i++) {

      eventDuration = eventDuration.plus(taskIntervals.get(i).getDuration());
    }

    assert invariant();

    setDuration(eventDuration.plusSeconds(delay));
    logger.debug("Task duration calculated with the durations of it's intervals");

    //PostConditions

    assert eventDuration.getSeconds() > 0 : "The durations calculated must be greater than 0";



  }

  protected void stopTask() {


    //Precondition
    assert !this.taskIntervals.isEmpty() : "taskIntervals list needs a minimum of 1 interval";


    assert invariant();
    //Last Interval of its list is ended

    Interval last = taskIntervals != null && !taskIntervals.isEmpty()
        ? taskIntervals.get(taskIntervals.size() - 1) : null; //last = last element of listIntervals
    assert last != null;
    last.endInterval();

    this.setEndTime(last.getEndTime());
    this.setDuration(last.getDuration());
    logger.debug("Task stopped");
  }

  public void acceptVisitor(Visitor visitor) {

    //Preconditions

    assert visitor != null : "Visitor given by parameter can not be null";

    assert invariant();

    visitor.visitTask(this);
    //Visiting all its childs(Intervals)
    for (int i = 0; i < taskIntervals.size(); i++) {
      taskIntervals.get(i).acceptVisitor(visitor);
    }
  }



}
