import java.time.Duration;
import java.util.ArrayList;
import java.util.List;



//Leaf element of Composite pattern that extends functionality of Event
public class Task extends Event {

  public ArrayList<Interval> task_intervals;

  public Task(String name, Event father) {
    super(name,father);
    task_intervals = new ArrayList<Interval>();
    System.out.println(name+" SUCCESSFUL");
  }

  //getters
  public ArrayList<Interval> getTask_intervals(){ return task_intervals;}

  protected void startTask(){
    task_intervals.add(new Interval(this));
  }

  @Override
  protected void addEvent(Event event){}

  //Calculates the durations of all his childs(Intervals)
  @Override
  protected void calculateDuration() {
    event_duration = Duration.ZERO;
    for(int i=0; i<task_intervals.size(); i++){

      event_duration = event_duration.plus(task_intervals.get(i).getDuration());
    }
    setDuration(event_duration.plusSeconds(delay));
  }

  protected void stopTask(){
    Interval last = task_intervals != null && !task_intervals.isEmpty() ? task_intervals.get(task_intervals.size() - 1) : null;
    last.endInterval();
    this.setEndTime(last.getEndTime());
    this.setDuration(last.getDuration());
  }

  public void acceptVisitor(Visitor visitor){
    visitor.visitTask(this);
    for(int i=0; i<task_intervals.size(); i++){
      task_intervals.get(i).acceptVisitor(visitor);
    }
}



}
