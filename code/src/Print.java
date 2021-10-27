public class Print implements Visitor {

  public Print(Event root){
    root.acceptVisitor(this); //hacemos que el Proyecto padre acepte un visitor
  }
  public void visitTask(Task t) {
    System.out.println("Task: "+t.getName()+"Duration"+t.getDuration());
  }

  public void visitProject(Project p) {

    System.out.println("Project: "+p.getName()+"Duration"+p.getDuration());
  }

}
