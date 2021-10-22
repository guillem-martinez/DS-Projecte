public abstract class Event {

  public String name;
  private Event father;

  public Event(String n){
      name = n;
  }

  private void addEvent(Task t){};

  private void deleteEvent(Task t){};

  public Event getFather(Event e){

    return father;
  }
  public void acceptVisitor(){};

  public String getName(){return name;};


}
