public class Client {

  public static void main(String[] args) {

    Clock clock = Clock.getInstance();

    Project master = new Project("Padre", null);
    Task t1 = new Task("Tasca1", master);
    Project p1 = new Project("Project1", master);
    Task t2 = new Task("Tasca2", p1);
    Project p2 = new Project("Project2", p1);
    Task t3 = new Task("Tasca3", p2);
    Task t4 = new Task("Tasca4", p2);

    //crear el printer i ir printeando el arbol aunque sea con las tasks sin duracion





  }


}
