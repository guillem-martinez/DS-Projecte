import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//PREGUNTAR POR LOGGERS I DBC
public class Print implements Visitor {

  private Event root;
  private static Print instance; //Singleton Printer
  private  Logger logger = LoggerFactory.getLogger(Print.class);

  public Print(Event rootF) {
    root = rootF; //We save the father of the tree in the printer for recursive printer
    rootF.acceptVisitor(this); //To start printing the tree by the root
  }

  public static Print getInstance(Event rootF) {
    if (instance == null) {
      instance = new Print(rootF);
    }
    return instance;
  }




  public void printInterval() {
    root.acceptVisitor(this);
  }

  private String dateFormatter(LocalDateTime dt) {
    String formated;
    if (dt == null) {
      formated = "null";
    } else {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      formated = dt.format(formatter);
    }
    return formated;
  }

  @Override
  public void visitTask(Task t) {
/*
    System.out.println("Task: " + t.getName()
        + "\t" + "child of " + t.getFather().getName()
        + "\t" + this.dateFormatter(t.getInitTime())
        + "\t" + this.dateFormatter(t.getEndTime())
        + "\t" + "Duration: " + t.humanReadableFormat(t.getDuration()));*/
    logger.info("Task: " + t.getName()
        + "\t" + "child of " + t.getFather().getName()
        + "\t" + this.dateFormatter(t.getInitTime())
        + "\t" + this.dateFormatter(t.getEndTime())
        + "\t" + "Duration: " + t.humanReadableFormat(t.getDuration()));
  }

  @Override
  public void visitInterval(Interval i) {
    System.out.println("Interval " + "child of " + i.getTask().getName()
        + "\t" + this.dateFormatter(i.getInitTime())
        + "\t" + "Final: " + this.dateFormatter(i.getEndTime()));
  }

  public void visitProject(Project p) {
    if (p.getFather() == null) { //If it's the root shows that it hasn't got a father
      System.out.println("\n----------------------------------------");
      System.out.println("Project: " + p.getName()
          + "\t" + "child of null"
          + "\t" + this.dateFormatter(p.getInitTime())
          + "\t" + this.dateFormatter(p.getEndTime())
          + "\t" + "Duration: " + p.humanReadableFormat(p.getDuration()));
    } else {
      System.out.println("Project: " + p.getName()
          + "\t" + "child of: " + p.getFather().getName()
          + "\t" + this.dateFormatter(p.getInitTime())
          + "\t" + this.dateFormatter(p.getEndTime())
          + "\t" + "Duration: " + p.humanReadableFormat(p.getDuration()));
    }
  }


}
