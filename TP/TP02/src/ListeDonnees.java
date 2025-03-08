import java.util.ArrayList;
import valorisable.Valorisable;

public class ListeDonnees<E extends Valorisable> extends ArrayList<E> {
  public Double total() {
    double total = 0.0;
    for (E element : this) {
      total += element.getValeur().doubleValue();
    }
    return total;
  }

  public Number moyenne() {
    return this.isEmpty() ? 0 : total() / this.size();
  }
}