import java.time.Duration;
import java.util.List;

public class Task extends Event {

  List<Interval> task_intervals;
  private Duration task_duration;

  public Task(String n, List<Interval> intervals, Duration duration) {
    super(n);
    task_intervals = intervals;
    task_duration = duration;

  }

  public void setTaskName(String name){
    this.name = name;
  }
  
  public Duration getDuration(){
    return task_duration;
  }
}
