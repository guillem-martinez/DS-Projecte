import java.time.LocalDateTime;
import java.util.Observer;
import java.time.Duration;
import java.util.Observable;

public class Interval implements Observer {

  private LocalDateTime initTime;
  private LocalDateTime endTime;
  private Duration duration;

  @Override
  public void update(Observable o, Object arg) {

  }
}
