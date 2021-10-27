public class Print implements Visitor {
  public void visitTask(Task t) {
    System.out.println(t.getName());
  }

  public void visitProject(Project p) {
    System.out.println(p.getName());
  }

}
