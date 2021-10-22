public abstract class Event {

  protected String name;
  private Event father;

  public Event(String n, Event f){
      this.name = n;
      this.father = f;
  }

  public void setName(String n){
    this.name = n;
  }

  public String getName(){
    return name;
  }


  public Event getFather(Event e) {return father;}
  public void acceptVisitor(){}

}
