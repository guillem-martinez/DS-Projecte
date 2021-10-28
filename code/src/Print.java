public class Print implements Visitor {

  private Event root;
  private static Print instance; //Singleton Printer

  public Print(Event rootF){


    root = rootF; //We save the father of the tree in the printer for recursive printer
    rootF.acceptVisitor(this); //hacemos que el Proyecto padre acepte un visitor
  }


  public static Print getInstance(Event rootF) {
    if(instance==null){
      instance = new Print(rootF);
    }
    return instance;
  }

  public void printerInterval(){
    root.acceptVisitor(this);

  }


  public void visitTask(Task t) {
    System.out.println("Task: " + t.getName()+ "\t" + "child of: " + t.getFather().getName() + "\t"+ t.getInitTime() + "\t"+"Duration: " + t.getDuration());
  }
  //task.toString() devuelve esto
  //Task T1 Parent:P1 Duration: 1h24min3s


  @Override
  public void visitInterval(Interval i) {
    System.out.println("Interval "+ "child of " + i.getTask().getName() + "\t" +  i.getInitTime()+"\tFinal: "+i.getEndTime());
  }

  public void visitProject(Project p) {

    if(p.getFather() == null){
      System.out.println("\n----------------------------------------");
      System.out.println("Project: "+p.getName()+"\t" + "child of null" + "\t"+ p.getInitTime()+  "\t"+"Duration: "+p.getDuration());
    }
    else{
      System.out.println("Project: "+p.getName()+"\t" + "child of: " + p.getFather().getName() + "\t"+ p.getInitTime()+ "\t"+"Duration: "+p.getDuration());
    }

  }

}
