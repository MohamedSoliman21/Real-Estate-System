package Classes;
public interface Observable
{
 public void AddObserver( Observer observer );

 public void removeObserver( Observer observer );

 public void notifyObservers();
}
