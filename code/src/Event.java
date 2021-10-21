public abstract class Event {

  public String name;

  private void addEvent(Task t){};

  private void deleteEvent(Task t){};

  //private Event getChildren();

  public void acceptVisitor(){};

  public String getName(){return name;};


}
