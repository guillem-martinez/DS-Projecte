public class Print implements Visitor {
  public void visitTask(Task t) {
    System.out.println("Task: "+t.getName()+"Duration"+t.getDuration());
  }

  public void visitProject(Project p) {

    System.out.println("Project: "+p.getName()+"Duration"+p.getDuration());
  }

}
