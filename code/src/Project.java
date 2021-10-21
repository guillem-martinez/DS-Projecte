import java.util.List;

public class Project extends Event{


  private List<Event> elements;
  public String proj_name;

  public void add(Event e){
    elements.add(e);
  }
}
