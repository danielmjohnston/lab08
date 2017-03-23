import java.util.*;

public abstract class Event
{
  protected Random Rand = new Random();
  protected int freq, count = 0;
  protected boolean isExpense;
  protected String label;
  protected double prob;
  protected MyDate startDate;
  protected MyDate currentDate;

  abstract void step(MyDate swag);
 

  abstract boolean isHap(MyDate curDate);
  
  abstract String printString();

}
