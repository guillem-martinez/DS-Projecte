public class Print implements Visitor {

  public Print(Event root){
    root.acceptVisitor(this); //hacemos que el Proyecto padre acepte un visitor
  }

  public void visitTask(Task t) {
    System.out.println("Task: " + t.getName()+ "\t" + "Father: " + t.getFather().getName() + "\t"+"Duration: " + t.getDuration() + "\n");
  }
  //task.toString() devuelve esto
  //Task T1 Parent:P1 Duration: 1h24min3s

  /*
  @Override
  public void visitInterval(Interval i) {
    System.out.println("Inici: "+i.getInitTime()+"Final: "+i.getEndTime());
  }
  */
  public void visitProject(Project p) {

    if(p.getFather() == null){
      System.out.println("Project: "+p.getName()+"\t" + "ROOT" + "\t"+"Duration: "+p.getDuration()+"\n");
    }
    else{
      System.out.println("Project: "+p.getName()+"\t" + "Father: " + p.getFather().getName() + "\t"+"Duration: "+p.getDuration()+"\n");
    }

  }

}
