package firstmilestone;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


//Leaf element of Composite pattern that extends functionality of Fita1.Event
public class Task extends Event {

  public ArrayList<Interval> taskIntervals;

  private boolean active;

  public Task(int id, String name, Event father, List<String> tags) {
    super(id, name, father, tags);

    //Preconditions

    assert taskIntervals == null : "taskIntervals list must be null";

    taskIntervals = new ArrayList<Interval>();
    logger.info("Task: " + name + " created successfully");
    this.active = false;

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

  public void startTask() {

    //Preconditions

    final int sizeBeforeAdd = taskIntervals.size();

    taskIntervals.add(new Interval(this));

    this.active = true;

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

  public void stopTask() {


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
    this.active = false;

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

  @Override
  public Event findActivityById(int id) {
    if (this.id == id) {
      return this;
    } else {
      return null;
    }
  }

  @Override
  public JSONObject toJson(int depth) {
    json.put("id", this.id);
    json.put("name", this.name);
    json.put("initTime", this.initTime);
    json.put("endTime", this.endTime);
    /*json.put("duration", this.humanReadableFormat(this.eventDuration).substring(0,
        this.humanReadableFormat(this.getDuration()).length() - 1));

     */
    json.put("duration",this.getDuration().toSeconds());
    json.put("class", this.getClass().getName().substring(15));
    json.put("parent", this.father.getName());
    json.put("tags", this.tags);
    json.put("active", this.active);
    JSONArray intervals = new JSONArray();

    if(depth > 0) {
      for(int i = 0; i < this.getTaskIntervals().size(); i++) {
        JSONObject child = this.getTaskIntervals().get(i).toJson(depth - 1);
        intervals.put(child);
      }
      }
      json.put("intervals", intervals);


    return json;
  }
}
